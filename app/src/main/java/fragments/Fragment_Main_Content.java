package fragments;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
import entities.Business;


public class Fragment_Main_Content extends Fragment {
    private String tag = "Fragment Main Content";
    public static GoogleMap map;
    public static Location myLocation = null;
    public static Polyline currentPath = null;
     HashMap<Marker, Business> mapBusinesses = new HashMap<Marker, Business>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_business_map, container, false);
        map = getMapFragment().getMap();
        map.setInfoWindowAdapter(infoWindowAdapter);
        map.setMyLocationEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(false);
        goToMyLocation();
        return v;
    }

    private SupportMapFragment getMapFragment() {
        FragmentManager fm = null;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            fm = getActivity().getSupportFragmentManager();
            fm = getChildFragmentManager();
        } else {
            fm = getChildFragmentManager();
        }
        return (SupportMapFragment) fm.findFragmentById(R.id.map);
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



    public void SetGenericEvents(List<Business> genericEvents) {

        map.clear();
        map.setOnInfoWindowClickListener(onBusinessInfoWindowClickListener);
        for (Business g : genericEvents) {
            LatLng latLng = new LatLng(g.getLocation().getLatitude(), g.getLocation().getLongitude());
            String name = g.getName();
            String address = g.getAddress();
            MarkerOptions op = new MarkerOptions()
                    .position(latLng)
                    .title(name)
                    .snippet(address + "\n" + getActivity().getResources().getString(R.string.press_to_see_more));
            //.icon(BitmapDescriptorFactory.fromResource(R.drawable.img_pin))
            Marker m = map.addMarker(op);
            mapBusinesses.put(m, g);
        }
    }

    GoogleMap.OnInfoWindowClickListener onBusinessInfoWindowClickListener = new GoogleMap.OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {
            Business ge = mapBusinesses.get(marker);
            FragmentDialogBusiness fragmentDialogBusiness = new FragmentDialogBusiness();
            Bundle bundle = new Bundle();
            bundle.putSerializable("genericEvent",ge);
            fragmentDialogBusiness.setArguments(bundle);
            fragmentDialogBusiness.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
            fragmentDialogBusiness.show(getActivity().getSupportFragmentManager(), "genericEvent");
        }
    };

    GoogleMap.InfoWindowAdapter infoWindowAdapter = new GoogleMap.InfoWindowAdapter() {
        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            View v = getActivity().getLayoutInflater().inflate(R.layout.info_window_adapter, null);
            TextView tvName = (TextView) v.findViewById(R.id.tv_info_adapter_name);
            TextView tvAddress = (TextView) v.findViewById(R.id.tv_info_adapter_address);

            return v;
        }
    };

}
