package com.learntodroid.simplecalculator;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void buttonsWithNumbersShown() {
        onView(withId(R.id.fragment_calculator_0)).check(matches(withText("0")));
        onView(withId(R.id.fragment_calculator_1)).check(matches(withText("1")));
        onView(withId(R.id.fragment_calculator_2)).check(matches(withText("2")));
        onView(withId(R.id.fragment_calculator_3)).check(matches(withText("3")));
        onView(withId(R.id.fragment_calculator_4)).check(matches(withText("4")));
        onView(withId(R.id.fragment_calculator_5)).check(matches(withText("5")));
        onView(withId(R.id.fragment_calculator_6)).check(matches(withText("6")));
        onView(withId(R.id.fragment_calculator_7)).check(matches(withText("7")));
        onView(withId(R.id.fragment_calculator_8)).check(matches(withText("8")));
        onView(withId(R.id.fragment_calculator_9)).check(matches(withText("9")));
    }

    @Test
    public void buttonsWithOperationsShown() {
        onView(withId(R.id.fragment_calculator_add)).check(matches(withText("+")));
        onView(withId(R.id.fragment_calculator_subtract)).check(matches(withText("-")));
        onView(withId(R.id.fragment_calculator_multiply)).check(matches(withText("×")));
        onView(withId(R.id.fragment_calculator_divide)).check(matches(withText("÷")));
        onView(withId(R.id.fragment_calculator_equals)).check(matches(withText("=")));
    }

    @Test
    public void buttonsForManipulatingInputShown() {
        onView(withId(R.id.fragment_calculator_clearEntry)).check(matches(withText("CE")));
        onView(withId(R.id.fragment_calculator_clearAll)).check(matches(withText("C")));
        onView(withId(R.id.fragment_calculator_backSpace)).check(matches(withText("BACK")));
    }

    @Test
    public void calculation_additionTest() {
        onView(withId(R.id.fragment_calculator_1)).perform(click());
        onView(withId(R.id.fragment_calculator_add)).perform(click());
        onView(withId(R.id.fragment_calculator_1)).perform(click());
        onView(withId(R.id.fragment_calculator_equals)).perform(click());
        onView(withId(R.id.fragment_calculator_result)).check(matches(withText("2")));
    }

    @Test
    public void calculation_subtractTest() {
        onView(withId(R.id.fragment_calculator_5)).perform(click());
        onView(withId(R.id.fragment_calculator_9)).perform(click());
        onView(withId(R.id.fragment_calculator_subtract)).perform(click());
        onView(withId(R.id.fragment_calculator_2)).perform(click());
        onView(withId(R.id.fragment_calculator_4)).perform(click());
        onView(withId(R.id.fragment_calculator_equals)).perform(click());
        onView(withId(R.id.fragment_calculator_result)).check(matches(withText("35")));
    }

    @Test
    public void calculation_multiplicationTest() {
        onView(withId(R.id.fragment_calculator_6)).perform(click());
        onView(withId(R.id.fragment_calculator_0)).perform(click());
        onView(withId(R.id.fragment_calculator_multiply)).perform(click());
        onView(withId(R.id.fragment_calculator_1)).perform(click());
        onView(withId(R.id.fragment_calculator_0)).perform(click());
        onView(withId(R.id.fragment_calculator_equals)).perform(click());
        onView(withId(R.id.fragment_calculator_result)).check(matches(withText("600")));
    }

    @Test
    public void calculation_divisionTest() {
        onView(withId(R.id.fragment_calculator_9)).perform(click());
        onView(withId(R.id.fragment_calculator_9)).perform(click());
        onView(withId(R.id.fragment_calculator_9)).perform(click());
        onView(withId(R.id.fragment_calculator_divide)).perform(click());
        onView(withId(R.id.fragment_calculator_3)).perform(click());
        onView(withId(R.id.fragment_calculator_3)).perform(click());
        onView(withId(R.id.fragment_calculator_3)).perform(click());
        onView(withId(R.id.fragment_calculator_equals)).perform(click());
        onView(withId(R.id.fragment_calculator_result)).check(matches(withText("3")));
    }
}