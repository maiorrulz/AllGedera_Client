package allgedera.com.allgederaapp.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.coupons.entities.Purchase;
import allgedera.com.allgederaapp.menus.MainActivity;
import allgedera.com.allgederaapp.profile.entities.PurchaseChild;
import allgedera.com.allgederaapp.profile.entities.PurchaseParent;
import allgedera.com.allgederaapp.profile.expandable.list.PurchaseExpandableAdapter;
import allgedera.com.allgederaapp.profile.fragments.MainProfileFragment;
import allgedera.com.allgederaapp.profile.fragments.UserPurchasesFragment;
import allgedera.com.allgederaapp.rest.RestAPI;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class UserProfileActivity extends AppCompatActivity {

    MainProfileFragment mainProfileFragment;
    UserPurchasesFragment userPurchasesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mainProfileFragment = new MainProfileFragment();
        userPurchasesFragment = new UserPurchasesFragment();

        requestPurchases();

    }

    public void requestPurchases() {
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
        restAPI.getUserPurchases(MainActivity.user, new Callback<List<Purchase>>() {
            @Override
            public void success(List<Purchase> purchases, Response response) {
                /*
                 * this method is activated if the request from the server is
                 * successful
                 */
                //businesses = businesses;
                userPurchasesFragment.mPurchaseExpandableAdapter = new PurchaseExpandableAdapter(getApplicationContext(), generatePurchasesList(purchases));
                //mBusinessExpandableAdapter.setCustomParentAnimationViewId(R.id.parent_list_item_expand_arrow);

                int totalPaid = 0;
                for (int i = 0; i < purchases.size(); i++) {
                    Log.d("current price: ", "" + purchases.get(i).getPrice());
                    totalPaid += purchases.get(i).getPrice();
                }

                mainProfileFragment.purchaseAmount = purchases.size();
                mainProfileFragment.purchaseTotal = totalPaid;

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_profile_container, mainProfileFragment)
                        .commit();

                //mMapFragment.setBusinessOnMap(businesses);
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

    private ArrayList<ParentObject> generatePurchasesList(List<Purchase> purchases) {
        ArrayList<ParentObject> parentObjects = new ArrayList<>();

        for (Purchase purchase : purchases) {
            PurchaseParent purchaseParent = new PurchaseParent(purchase.getCoupon_id(), purchase.getDate());
            ArrayList<Object> childList = new ArrayList<>();
            childList.add(new PurchaseChild(purchase.getPrice(), purchase.getCredit_number(), purchase.getReceipt()));
            purchaseParent.setChildObjectList(childList);
            parentObjects.add(purchaseParent);
        }
        return parentObjects;
    }

    public void goToUserPurchases(View view) {

        getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.gla_there_come, R.anim.gla_there_gone)
                .replace(R.id.main_profile_container, userPurchasesFragment)
                .commit();
    }

    public void goToUserProfile(View view) {

        getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.gla_back_gone, R.anim.gla_back_come)
                .replace(R.id.main_profile_container, mainProfileFragment)
                .commit();
    }
}
