package com.zhufk.customrxjava;

/**
 * @ClassName Observer
 * @Description 观察者
 * @Author zhufk
 * @Date 2019/12/19 14:28
 * @Version 1.0
 */
public interface Observer<T> {
    void onSubscribe();

    void onNext(T t);

    void onError(Throwable e);

    void onComplete();
}
