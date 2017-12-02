package com.gig.gio.search_by_counterparty;


import android.support.test.espresso.AmbiguousViewMatcherException;
import android.support.test.espresso.NoMatchingViewException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by georgy on 29.11.2017.
 * GIG
 */

public class TestUtil {
    public static void sleepWhileNotDisplayed(int id, int stepCount, int timeSleep) {
        int tmpStepCount = 0;

        do {
            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tmpStepCount++;

            try {
                onView(withId(id)).check(matches(isDisplayed()));
                break;
            } catch (NoMatchingViewException | AmbiguousViewMatcherException e) {
                e.printStackTrace();

            }

        } while (tmpStepCount != stepCount);
    }
}
