package allgedera.com.allgederaapp.coupons.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import allgedera.com.allgederaapp.R;

/**
 * Created by user0 on 15/04/2016.
 */
public class CouponViewHolder extends RecyclerView.ViewHolder {

    public TextView mCouponId;
    public ImageView mCouponImageIV;
    public TextView mCouponBusinessNameTV;
    public TextView mCouponPriceTV;
    public TextView mCouponDetails;

    public CouponViewHolder(View itemView) {
        super(itemView);
        mCouponId = (TextView) itemView.findViewById(R.id.tv_couponNumber);
        mCouponImageIV = (ImageView) itemView.findViewById(R.id.iv_couponImage);
        mCouponBusinessNameTV = (TextView) itemView.findViewById(R.id.tv_couponBusiness);
        mCouponPriceTV = (TextView) itemView.findViewById(R.id.tv_couponPrice);
        mCouponDetails = (TextView) itemView.findViewById(R.id.tv_couponDetails);
    }

}
