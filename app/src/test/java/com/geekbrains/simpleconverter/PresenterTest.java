package com.geekbrains.simpleconverter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class PresenterTest {
    private Presenter presenter;
    @Before
    public void init(){
        presenter=new Presenter(mock(MainView.class));
    }
    @Test
    public void presenter_test(){
        assertEquals(presenter.getMS("Hello world!"),"0,00 m/s");
        assertEquals(presenter.getMS(null),"0,00 m/s");
        assertEquals(presenter.getMS("0"),"0,00 m/s");
        assertEquals(presenter.getMS(""),"0,00 m/s");
        assertEquals(presenter.getMS(" "),"0,00 m/s");
        assertEquals(presenter.getMS("ass.a "),"0,00 m/s");
        assertEquals(presenter.getMS("a 36.0 "),"0,00 m/s");
        assertEquals(presenter.getMS(" 36.0 "),"10,00 m/s");
        assertEquals(presenter.getMS("36,0 "),"10,00 m/s");
    }

    @After
    public void close(){
        presenter=null;
    }
}
