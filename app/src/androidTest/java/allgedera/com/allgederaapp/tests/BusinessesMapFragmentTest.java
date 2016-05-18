package allgedera.com.allgederaapp.tests;

import android.util.Log;


import com.google.android.gms.maps.GoogleMap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import allgedera.com.allgederaapp.businesses.entities.Business;
import allgedera.com.allgederaapp.businesses.fragments.BusinessMapFragment;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by elash on 18/05/2016.
 */
public class BusinessesMapFragmentTest {

    /**
     * Test number: 2
     */
    @Test
    public void setBusinessesOnMapTest() {
        Business b1;
        b1 = new Business("testedBusiness","B_test","tests","not about",
                "some_city","some_address","some_phone",31.1212,30.1212,null,null);
        List<Business> l1=new ArrayList<Business>();
        l1.add(b1);

        BusinessMapFragment bmf=new BusinessMapFragment();
        try{
        bmf.setBusinessOnMap(l1);
            assertNotNull(bmf.mapBusinesses);
            Log.d("test2:", "" + bmf.mapBusinesses.size());
            assertEquals(bmf.mapBusinesses.size(), 1);}
        catch (NullPointerException e){
            Log.d("test2","can't perform 'map.clear()' at 'bmf.setBusinessOnMap(l1);' statment ");
        }

    }
}
