package allgedera.com.allgederaapp.profile.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.menus.MainActivity;
import allgedera.com.allgederaapp.urlImages.ImageLoader;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainProfileFragment extends Fragment {

    ImageView mProfilePictureIV;
    TextView mUserNameTV;
    TextView mPurchasesAmountTV;
    TextView mTotalPurchaseSumTV;

    public int purchaseAmount;
    public int purchaseTotal;

    public MainProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_profile, container, false);

        mProfilePictureIV = (ImageView) view.findViewById(R.id.fb_userImage);
        mUserNameTV = (TextView) view.findViewById(R.id.tv_userName);
        mPurchasesAmountTV = (TextView) view.findViewById(R.id.tv_purchaseAmount);
        mTotalPurchaseSumTV = (TextView) view.findViewById(R.id.tv_totalPurchaseSum);

        mPurchasesAmountTV.setText(getString(R.string.num_of_purchases, purchaseAmount));
        mTotalPurchaseSumTV.setText(getString(R.string.total_purchase_sum, purchaseTotal));

        mUserNameTV.setText(MainActivity.user);
        //Log.d("profile image null?", MainActivity.profileImage == null ? "yes" : "no");
        if (MainActivity.profileImage != null) {
            ImageLoader imgLoader = new ImageLoader(getActivity().getApplicationContext());
            imgLoader.displayImage(MainActivity.profileImage, mProfilePictureIV);

        }

        return view;
    }


}
