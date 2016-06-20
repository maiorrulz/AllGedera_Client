package allgedera.com.allgederaapp.businesses.expandable.list;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import allgedera.com.allgederaapp.R;


public class BusinessChildViewHolder extends ChildViewHolder {

    public ImageView mBusinessImageIV;
    public TextView mBusinessAboutTV;
    public TextView mBusinessCenterBusinessOnMapBTN;

    public BusinessChildViewHolder(View itemView) {
        super(itemView);
        mBusinessImageIV = (ImageView) itemView.findViewById(R.id.iv_businessImage);
        mBusinessAboutTV = (TextView) itemView.findViewById(R.id.tv_businessAbout);
        mBusinessCenterBusinessOnMapBTN = (Button) itemView.findViewById(R.id.btn_centerBusinessOnMap);
    }

}
