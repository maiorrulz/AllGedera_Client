package allgedera.com.allgederaapp.coupons.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.businesses.fragments.BusinessMapFragment;
import allgedera.com.allgederaapp.coupons.entities.Coupon;

/**
 * Created by user0 on 15/05/2016.
 */
public class CouponBusinessDialogFragment extends DialogFragment implements View.OnClickListener {

    private Coupon coupon;
    private Button btnNav;
    private ImageView imgExit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        coupon = (Coupon) getArguments().getSerializable("Coupon");
        //myLocation = (Location) getArguments().getSerializable("myLocation");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coupon_business_dialog, container, false);

        imgExit = (ImageView) view.findViewById(R.id.couponBusiness_img_exit);
        imgExit.setOnClickListener(this);

        btnNav = (Button) view.findViewById(R.id.couponBusiness_btn_nav);
        btnNav.setOnClickListener(this);

        TextView tvName = ((TextView) view.findViewById(R.id.couponBusiness_tv_name));
        if (coupon.getName() != null)
            tvName.setText(coupon.getName());
        TextView tvAdress = ((TextView) view.findViewById(R.id.tv_fragment_work_about));
        if (coupon.getAddress() != null)
            tvAdress.setText(coupon.getAddress());

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.img_exit)
        {
            dismiss();
        }
        else if (view.getId() == R.id.couponBusiness_btn_nav) {
            final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?" + "saddr=" + BusinessMapFragment.myLocation.getLatitude() + "," + BusinessMapFragment.myLocation.getLongitude() + "&daddr=" + coupon.getLatitude() + "," + coupon.getLongitude()));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            startActivity(intent);
            dismiss();
        }

    }

}
