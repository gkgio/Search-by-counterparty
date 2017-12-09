package com.gig.gio.search_by_counterparty;

import android.support.test.rule.ActivityTestRule;

import android.test.suitebuilder.annotation.LargeTest;

import com.gig.gio.search_by_counterparty.common.Order;
import com.gig.gio.search_by_counterparty.common.OrderedRunner;
import com.gig.gio.search_by_counterparty.ui.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(OrderedRunner.class)
public class SmokeTests {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    @Order(1)
    public void sidebarTest() {
        new SidebarTest().startSidebarTest();
    }

    @Test
    @Order(2)
    public void detailOpenAndMenuTest() {
        new DetailOpenAndMenuTest().startDetailOpenAndMenuTest();
    }

    @Test
    @Order(3)
    public void mapTest() {
        new MapTest().startMapTest();
    }

    @Test
    @Order(4)
    public void bookmarkAndSearchTest() {
        new BookmarkAndSearchTest().startBookmarkTest();
    }
}
