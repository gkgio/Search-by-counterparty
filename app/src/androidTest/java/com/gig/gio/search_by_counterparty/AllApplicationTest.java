package com.gig.gio.search_by_counterparty;


import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.gig.gio.search_by_counterparty.ui.main.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import android.support.test.uiautomator.UiDevice;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static android.support.test.espresso.assertion.ViewAssertions.matches;


@LargeTest
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AllApplicationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void a_sidebarTest() {

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

    @Test
    public void b_allApplicationTest() {

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

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

        TestUtil.sleepWhileNotDisplayed(R.id.btnOpenBookmarks, 25, 500);

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btnOpenBookmarks), withText("Недавние и избранные"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton6.perform(click());

        TestUtil.sleepWhileNotDisplayed(R.id.toolbar, 25, 500);

        ViewInteraction appCompatImageButton7 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton7.perform(click());

        TestUtil.sleepWhileNotDisplayed(R.id.etAutoComplete, 25, 500);

        appCompatAutoCompleteTextView.check(matches(isDisplayed()));
        appCompatAutoCompleteTextView.perform(replaceText("r"), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView7 = onView(
                allOf(withId(R.id.etAutoComplete), withText("r"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                1),
                        isDisplayed()));
        appCompatAutoCompleteTextView7.perform(replaceText("rt"));

        ViewInteraction appCompatAutoCompleteTextView10 = onView(
                allOf(withId(R.id.etAutoComplete), withText("rt"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                1),
                        isDisplayed()));
        appCompatAutoCompleteTextView10.perform(replaceText("r"));

        ViewInteraction appCompatAutoCompleteTextView11 = onView(
                allOf(withId(R.id.etAutoComplete), withText("r"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                1),
                        isDisplayed()));
        appCompatAutoCompleteTextView11.perform(closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView12 = onView(
                allOf(withId(R.id.etAutoComplete), withText("r"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                1),
                        isDisplayed()));
        appCompatAutoCompleteTextView12.perform(click());

        onData(equalTo("ОАО \"ИМПЕКТ\"")).inRoot(RootMatchers.isPlatformPopup()).perform(click());

        TestUtil.sleepWhileNotDisplayed(R.id.toolbar, 25, 500);

        ViewInteraction appCompatImageButton8 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1)));
        appCompatImageButton8.perform(scrollTo(), click());

        TestUtil.sleepWhileNotDisplayed(R.id.btnOpenBookmarks, 25, 500);

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btnOpenBookmarks), withText("Недавние и избранные"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton7.perform(click());

        TestUtil.sleepWhileNotDisplayed(R.id.rvBookmarks, 25, 500);

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rvBookmarks),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                3)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

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

        ViewInteraction appCompatImageButton9 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1)));
        appCompatImageButton9.perform(scrollTo(), click());

        TestUtil.sleepWhileNotDisplayed(R.id.btnOpenBookmarks, 25, 500);

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.btnOpenBookmarks), withText("Недавние и избранные"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton8.perform(click());

        TestUtil.sleepWhileNotDisplayed(R.id.etSearch, 25, 500);

        ViewInteraction appCompatAutoCompleteTextView15 = onView(
                allOf(withId(R.id.etSearch),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatAutoCompleteTextView15.perform(replaceText(""), closeSoftKeyboard());

        ViewInteraction appCompatAutoCompleteTextView16 = onView(
                allOf(withId(R.id.etSearch),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatAutoCompleteTextView16.perform(click());

        ViewInteraction appCompatAutoCompleteTextView17 = onView(
                allOf(withId(R.id.etSearch),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                1),
                        isDisplayed()));
        appCompatAutoCompleteTextView17.perform(replaceText("d"), closeSoftKeyboard());

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
