package com.ui.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.fourBtnsActivity;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
//============================================================================================
//============================================================================================

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.describedAs;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Alex on 4/23/2016.
 */
@RunWith(AndroidJUnit4.class)
public class BusinessTest {

    @Rule
    public ActivityTestRule<fourBtnsActivity> mActivityRule =new ActivityTestRule<>(fourBtnsActivity.class);

    @Test
    public void getToBusinesses() {
        onView(withId(R.id. btn_buisnesses)).perform(click());

        onView(withId(R.id.pagerTabStrip)).check(matches(isDisplayed()));


    }

    @Test
    public void getToSpecificBusiness() {
        onView(withId(R.id.btn_buisnesses)).perform(click());
        onView(allOf(withId(R.id.businessRecyclerView), isDisplayed())).perform(click());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.businessRecyclerView)).check(matches(isDisplayed()));

    }


//        @Test
//        public void changeText_newActivity() {
//            // Type text and then press the button.
//            onView(withId(R.id.inputField)).perform(typeText("NewText"),
//                    closeSoftKeyboard());
//            onView(withId(R.id.switchActivity)).perform(click());
//
//            // This view is in a different Activity, no need to tell Espresso.
//            onView(withId(R.id.resultView)).check(matches(withText("NewText")));
//        }
    }