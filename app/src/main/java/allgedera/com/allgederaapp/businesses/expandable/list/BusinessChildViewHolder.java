package allgedera.com.allgederaapp.businesses.expandable.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import allgedera.com.allgederaapp.R;

/**
 * Created by user0 on 03/04/2016.
 */
public class BusinessChildViewHolder extends ChildViewHolder {

    public ImageView mBusinessImageIV;
    public TextView mBusinessAboutTV;
    public TextView mBusinessAddressTV;
    public TextView mBusinessPhoneTV;

    public BusinessChildViewHolder(View itemView) {
        super(itemView);
        mBusinessImageIV = (ImageView) itemView.findViewById(R.id.iv_businessImage);
        mBusinessAboutTV = (TextView) itemView.findViewById(R.id.tv_businessAbout);
        mBusinessAddressTV = (TextView) itemView.findViewById(R.id.tv_businessAddress);
        mBusinessPhoneTV = (TextView) itemView.findViewById(R.id.tv_businessPhone);
    }

}
