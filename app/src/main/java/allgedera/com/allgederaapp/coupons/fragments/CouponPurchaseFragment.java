package allgedera.com.allgederaapp.coupons.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import allgedera.com.allgederaapp.R;

public class CouponPurchaseFragment extends Fragment {

    public int couponId, price;
    public TextView mPurchaseHeader;
    public ImageView mPurchaseImage;
    public TextView mPurchaseDetails;
    public Button mMakePurchase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coupon_purchase, container, false);
        mPurchaseHeader = (TextView) view.findViewById(R.id.tv_purchaseHeader);
        mPurchaseImage = (ImageView) view.findViewById(R.id.iv_purchaseImage);
        mPurchaseDetails = (TextView) view.findViewById(R.id.tv_purchaseDetails);
        mMakePurchase = (Button) view.findViewById(R.id.btn_makePurchase);
        mPurchaseDetails.setText("");
        this.couponId = -1;
        return view;
    }



}
