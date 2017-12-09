package com.gig.gio.search_by_counterparty;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.RootMatchers;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.gig.gio.search_by_counterparty.common.TestUtil;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.gig.gio.search_by_counterparty.common.TestUtil.sleep;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by georgy on 09.12.2017.
 * GIG
 */

public class MapTest {
    public MapTest() {
    }

    public void startMapTest(){
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

        TestUtil.sleepWhileNotDisplayed(R.id.btnOpenMap, 25, 500);

        ViewInteraction appCompatButtonMap = onView(
                allOf(withId(R.id.btnOpenMap), withText("На карте"),
                        childAtPosition(
                                allOf(withId(R.id.btnLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                10)),
                                1)));
        appCompatButtonMap.perform(scrollTo(), click());

        TestUtil.sleepWhileNotDisplayed(R.id.toolbar, 25, 500);

        ViewInteraction appCompatImageButtonToolbarBack = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButtonToolbarBack.perform(click());

        TestUtil.sleepWhileNotDisplayed(R.id.btnDeleteFromLatest, 25, 500);

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btnDeleteFromLatest), withText("Удалить из недавних"),
                        childAtPosition(
                                allOf(withId(R.id.btnLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                10)),
                                0)));
        appCompatButton4.perform(scrollTo(), click());

        appCompatButtonMap.check(matches(isDisplayed()));
        appCompatButtonMap.perform(scrollTo(), click());

        TestUtil.sleepWhileNotDisplayed(R.id.toolbar, 25, 500);

        appCompatImageButtonToolbarBack.check(matches(isDisplayed()));
        appCompatImageButtonToolbarBack.perform(click());

        TestUtil.sleepWhileNotDisplayed(R.id.toolbar, 25, 500);

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1)));
        appCompatImageButton6.perform(scrollTo(), click());
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
