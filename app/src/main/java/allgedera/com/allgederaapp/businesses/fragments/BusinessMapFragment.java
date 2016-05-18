package allgedera.com.allgederaapp.businesses.fragments;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
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
import com.google.android.gms.maps.model.Polyline;

import java.util.HashMap;
import java.util.List;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.businesses.entities.Business;


public class BusinessMapFragment extends Fragment {
    public static GoogleMap map;
    public static Location myLocation = null;
    public static Polyline currentPath = null;
    public HashMap<Marker, Business> mapBusinesses = new HashMap<Marker, Business>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_businesses_map, container, false);
        map = getMapFragment().getMap();
        map.setInfoWindowAdapter(onBusinessInfoWindowClickListener);
        map.setMyLocationEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(false);
        goToMyLocation();
        return view;
    }

    private SupportMapFragment getMapFragment() {
        FragmentManager fm;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            fm = getChildFragmentManager();
        } else {
            fm = getChildFragmentManager();
        }
        return (SupportMapFragment) fm.findFragmentById(R.id.businesses_map);
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

    public void setBusinessOnMap(List<Business> businesses) {

        map.clear();
        //map.setOnInfoWindowClickListener(onBusinessInfoWindowClickListener);
        for (Business business : businesses) {
            LatLng latLng = new LatLng(business.getLatitude(), business.getLongitude());
            String name = business.getName();
            String address = business.getAddress();
            MarkerOptions op = new MarkerOptions()
                    .position(latLng)
                    .title(name)
                    .snippet(address + "\n" + getActivity().getResources().getString(R.string.press_to_see_more));
            //.icon(BitmapDescriptorFactory.fromResource(R.drawable.img_pin))
            Marker m = map.addMarker(op);
            mapBusinesses.put(m, business);
        }
    }

    GoogleMap.InfoWindowAdapter onBusinessInfoWindowClickListener = new GoogleMap.InfoWindowAdapter() {
        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            Business business = mapBusinesses.get(marker);
            BusinessDialogFragment businessDialogFragment = new BusinessDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("Business", business);
            businessDialogFragment.setArguments(bundle);
            businessDialogFragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
            businessDialogFragment.show(getActivity().getSupportFragmentManager(), "Business");
            return businessDialogFragment.getView();
        }
    };

}
