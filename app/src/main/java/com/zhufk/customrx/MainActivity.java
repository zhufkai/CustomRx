package com.zhufk.customrx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zhufk.customrxjava.Function;
import com.zhufk.customrxjava.Observable;
import com.zhufk.customrxjava.ObservableOnSubscribe;
import com.zhufk.customrxjava.Observer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(Observer<? super Integer> emitter) {//? super 可写模式
                emitter.onNext(1);
            }
        })
        .subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Observable.just("D")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe() {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(Observer<? super Integer> emitter) {

            }
        })
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) {
                        return null;
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe() {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
