package allgedera.com.allgederaapp.businesses.expandable.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import allgedera.com.allgederaapp.R;


public class BusinessParentViewHolder extends ParentViewHolder {

    public TextView mBusinessNameTV;
    public TextView mBusinessCategoryTV;
    public ImageView mBusinessLogoIV;

    public BusinessParentViewHolder(View itemView) {
        super(itemView);
        mBusinessNameTV = (TextView) itemView.findViewById(R.id.tv_businessName);
        mBusinessCategoryTV = (TextView) itemView.findViewById(R.id.tv_businessCategory);
        mBusinessLogoIV = (ImageView) itemView.findViewById(R.id.iv_businessLogo);
    }
}
