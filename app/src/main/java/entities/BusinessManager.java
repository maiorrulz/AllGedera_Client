package entities;

import android.util.Log;

import com.android.volley.VolleyError;
import com.parse.ParseGeoPoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import allgedera.com.allgederaapp.App;
import restaccessLayer.Coupon;
import restaccessLayer.Event;
import restaccessLayer.RestAccessLayer;
import restaccessLayer.RestCallback;

/**
 * Created by elash on 15/12/2015.
 */
public class BusinessManager {

    static int m_IsDataArrived = 0;
    static Event[] m_BusinessesList = null;
    static Coupon[] m_CouponsList = null;

    public static void loadBusinesses() {
        try {
            /**** Return "SERVER" events ****/
            RestAccessLayer rel = RestAccessLayer.getInstance(App.g_context);
            RestCallback.OnResponseSuccess success = new RestCallback.OnResponseSuccess<Event[]>() {
                @Override
                public void onSuccess(Event[] result) {
                    Log.i("matan", "Success Callback");
                    m_IsDataArrived = 1;
                    m_BusinessesList = result;
                }
            };
            RestCallback.OnResponseFailure failure = new RestCallback.OnResponseFailure() {
                @Override
                public void onFailure(Object result) {
                    m_IsDataArrived = -1; //if failed or server down or anything we don't know :) boom!
                    Log.i("matan", "RestCallback.OnResponseFailure failure " + result.toString()
                            +
                            ((VolleyError) result).getMessage());
                }
            };
            RestCallback.OnResponseSuccess success_Coupon = new RestCallback.OnResponseSuccess<Coupon[]>() {
                @Override
                public void onSuccess(Coupon[] result) {
                    Log.i("matan", "Success Callback");
                    m_IsDataArrived = 1;
                    m_CouponsList = result;
                }
            };
            RestCallback.OnResponseFailure failure_Coupon = new RestCallback.OnResponseFailure() {
                @Override
                public void onFailure(Object result) {
                    m_IsDataArrived = -1; //if failed or server down or anything we don't know :) boom!
                    Log.i("matan", "RestCallback.OnResponseFailure failure " + result.toString()
                            +
                            ((VolleyError) result).getMessage());
                }
            };
            rel.runJsonRequestGetEvent(success, failure);
            rel.runJsonRequestGetCoupons(success_Coupon,failure_Coupon);
        } catch (IOException e) {
            Log.i("matan", e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Business> getBusinesses() {
        List<Business> toReturn = new ArrayList<Business>();
        if(m_BusinessesList != null) {
            for (int i = 0; i < m_BusinessesList.length; i++) {
                Event _evt = m_BusinessesList[i];
                Business _genEvt = new Business();
                _genEvt.setName(_evt.getName());
                _genEvt.setAbout(_evt.getAbout());
                _genEvt.setAddress(_evt.getAddress());
                _genEvt.setArea(_evt.getArea());
                _genEvt.setCategoty(_evt.getCategory());
                //_genEvt.setImage(_evt.getId());
                _genEvt.setLocation(new ParseGeoPoint(_evt.getX_location(), _evt.getY_location()));
                toReturn.add(_genEvt);
            }
        }
        return  toReturn;
    }


    public static boolean existBusinesses() {
        return m_BusinessesList != null;
    }
}
