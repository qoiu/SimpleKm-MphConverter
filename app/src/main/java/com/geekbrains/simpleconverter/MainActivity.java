package com.geekbrains.simpleconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity{

    private final Observer<? super CharSequence> observer=new Observer<CharSequence>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(CharSequence sequence) {
            ((TextView)findViewById(R.id.resultView)).setText(sequence);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText=findViewById(R.id.edit_query);
        Observable<CharSequence> observable=Observable.create(new ObservableOnSubscribe<CharSequence>() {
            @Override
            public void subscribe(final ObservableEmitter<CharSequence> emitter) throws Exception {
                TextWatcher textWatcher=new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        emitter.onNext(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                };
                editText.addTextChangedListener(textWatcher);
            }
        });
        observable.safeSubscribe(observer);

    }
}
