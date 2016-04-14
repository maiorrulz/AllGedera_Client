package allgedera.com.allgederaapp.businesses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.businesses.fragments.BusinessesIndexFragment;

public class BusinessesActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private Fragment businessFragments[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businesses);

        // initialize the fragments array
        businessFragments = new Fragment[2];
        BusinessesIndexFragment businessesIndexFragment = new BusinessesIndexFragment();
        businessFragments[0] = businessesIndexFragment;
        businessFragments[1] = businessesIndexFragment.mMapFragmant;

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            /*
              * this method returns the fragment at [position]
              * position 0 - the expandable list
              * position 1 - the map
              */
            return businessFragments[position];
        }

        @Override
        public int getCount() {
            // how many pages we have
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return position == 0 ?
                    new String("אינדקס עסקים") :
                    new String("מפת עסקים");

        }
    }
}
