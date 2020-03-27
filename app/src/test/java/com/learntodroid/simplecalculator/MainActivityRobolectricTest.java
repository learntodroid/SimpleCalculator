package com.learntodroid.simplecalculator;

import android.os.Build;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.P)
public class MainActivityRobolectricTest {
    @Test
    public void clickingButton_shouldChangeMessage() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        activity.findViewById(R.id.fragment_calculator_1).performClick();
        activity.findViewById(R.id.fragment_calculator_add).performClick();
        activity.findViewById(R.id.fragment_calculator_1).performClick();
        activity.findViewById(R.id.fragment_calculator_equals).performClick();


        TextView textView = activity.findViewById(R.id.fragment_calculator_result);
        Assert.assertEquals(textView.getText(), "2");
    }
}
