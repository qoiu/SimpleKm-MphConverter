package com.geekbrains.simpleconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainView {

    Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new Presenter(this);
        final EditText editText=findViewById(R.id.edit_query);
        Button btnConvert=findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(v->setMS(editText.getText().toString()));
    }

    @Override
    public void setMS(String text) {
        ((TextView)findViewById(R.id.resultView)).setText(presenter.getMS(text));
    }

    @Override
    public void errorToast(String msg) {
        Toast.makeText(this.getBaseContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
