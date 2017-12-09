package com.gig.gio.search_by_counterparty;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.uiautomator.UiDevice;

import com.gig.gio.search_by_counterparty.common.TestUtil;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.gig.gio.search_by_counterparty.common.TestUtil.sleep;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.equalTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

/**
 * Created by georgy on 09.12.2017.
 * GIG
 */

public class DetailOpenAndMenuTest {

    public DetailOpenAndMenuTest() {
    }

    public void startDetailOpenAndMenuTest() {
        TestUtil.sleepWhileNotDisplayed(R.id.etAutoComplete, 10, 100);

        ViewInteraction appCompatAutoCompleteTextView = onView(
                allOf(withId(R.id.etAutoComplete),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                1),
                        isDisplayed()));
        appCompatAutoCompleteTextView.perform(click());

        appCompatAutoCompleteTextView.check(matches(isDisplayed()));
        appCompatAutoCompleteTextView.perform(replaceText("e"), closeSoftKeyboard());

        sleep(3000);

        onData(equalTo("ОАО \"Е2\"")).inRoot(RootMatchers.isPlatformPopup()).perform(click());

        TestUtil.sleepWhileNotDisplayed(R.id.toolbar, 25, 500);

        try {
            onView(allOf(withId(R.id.action_unbookmark), withContentDescription("Не избранная"),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.toolbar),
                                    2),
                            1))).perform(scrollTo(), click());
        } catch (NoMatchingViewException e) {
            onView(allOf(withId(R.id.action_bookmark), withContentDescription("Избранная"),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.toolbar),
                                    2),
                            1))).perform(scrollTo(), click());
        }

        try {
            onView(allOf(withId(R.id.action_bookmark), withContentDescription("Избранная"),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.toolbar),
                                    2),
                            1))).perform(scrollTo(), click());
        } catch (NoMatchingViewException e) {
            onView(allOf(withId(R.id.action_unbookmark), withContentDescription("Не избранная"),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.toolbar),
                                    2),
                            1))).perform(scrollTo(), click());
        }

        ViewInteraction actionMenuItemViewShare = onView(
                allOf(withId(R.id.action_share), withContentDescription("Share"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.toolbar),
                                        2),
                                0)));
        actionMenuItemViewShare.perform(scrollTo(), click());

        onView(allOf(withId(android.R.id.button2), withText("Отмена"))).perform(click());

        actionMenuItemViewShare.check(matches(isDisplayed()));
        actionMenuItemViewShare.perform(scrollTo(), click());

        onView(allOf(withId(android.R.id.button1), withText("OK"))).perform(click());

        //press back
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).pressBack();
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}