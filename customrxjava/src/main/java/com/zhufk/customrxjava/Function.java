package com.zhufk.customrxjava;

/**
 * @ClassName Function
 * @Description TODO
 * @Author zhufk
 * @Date 2019/12/19 15:55
 * @Version 1.0
 */
public interface Function<T, R> {
    R apply(T t);
}
