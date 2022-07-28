package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

import android.os.SystemClock;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CardiacRecorderUITest {
    @Rule
    public ActivityScenarioRule<SplashActivity> activityScenarioRule =
            new ActivityScenarioRule<>(SplashActivity.class);

    @Test
    public void checkAppName()
    {
        onView(withText("Cardiac Recorder")).check(matches(isDisplayed()));
    }

    @Test
    public void checkPrevList()
    {
        SystemClock.sleep(4000);
        Espresso.onView(withId(R.id.viewMmButton)).perform(click());
        SystemClock.sleep(4000);
    }

    @Test
    public void AddMeasurementTest() {
        SystemClock.sleep(4000);
        Espresso.onView(withId(R.id.viewMmButton)).perform(click());
        SystemClock.sleep(4000);
        Espresso.pressBack();
        Espresso.onView(withId(R.id.AddMmButton)).perform(click());
        Espresso.onView(withId(R.id.editTextDateId)).perform(ViewActions.typeText("01-02-2019"));
        Espresso.onView(withId(R.id.editTextTimeId)).perform(ViewActions.typeText("22:00"));
        Espresso.onView(withId(R.id.editTextSysId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextSysId)).perform(ViewActions.typeText("126"));
        Espresso.onView(withId(R.id.editTextDiasId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextDiasId)).perform(ViewActions.typeText("62"));
        Espresso.onView(withId(R.id.editTextHrtId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextHrtId)).perform(ViewActions.typeText("52"));
        Espresso.onView(withId(R.id.addButtonId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.addButtonId)).perform(click());
        Espresso.pressBack();
        Espresso.pressBack();
        Espresso.onView(withId(R.id.viewMmButton)).perform(click());
        SystemClock.sleep(4000);
    }
}