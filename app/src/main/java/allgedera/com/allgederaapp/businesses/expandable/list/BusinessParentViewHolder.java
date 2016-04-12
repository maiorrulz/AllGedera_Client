package allgedera.com.allgederaapp.businesses.expandable.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import allgedera.com.allgederaapp.R;

/**
 * Created by user0 on 03/04/2016.
 */
public class BusinessParentViewHolder extends ParentViewHolder {

    public TextView mBusinessNameTV;
    public ImageView mBusinessLogoIV;

    public BusinessParentViewHolder(View itemView) {
        super(itemView);
        mBusinessNameTV = (TextView) itemView.findViewById(R.id.tv_businessName);
        mBusinessLogoIV = (ImageView) itemView.findViewById(R.id.iv_businessLogo);
    }
}
