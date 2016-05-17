package allgedera.com.allgederaapp.coupons.fragments;


import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.coupons.entities.Coupon;

/**
 * A simple {@link Fragment} subclass.
 */
public class CouponMapFragment extends Fragment {

    public static GoogleMap map;
    public static Location myLocation = null;
    HashMap<Marker, Coupon> mapCouponBusinesses = new HashMap<>();
    View view = null;

    public CouponMapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_coupons_map, container, false);
            if (map == null) {
                map = getMapFragment().getMap();
                map.setInfoWindowAdapter(onCouponBusinessInfoWindowClickListener);
                map.setMyLocationEnabled(true);
                map.getUiSettings().setZoomControlsEnabled(false);
            }
        }
        goToMyLocation();
        return view;
    }

    public SupportMapFragment getMapFragment() {
        FragmentManager fm;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            fm = getChildFragmentManager();
        } else {
            fm = getChildFragmentManager();
        }
        Log.d("fm child frag manager: ", fm == null ? "sup frag null" : "sup frag not null");
        return (SupportMapFragment) fm.findFragmentById(R.id.coupons_map);
    }

    private void goToMyLocation() {
        // Get LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        // Create a criteria object to retrieve provider
        Criteria criteria = new Criteria();
        // Get the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);
        // Get Current Location
        Location myLocation = locationManager.getLastKnownLocation(provider);
        if(myLocation!=null) {
            double latitude = myLocation.getLatitude();
            double longitude = myLocation.getLongitude();
            LatLng latLng = new LatLng(latitude, longitude);
            map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            map.animateCamera(CameraUpdateFactory.zoomTo(14));
            this.myLocation = myLocation;
        }
    }

    public void setCouponsOnMap(List<Coupon> coupons) {
        map.clear();
        //map.setOnInfoWindowClickListener(onCouponBusinessInfoWindowClickListener);
        for (Coupon coupon : coupons) {
            LatLng latLng = new LatLng(coupon.getLatitude(), coupon.getLongitude());
            String name = coupon.getName();
            String address = coupon.getAddress();
            MarkerOptions op = new MarkerOptions()
                    .position(latLng)
                    .title(name)
                    .snippet(address + "\n" + getActivity().getResources().getString(R.string.press_to_see_more));
            //.icon(BitmapDescriptorFactory.fromResource(R.drawable.img_pin))
            Marker m = map.addMarker(op);
            mapCouponBusinesses.put(m, coupon);
        }
    }

    GoogleMap.InfoWindowAdapter onCouponBusinessInfoWindowClickListener = new GoogleMap.InfoWindowAdapter() {
        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            Coupon coupon = mapCouponBusinesses.get(marker);
            CouponBusinessDialogFragment couponBusinessDialogFragment = new CouponBusinessDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("Coupon", coupon);
            couponBusinessDialogFragment.setArguments(bundle);
            couponBusinessDialogFragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
            couponBusinessDialogFragment.show(getActivity().getSupportFragmentManager(), "Coupon");
            return couponBusinessDialogFragment.getView();
        }
    };
}



