package com.gig.gio.search_by_counterparty;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.uiautomator.UiDevice;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.gig.gio.search_by_counterparty.common.TestUtil;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by georgy on 09.12.2017.
 * GIG
 */

public class SidebarTest {

    public SidebarTest() {
    }

    public void startSidebarTest(){
        TestUtil.sleepWhileNotDisplayed(R.id.toolbar, 25, 500);

        ViewInteraction appCompatImageButtonToolbar = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.toolbar),
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0)),
                        2),
                        isDisplayed()));
        appCompatImageButtonToolbar.perform(click());

        onView(allOf(childAtPosition(
                allOf(withId(R.id.design_navigation_view),
                        childAtPosition(
                                withId(R.id.nav_view),
                                0)),
                2),
                isDisplayed())).perform(click());

        //press back
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).pressBack();

        TestUtil.sleepWhileNotDisplayed(R.id.toolbar, 25, 500);

        appCompatImageButtonToolbar.check(matches(isDisplayed()));
        appCompatImageButtonToolbar.perform(click());

        onView(allOf(childAtPosition(
                allOf(withId(R.id.design_navigation_view),
                        childAtPosition(
                                withId(R.id.nav_view),
                                0)),
                3),
                isDisplayed())).perform(click());

        TestUtil.sleepWhileNotDisplayed(R.id.toolbar, 25, 500);

        appCompatImageButtonToolbar.check(matches(isDisplayed()));
        appCompatImageButtonToolbar.perform(click());

        onView(allOf(childAtPosition(
                allOf(withId(R.id.design_navigation_view),
                        childAtPosition(
                                withId(R.id.nav_view),
                                0)),
                1),
                isDisplayed())).perform(click());
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
