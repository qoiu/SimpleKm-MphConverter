package com.geekbrains.simpleconverter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConvertMainTest {
    private Convert convert;

    @Before
    public void initConvert(){
        convert = new Convert();
    }
    @Test
    public void converter_isCorrect() {
        float sourceValue = convert.convertKmHToMS(36.0f);
        assertEquals(sourceValue,10.0f,0.0);
    }

    @After
    public void close(){
        convert=null;
    }
}
