package com.zhufk.customrxjava;

/**
 * @ClassName ObservableMap
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/19 16:30
 * @Version 1.0
 */
public class ObservableMap<T,R> implements ObservableOnSubscribe<R> {

    private ObservableOnSubscribe<T> source;
    private Function<? super T, ? extends R> function;
    private Observer<? super R> emitter;

    public ObservableMap(ObservableOnSubscribe<T> source, Function<? super T, ? extends R> function) {
        this.source = source;
        this.function = function;
    }

    @Override
    public void subscribe(Observer<? super R> emitter) {
        this.emitter = emitter;
        MapObserver<T> mapObserver = new MapObserver(function, emitter);
        source.subscribe(mapObserver);//不应该把下一层observer交出去，如果交出去，map没有了控制权
    }

    class MapObserver<T> implements Observer<T> {
        private Function<? super T, ? extends R> function;
        private Observer<R> emitter;

        public MapObserver( Function<? super T, ? extends R> function, Observer<R> emitter) {
            this.function = function;
            this.emitter = emitter;
        }

        @Override
        public void onSubscribe() {
            emitter.onSubscribe();
        }

        @Override
        public void onNext(T t) {
            R apply = function.apply(t);
            emitter.onNext(apply);
        }

        @Override
        public void onError(Throwable e) {
            emitter.onError(e);
        }

        @Override
        public void onComplete() {
            emitter.onComplete();
        }
    }
}
