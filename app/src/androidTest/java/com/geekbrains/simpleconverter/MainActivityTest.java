package com.geekbrains.simpleconverter;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    private String mStringForTest;
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initStringForTest(){
        mStringForTest="36";
    }
    @Test
    public void conversionClickCheck(){
    onView(withId(R.id.edit_query)).perform(typeText( mStringForTest));
    onView(withId(R.id.btnConvert)).perform(click());
    onView(withId(R.id.edit_query)).check(matches(withText(mStringForTest)));
    onView(withId(R.id.resultView)).check(matches(withText("10.00 m/s")));

}

}
