package com.geekbrains.simpleconverter;

import android.app.Application;
import android.widget.Toast;

import java.util.Locale;

public class Presenter {
    private MainView view;
    private Convert convert;

    public Presenter(MainView view) {
        this.view = view;
        convert = new Convert();
    }

    private float stringToFloat(String text){
        if(text==null)return 0;
        text=text.replace(",",".");
        float value;
        try{
            value=Float.parseFloat(text);
        }catch (NumberFormatException e){
            view.errorToast("Wrong input text");
            return 0;
        }
        return value;
    }

    String getMS(String text){
        float value=stringToFloat(text);
        value=convert.convertKmHToMS(value);
        return String.format(Locale.getDefault(), "%.02f m/s", value);
    }
}
