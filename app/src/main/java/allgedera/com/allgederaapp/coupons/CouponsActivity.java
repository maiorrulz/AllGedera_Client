package allgedera.com.allgederaapp.coupons;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.coupons.fragments.CouponListFragment;
import allgedera.com.allgederaapp.coupons.fragments.CouponPurchaseFragment;
import tabs.SlidingTabLayout;

public class CouponsActivity extends AppCompatActivity {

    private SlidingTabLayout mTabs;
    private ViewPager mViewPager;
    private Fragment couponFragments[];
    private int tabImages[] = {R.drawable.coupon_tab_icon,
                               R.drawable.purchase_tab_icon,
                               R.drawable.map_tab_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);

        couponFragments = new Fragment[3];
        couponFragments[0] = new CouponListFragment();
        couponFragments[1] = new CouponPurchaseFragment();
        couponFragments[2] = ((CouponListFragment)couponFragments[0]).couponMapFragment;

        mViewPager = (ViewPager) findViewById(R.id.couponsPager);
        mViewPager.setAdapter(new CouponPagerAdapter(getSupportFragmentManager(), this));

        mTabs = (SlidingTabLayout) findViewById(R.id.couponsSlidingTabs);
        mTabs.setDistributeEvenly(true);
        mTabs.setCustomTabView(R.layout.coupon_tab, R.id.tv_couponTab, tabImages);
        mTabs.setViewPager(mViewPager);
    }


    private class CouponPagerAdapter extends FragmentPagerAdapter {

        String[] couponTabs;

        public CouponPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            couponTabs = context.getResources().getStringArray(R.array.coupon_tabs);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return couponTabs[position];
        }

        @Override
        public Fragment getItem(int position) {
            return couponFragments[position];
        }

        @Override
        public int getCount() {
            return couponFragments != null ? couponFragments.length
                                           : 0;
        }
    }


}
