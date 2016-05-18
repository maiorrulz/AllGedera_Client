package allgedera.com.allgederaapp.tests;

import android.util.Log;

import com.google.android.gms.maps.model.Marker;

import org.junit.Test;

import allgedera.com.allgederaapp.businesses.entities.Business;
import allgedera.com.allgederaapp.businesses.fragments.BusinessesIndexFragment;

import static org.junit.Assert.assertNotNull;


/**
 * Created by elash on 17/05/2016.
 */
public class BusinessesIndexFragmentTest {
    /**
     * Test number: 1
     */
    @Test
    public void requestBusinessesTest() {
        BusinessesIndexFragment bif=new BusinessesIndexFragment();
        bif.requestBusinesses();
        assertNotNull(bif.mMapFragment);
        assertNotNull(bif.mMapFragment.mapBusinesses);
        Log.d("Test 1", " testing");
        System.out.println("Testing 1");
        if (bif.mMapFragment.mapBusinesses != null)
            Log.d("mapBusinesses != ", "size + " + bif.mMapFragment.mapBusinesses.size());
        else
        Log.d("mapBusinesses == ", "null");
        if (bif.mMapFragment.mapBusinesses != null) {
            int counter = 0;
            for (Marker m : bif.mMapFragment.mapBusinesses.keySet()) {
                Business b = bif.mMapFragment.mapBusinesses.get(m);
                //System.out.println("Business " + counter++ + ": " + b.getName());
                Log.d("Test: ", "Business " + counter++ + ": " + b.getName());
            }
        }

    }
}
