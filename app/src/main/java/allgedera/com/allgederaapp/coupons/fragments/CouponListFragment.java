package allgedera.com.allgederaapp.coupons.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.coupons.entities.Coupon;
import allgedera.com.allgederaapp.coupons.list.CouponAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CouponListFragment extends Fragment {

    static final int coloumns = 2;

    public CouponListFragment() {  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coupon_list, container, false);
        RecyclerView couponRecyclerView = (RecyclerView) view.findViewById(R.id.couponRecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(container.getContext(), coloumns);
        couponRecyclerView.setLayoutManager(gridLayoutManager);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int itemWidth = displayMetrics.widthPixels / coloumns;
        int itemHeight = itemWidth * 4 / 3;

        CouponAdapter couponAdapter = new CouponAdapter(getCoupons(), itemWidth, itemHeight);
        couponRecyclerView.setAdapter(couponAdapter);
        return view;
    }

    private List<Coupon> getCoupons() {
        List<Coupon> coupons = new ArrayList<Coupon>();

        coupons.add(new Coupon());
        coupons.add(new Coupon());
        coupons.add(new Coupon());
        coupons.add(new Coupon());


        return coupons;
    }


}
