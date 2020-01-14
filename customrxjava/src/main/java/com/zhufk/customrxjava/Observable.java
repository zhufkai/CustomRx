package com.zhufk.customrxjava;

/**
 * @ClassName Observable
 * @Description 被观察者
 * @Author zhufk
 * @Date 2019/12/19 14:21
 * @Version 1.0
 */
public class Observable<T> {//类声明的泛型

    private ObservableOnSubscribe source;

    private Observable(ObservableOnSubscribe source) {
        this.source = source;
    }

    //静态方法声明的泛型
    //? extends 跟读写模式没有关系 正常的上限的关系
    public static <T> Observable<T> create(ObservableOnSubscribe<? extends T> source) {
        return new Observable<T>(source);
    }

    public static <T> Observable<T> just(final T... t) {//内部发送
        return new Observable<T>(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(Observer<? super T> emitter) {
                for (T t1 : t) {
                    emitter.onNext(t1);
                }
                emitter.onComplete();
            }
        });
    }

    public static <T> Observable<T> just(final T t) {
        return new Observable<T>(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(Observer<? super T> emitter) {
                emitter.onNext(t);
                emitter.onComplete();
            }
        });
    }

    public static <T> Observable<T> just(final T t, final T t1) {
        return new Observable<T>(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(Observer<? super T> emitter) {
                emitter.onNext(t);
                emitter.onNext(t1);
                emitter.onComplete();
            }
        });
    }

    /**
     * 订阅
     * ? extends 跟读写模式没有关系 正常的上限的关系
     *
     * @param observer
     */
    public void subscribe(Observer<? extends T> observer) {
        observer.onSubscribe();
        source.subscribe(observer);
    }

    public <R> Observable<R> map(Function<? extends T, ? super R> function) {//? extends T ：可读方式  ? super R ：可写模式
        ObservableMap<T, R> observableMap = new ObservableMap(source, function);
        return new Observable<R>(observableMap);
    }
}
