package allgedera.com.allgederaapp.coupons.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import allgedera.com.allgederaapp.R;

/**
 * Created by user0 on 16/04/2016.
 */
public class CouponPurchaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coupon_purchase, container, false);
        return view;
    }

}
