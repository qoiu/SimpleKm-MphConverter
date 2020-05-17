package com.geekbrains.simpleconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class MainActivity extends AppCompatActivity implements MainView {

    Presenter presenter;
    private final Observer<? super CharSequence> observer;

    public MainActivity(Observer<? super CharSequence> observer) {
        this.observer = observer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new Presenter(this);
        final EditText editText=findViewById(R.id.edit_query);
        editText.addTextChangedListener(textWatcher);
    }

    private final TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void setMS(String text) {
        ((TextView)findViewById(R.id.resultView)).setText(presenter.getMS(text));
    }

    @Override
    public void errorToast(String msg) {
        Toast.makeText(this.getBaseContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
