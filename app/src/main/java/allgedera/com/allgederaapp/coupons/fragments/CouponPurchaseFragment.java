package allgedera.com.allgederaapp.coupons.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.rest.RestAPI;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by user0 on 16/04/2016.
 */
public class CouponPurchaseFragment extends Fragment {

    public int couponId;
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
