package allgedera.com.allgederaapp.profile.expandable.list;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import allgedera.com.allgederaapp.R;

public class PurchaseParentViewHolder extends ParentViewHolder {

    public TextView mCouponPurchased;
    public TextView mPurchaseDate;
    public TextView mDate;

    public PurchaseParentViewHolder(View itemView) {
        super(itemView);
        mCouponPurchased = (TextView) itemView.findViewById(R.id.tv_couponPurchased);
        mPurchaseDate = (TextView) itemView.findViewById(R.id.tv_purchaseDate);
        mDate = (TextView) itemView.findViewById(R.id.tv_date);
    }
}
