package com.zhufk.customrxjava;

/**
 * @ClassName ObservableOnSubscribe
 * @Description 发射器接口
 * @Author zhufk
 * @Date 2019/12/19 14:22
 * @Version 1.0
 */
public interface ObservableOnSubscribe<T> {

    //? super 代表可写
    void subscribe(Observer<? super T> emitter);
}
