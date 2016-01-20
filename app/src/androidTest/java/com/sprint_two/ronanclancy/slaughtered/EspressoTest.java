package com.sprint_two.ronanclancy.slaughtered;

import android.app.Activity;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by afinn on 1/18/2016.
 */



public class EspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest() {
        super(MainActivity.class);
    }

    Activity activity;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testHamburgerMenuDisplay() {
        /*
         * Click on the hamburger menu,
         * Check the drawer is displayed
         * Swipe left
         * Check the drawer is no longer displayed
         */
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.nav_view))
                .check(matches(isDisplayed()));
        onView(withId(R.id.nav_view)).perform(swipeLeft());
        onView(withId(R.id.nav_view))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
    }

    public void testNavDrawerLinks(){
        /*
            Click on the hamburger menu
            Click on each of the links in the menu
            Check something from the resulting page is displayed
         */
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withText("Slaughtered Sheep")).perform(click());
        // nothing to check here as the page is blank
        // TODO - could check toolbar title, if we could figure out how to match it
        //onView(allOf(isDescendantOfA(withResourceName("android")))).check(matches(withText("Slaughtered Sheep")));

        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withText("Home")).perform(click());
        onView(withText("Sally")).check(matches(isDisplayed()));
        onView(withText("Bessie")).check(matches(isDisplayed()));

        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withText("Settings")).perform(click());
        onView(withText("Enlarge Font Size")).check(matches(isDisplayed()));
    }
}
