package allgedera.com.allgederaapp.profile.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.businesses.expandable.list.DividerItemDecoration;
import allgedera.com.allgederaapp.profile.expandable.list.PurchaseExpandableAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserPurchasesFragment extends Fragment {

    public RecyclerView mPurchasesRecyclerView;
    private RecyclerView.ItemDecoration mItemDecoration;
    public PurchaseExpandableAdapter mPurchaseExpandableAdapter;

    public UserPurchasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_purchases, container, false);

        mPurchasesRecyclerView = (RecyclerView) view.findViewById(R.id.userPurchasesRecyclerView);
        mPurchasesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mItemDecoration = new DividerItemDecoration(getActivity().getApplicationContext(), DividerItemDecoration.VERTICAL_LIST);
        mPurchasesRecyclerView.addItemDecoration(mItemDecoration);

        mPurchaseExpandableAdapter.setParentClickableViewAnimationDefaultDuration();
        mPurchaseExpandableAdapter.setParentAndIconExpandOnClick(true);
        mPurchasesRecyclerView.setAdapter(mPurchaseExpandableAdapter);


        return view;
    }


}
