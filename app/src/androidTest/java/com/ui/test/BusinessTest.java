package com.ui.test;

import android.support.test.espresso.web.webdriver.DriverAtoms;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.view.View;
import android.widget.EditText;

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
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
//============================================================================================
//============================================================================================

import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
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

    private UiDevice mDevice;


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =new ActivityTestRule<>(MainActivity.class);

    @Test
    public void businessTest() {

        onView(withId(R.id. btn_fbLogin)).perform(click());
        try {
            Thread.sleep(5000);
            onView(allOf(withId(R.id.btn_buisnesses), isDisplayed())).perform(click());
            Thread.sleep(5000);
            //onView(allOf(withId(R.id.businessRecyclerView))).perform(click());
            Matcher<View> smallTalkView = hasSibling(withText("Small Talk"));
            onView(allOf(withId(R.id.tv_businessName), smallTalkView)).perform(click());
            Thread.sleep(1500);
            onView(allOf(withId(R.id.tv_businessName), smallTalkView)).perform(click());
            Thread.sleep(1500);
            Matcher<View> pixelView = hasSibling(withText("פיקסל אלבומים גידיטליים"));
            onView(allOf(withId(R.id.tv_businessName), pixelView)).perform(click());
            Thread.sleep(1500);
            onView(allOf(withId(R.id.tv_businessName), pixelView)).perform(click());
            Thread.sleep(1500);
            pressBack();
            Thread.sleep(1500);
            onView(withId(R.id.btn_buisnesses)).check(matches(isDisplayed()));

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        //onWebView().withElement(findElement(Locator.ID, "Email or Phone")).perform(DriverAtoms.webKeys("ssss"));
//        try {
//        Thread.sleep(5000);
//        UiObject input = mDevice.findObject(new UiSelector()
//                .instance(1)
//                .className(EditText.class));
//
//            input.setText("text");
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    @Test
    public void mapToBusinessTest() {
        onView(withId(R.id.btn_fbLogin)).perform(click());
        try {
            Thread.sleep(5000);
            onView(allOf(withId(R.id.btn_buisnesses), isDisplayed())).perform(click());
            Thread.sleep(3000);
            onView((withId(R.id.pagerTabStrip))).perform(swipeLeft());
            onView(withId(R.id.map)).check(matches(isDisplayed()));
            onView((withId(R.id.pagerTabStrip))).perform(swipeRight());
            pressBack();
            Thread.sleep(3000);
            onView(withId(R.id.btn_buisnesses)).check(matches(isDisplayed()));
            //onView(allOf(withId(R.id.pagerTabStrip), withText("מפת עסקים"))).perform(click());

        } catch (Exception e) {
            e.printStackTrace();

        }
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
