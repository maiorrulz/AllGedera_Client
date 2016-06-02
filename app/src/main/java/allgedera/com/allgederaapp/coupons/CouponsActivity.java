package allgedera.com.allgederaapp.coupons;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.coupons.fragments.CouponListFragment;
import allgedera.com.allgederaapp.coupons.fragments.CouponPurchaseFragment;
import allgedera.com.allgederaapp.coupons.fragments.PaymentDialogFragment;
import allgedera.com.allgederaapp.rest.RestAPI;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
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
        CouponListFragment couponListFragment = new CouponListFragment();
        couponFragments[0] = couponListFragment;
        couponFragments[1] = new CouponPurchaseFragment();
        couponFragments[2] = couponListFragment.mCouponMapFragment;

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

    public void goToPurchase(View view)
    {
        CouponPurchaseFragment couponPurchaseFragment;
        couponPurchaseFragment = (CouponPurchaseFragment) couponFragments[1];

        TextView couponNumber = (TextView) view.findViewById(R.id.tv_couponNumber);
        ImageView couponImage = (ImageView) view.findViewById(R.id.iv_couponImage);
        TextView couponBusiness = (TextView) view.findViewById(R.id.tv_couponBusiness);;
        TextView couponPrice = (TextView) view.findViewById(R.id.tv_couponPrice);
        TextView couponDetails = (TextView) view.findViewById(R.id.tv_couponDetails);

        couponPurchaseFragment.couponId = Integer.parseInt(couponNumber.getText().toString());
        String priceStr = couponPrice.getText().toString();
        priceStr = priceStr.substring(priceStr.indexOf(":") + 2);
        couponPurchaseFragment.price = Integer.parseInt(priceStr.substring(0, priceStr.indexOf("\u20AA")));

        couponPurchaseFragment.mPurchaseHeader.setText(getString(R.string.purchase_number, Integer.parseInt(couponNumber.getText().toString())));
        couponPurchaseFragment.mPurchaseImage.setImageDrawable(couponImage.getDrawable());
        couponPurchaseFragment.mPurchaseDetails.setText(couponDetails.getText());
        couponPurchaseFragment.mMakePurchase.setEnabled(true);
        mViewPager.setCurrentItem(1);
    }

    public void goToPurchaseScreen(View view) {
        CouponPurchaseFragment couponPurchaseFragment;
        couponPurchaseFragment = (CouponPurchaseFragment) couponFragments[1];

        PaymentDialogFragment paymentDialog = new PaymentDialogFragment();
        paymentDialog.couponId = couponPurchaseFragment.couponId;
        paymentDialog.price = couponPurchaseFragment.price;
        paymentDialog.show(getFragmentManager(), "PaymentDialog");
    }

}
