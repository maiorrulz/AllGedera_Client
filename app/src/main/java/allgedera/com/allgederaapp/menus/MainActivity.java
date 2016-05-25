package allgedera.com.allgederaapp.menus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.businesses.BusinessesActivity;
import allgedera.com.allgederaapp.coupons.CouponsActivity;
import allgedera.com.allgederaapp.profile.UserProfileActivity;

public class MainActivity extends AppCompatActivity {

    static Context context;
    static FragmentManager mFragmentManager;
    static LoginFragment mLoginFragment;
    static MainFragment mMainFragment;
    static CallbackManager mCallbackManager;
    public static boolean loggedIn = false;
    public static String user;
    public static String profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        mFragmentManager = getSupportFragmentManager();

        if (!loggedIn)
            goToLogin();
        else
            goToMain();
    }

    public static void goToLogin() {

        if (mLoginFragment == null) {
            mLoginFragment = new LoginFragment();
        }

        LoginManager.getInstance().logOut();

        FragmentTransaction tx = mFragmentManager.beginTransaction();
        tx.replace(R.id.main_frame, mLoginFragment);
        tx.addToBackStack(null);
        tx.commit();
    }

    public static void goToMain() {

        if (mMainFragment == null) {
            mMainFragment = new MainFragment();
        }

        FragmentTransaction tx = mFragmentManager.beginTransaction();
        tx.replace(R.id.main_frame, mMainFragment);
        tx.addToBackStack(null);
        tx.commit();
    }

    public void openBusinesses(View view) {
        Intent intent = new Intent(this, BusinessesActivity.class);
        startActivity(intent);
    }

    public void openCoupons(View view) {
        Intent intent = new Intent(this, CouponsActivity.class);
        startActivity(intent);
    }

    public void openUserProfile(View view) {
        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
