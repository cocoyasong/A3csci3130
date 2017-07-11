package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    /**
     * test for create contact
     * @throws Exception
     */

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void create() throws Exception {
        onView(withId(R.id.createButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("Coco"), closeSoftKeyboard());
        onView(withId(R.id.number)).perform(typeText("123456789"), closeSoftKeyboard());
        onView(withId(R.id.primary)).perform(typeText("Fisher"), closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("victoria rd"), closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("NS"), closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());

    }

    /**
     * test for read contact
     */
    @Test
    public void read() throws Exception{
        onView(withId(R.id.listView)).perform(click());
    }

    /**
     * update test
     */
    @Test
    public void update() throws  Exception{
        onView(withId(R.id.createButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("Coco"), closeSoftKeyboard());
        onView(withId(R.id.number)).perform(typeText("123456789"), closeSoftKeyboard());
        onView(withId(R.id.primary)).perform(typeText("Fisher"), closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("victoria rd"), closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("NS"), closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.name)).perform(typeText("Yasong"), closeSoftKeyboard());
        onView(withId(R.id.updateButton)).perform(click());
    }

    /**
     * delete test
     */
    @Test
    public void delete() throws Exception{
        onView(withId(R.id.createButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("Coco"), closeSoftKeyboard());
        onView(withId(R.id.number)).perform(typeText("123456789"), closeSoftKeyboard());
        onView(withId(R.id.primary)).perform(typeText("Fisher"), closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("victoria rd"), closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("NS"), closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}
