package allgedera.com.allgederaapp.businesses;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.businesses.expandable.list.BusinessChild;
import allgedera.com.allgederaapp.businesses.expandable.list.BusinessExpandableAdapter;
import allgedera.com.allgederaapp.businesses.expandable.list.BusinessParent;
import allgedera.com.allgederaapp.businesses.expandable.list.DividerItemDecoration;
import allgedera.com.allgederaapp.rest.RestAPI;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusinessesIndexFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.ItemDecoration mItemDecoration;
    public BusinessMapFragment mMapFragmant;

    public BusinessesIndexFragment() {
        mMapFragmant = new BusinessMapFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_businesses_index, container, false);

        mRecyclerView = (RecyclerView) myView.findViewById(R.id.businessRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(mItemDecoration);
        mRecyclerView.setItemAnimator(new SlideInUpAnimator());

        requestBusinesses();
        return myView;
    }

    public void requestBusinesses() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(RestAPI.BASE_URL).build();
        /*
         *  create an instance of the api that implements the methods needed to
         *  make requests to the server
         */
        RestAPI restAPI = adapter.create(RestAPI.class);
        /*
         *  call the restAPI.getBusinesses method which is responsible for requesting
         *  and retrieving the businesses from the server
         */
        restAPI.getBusinesses(new Callback<List<Business>>() {
            @Override
            public void success(List<Business> businesses, Response response) {
                /*
                 * this method is activated if the request from the server is
                 * successful
                 */
                //businesses = businesses;
                BusinessExpandableAdapter mBusinessExpandableAdapter = new BusinessExpandableAdapter(getContext(), generateBusinessList(businesses));
                //mBusinessExpandableAdapter.setCustomParentAnimationViewId(R.id.parent_list_item_expand_arrow);
                mBusinessExpandableAdapter.setParentClickableViewAnimationDefaultDuration();
                mBusinessExpandableAdapter.setParentAndIconExpandOnClick(true);
                mRecyclerView.setAdapter(mBusinessExpandableAdapter);

                mMapFragmant.setBusinessOnMap(businesses);
            }

            @Override
            public void failure(RetrofitError error) {
                /*
                 * this method is activated should the request to the server fails
                 */
                Log.d("Error: ", "failed to retrieve data from rest server");
                error.printStackTrace();
            }
        });
    }

    private ArrayList<ParentObject> generateBusinessList(List<Business> businesses) {
        ArrayList<ParentObject> parentObjects = new ArrayList<>();

        for (Business business : businesses) {
            BusinessParent businessParent = new BusinessParent(business.getName(), business.getCategory());
            ArrayList<Object> childList = new ArrayList<>();
            childList.add(new BusinessChild(business.getImage(), business.getAbout(), business.getAddress(), business.getPhone(), business.getX_geo(), business.getY_geo()));
            businessParent.setChildObjectList(childList);
            parentObjects.add(businessParent);
        }
        return parentObjects;
    }

}
