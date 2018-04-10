package com.mytaxi.android_demo;


import android.Manifest;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.After;



import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


import static android.support.test.espresso.Espresso.pressBack;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    private String username = "whiteelephant261";
    private String password = "video";
    private String searchname = "sa";

    @Rule
    public GrantPermissionRule mRuntimePermissionRule
            = GrantPermissionRule.grant(Manifest.permission.ACCESS_FINE_LOCATION);
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setActivity(){
        mActivity = mActivityRule.getActivity();

    }

    @Test
    public void demoTest() {
        login();

//        onView(withId(R.id.textSearch)).perform(click());
//        onView(withId(R.id.textSearch)).perform(typeText(searchname), closeSoftKeyboard());
//
//        onView(withText("Sarah Friedrich")).inRoot(withDecorView(not(is(mActivity.getWindow()
//                .getDecorView())))).check(matches(isDisplayed()));
//
//        onView(withText("Sarah Friedrich")).inRoot(withDecorView(not(is(mActivity.getWindow()
//                .getDecorView())))).perform(click());

    }

    public void login(){
            onView(withId(R.id.edt_username)).perform(typeText(username), closeSoftKeyboard());
            onView(withId(R.id.edt_password)).perform(typeText(password), closeSoftKeyboard());
            onView(withId(R.id.btn_login)).perform(click());
    }

    public void logout(){
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withText("Logout")).perform(click());
    }


    @After
    public void afterActivity() {
//        mActivityRule.getActivity();
//        Espresso.pressBack();
        logout();
    }
}
