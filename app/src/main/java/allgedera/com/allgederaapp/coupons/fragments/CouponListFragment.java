package allgedera.com.allgederaapp.coupons.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.coupons.entities.Coupon;
import allgedera.com.allgederaapp.coupons.list.CouponAdapter;
import allgedera.com.allgederaapp.rest.RestAPI;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CouponListFragment extends Fragment {

    static final int columns = 2;
    public CouponMapFragment mCouponMapFragment;
    private RecyclerView mCouponRecyclerView;
    private int itemWidth;
    private int itemHeight;

    public CouponListFragment() {
        mCouponMapFragment = new CouponMapFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coupon_list, container, false);
        mCouponRecyclerView = (RecyclerView) view.findViewById(R.id.couponRecyclerView);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        itemWidth = displayMetrics.widthPixels / columns;
        itemHeight = itemWidth * 4 / 3;

        //CouponAdapter couponAdapter = new CouponAdapter(getCoupons(), itemWidth, itemHeight);
        //mCouponRecyclerView.setAdapter(couponAdapter);
        requestCoupons();
        return view;
    }

    public void requestCoupons() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(RestAPI.BASE_URL).build();
        /*
         *  create an instance of the api that implements the methods needed to
         *  make requests to the server
         */
        RestAPI restAPI = adapter.create(RestAPI.class);
        /*
         *  call the restAPI.getBusinesses method which is responsible for requesting
         *  and retrieving the businesses from the server
         */
        restAPI.getCoupons(new Callback<List<Coupon>>() {
            @Override
            public void success(List<Coupon> coupons, Response response) {
                /*
                 * this method is activated if the request from the server is
                 * successful
                 */

                CouponAdapter couponAdapter = new CouponAdapter(CouponListFragment.this.getContext(), coupons, itemWidth, itemHeight);
                mCouponRecyclerView.setAdapter(couponAdapter);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(CouponListFragment.this.getContext(), columns);
                mCouponRecyclerView.setLayoutManager(gridLayoutManager);
                //mMapFragment.setBusinessOnMap(businesses);


                //mCouponMapFragment.setCouponsOnMap(coupons);
            }

            @Override
            public void failure(RetrofitError error) {
                /*
                 * this method is activated should the request to the server fails
                 */
                Log.d("Error: ", "failed to retrieve data from rest server");
                error.printStackTrace();
            }
        });
    }


}
