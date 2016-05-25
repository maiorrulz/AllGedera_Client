package allgedera.com.allgederaapp.tests;

import android.os.Bundle;

import org.junit.Assert;
import org.junit.Test;

import allgedera.com.allgederaapp.businesses.BusinessesActivity;
import allgedera.com.allgederaapp.businesses.fragments.BusinessesIndexFragment;

import static org.junit.Assert.assertEquals;

/*
 * Created by elash on 18/05/2016.
 */
public class ViewPagerAdapterTest {

    /**
     * Test number: 4
     */
    @Test
    public void getItem0Test() {
        BusinessesActivity ba= new BusinessesActivity();
        ba.onCreate(new Bundle());
        BusinessesActivity.ViewPagerAdapter vpa= (BusinessesActivity.ViewPagerAdapter)
            ba.mViewPager.getAdapter();
        assertEquals(vpa.getItem(0) instanceof BusinessesIndexFragment,true);
    }
}
