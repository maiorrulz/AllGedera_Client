package com.ui.test;

import android.provider.Settings;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.menus.MainActivity;
import allgedera.com.allgederaapp.menus.MainMenuActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
//============================================================================================
//============================================================================================

import static android.support.test.espresso.matcher.ViewMatchers.withText;
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
public class CouponTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule  = new ActivityTestRule<>(MainActivity.class,true,true);

    @After
    public void tearDown() {
        mActivityRule.getActivity().finish();
        mActivityRule  = new ActivityTestRule<>(MainActivity.class,true,true);
    }

    @Test
    public void goToCouponsAndPurchaseTest() {
        onView(withId(R.id. btn_fbLogin)).perform(click());
        try {
            Thread.sleep(5000);
            onView(allOf(withId(R.id.btn_sales), isDisplayed())).perform(click());
            Thread.sleep(3000);
            //onView(allOf(withId(R.id.businessRecyclerView))).perform(click());
            //Matcher<View> smallTalkView = hasSibling(withText("Small Talk"));
            onView(allOf(withId(R.id.tv_couponNumber), withText("1"))).perform(click());
            Thread.sleep(1500);
            onView(withId(R.id.btn_makePurchase)).perform(click());
            onView(withText("התבצעה רכישה")).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
            Thread.sleep(1500);
            pressBack();
            Thread.sleep(1500);
            pressBack();
            onView(withId(R.id.btn_buisnesses)).check(matches(isDisplayed()));

        }catch(Exception e){e.printStackTrace();}


    }

    @Test
    public void clickOnCouponViewTest() {
        onView(withId(R.id. btn_fbLogin)).perform(click());
        try {
            Thread.sleep(5000);
            onView(allOf(withId(R.id.btn_sales), isDisplayed())).perform(click());
            Thread.sleep(3000);
            //onView(allOf(withId(R.id.businessRecyclerView))).perform(click());
            //Matcher<View> smallTalkView = hasSibling(withText("Small Talk"));
            onView(allOf(withId(R.id.tv_couponTab),withText("רכישה"))).perform(click());
            Thread.sleep(1500);
            onView(allOf(withId(R.id.tv_couponTab),withText("מפה"))).perform(click());
            Thread.sleep(1500);
            onView(allOf(withId(R.id.tv_couponTab),withText("קופונים"))).perform(click());
            Thread.sleep(1500);
            pressBack();
            onView(withId(R.id.btn_buisnesses)).check(matches(isDisplayed()));

        }catch(Exception e){}
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