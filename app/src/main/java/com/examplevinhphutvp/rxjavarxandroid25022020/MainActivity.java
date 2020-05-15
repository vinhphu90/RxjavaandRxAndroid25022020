package com.examplevinhphutvp.rxjavarxandroid25022020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Bước 1 : tạo ra 1 observable
        Observable<String> observableString =
                Observable.just("1","2","3","4","5","6");
        // Buoc 2 : Lang nghe du lieu
        observableString
                .subscribeOn(Schedulers.io())
                .map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Throwable {
//                Toast.makeText(MainActivity.this, s + "", Toast.LENGTH_SHORT).show();
                return Integer.parseInt(s);
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Toast.makeText(MainActivity.this,  integer + "",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
