package allgedera.com.allgederaapp.businesses.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.businesses.entities.Business;
import allgedera.com.allgederaapp.map.navigation.DownloadTask;
import allgedera.com.allgederaapp.map.navigation.StrretViewDialogFragment;
import allgedera.com.allgederaapp.urlImages.ImageLoader;

import static allgedera.com.allgederaapp.map.navigation.NavigationUtils.getDirectionsUrl;


public class BusinessDialogFragment extends DialogFragment implements View.OnClickListener {

    private Business business;
    private Button btnNav, btnShowWay, panView;
    private ImageView imgExit;
    public Context context;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        business = (Business) getArguments().getSerializable("Business");
        //myLocation = (Location) getArguments().getSerializable("myLocation");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_business, container, false);

        imgExit = (ImageView) view.findViewById(R.id.img_exit);
        imgExit.setOnClickListener(this);

        btnNav = (Button) view.findViewById(R.id.btn_fragment_business_nav);
        btnNav.setOnClickListener(this);

        btnShowWay = (Button) view.findViewById(R.id.btn_fragment_business_show_way);
        btnShowWay.setOnClickListener(this);

        panView = (Button) view.findViewById(R.id.btn_fragment_business_pan_view);
        panView.setOnClickListener(this);

        TextView tvName = ((TextView) view.findViewById(R.id.tv_fragment_work_name));
        if (business.getName() != null)
            tvName.setText(business.getName());
        TextView tvAdress = ((TextView) view.findViewById(R.id.tv_fragment_work_about));
        if (business.getAddress() != null)
            tvAdress.setText(business.getAddress());
        TextView tvAbout = ((TextView) view.findViewById(R.id.tv_fragment_work_addess));
        if (business.getAbout() != null)
            tvAbout.setText(business.getAbout());
        TextView tvPhone = ((TextView) view.findViewById(R.id.tv_fragment_work_phone));
        if (business.getPhone() != null)
            tvPhone.setText(business.getPhone());

        ImageView imageView = (ImageView) view.findViewById(R.id.img_fragment_business_image);
        if (business.getLogo() != null) {
            System.out.println("image = " + business.getLogo());
            ImageLoader imgLoader = new ImageLoader(context);
            imgLoader.displayImage(business.getLogo(), imageView);
        }
        else
            Log.d("image in dialog", "null");
        //imageView.setImageResource(business.getImage());
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.img_exit)
        {
            dismiss();
        }
        else if (view.getId() == R.id.btn_fragment_business_nav) {
            final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?" + "saddr="+ BusinessMapFragment.myLocation.getLatitude() + "," + BusinessMapFragment.myLocation.getLongitude() + "&daddr=" + business.getLatitude() + "," + business.getLongitude()));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            startActivity(intent);
            dismiss();
        }
        else if (view.getId() == R.id.btn_fragment_business_show_way) {
            if (BusinessMapFragment.currentPath != null)
                BusinessMapFragment.currentPath.remove();
            LatLng source = new LatLng(BusinessMapFragment.myLocation.getLatitude(), BusinessMapFragment.myLocation.getLongitude());
            LatLng dest = new LatLng(business.getLatitude(), business.getLongitude());
            String url = getDirectionsUrl(source, dest);

            DownloadTask downloadTask = new DownloadTask();

            // Start downloading json data from Google Directions API
            downloadTask.execute(url);
            dismiss();
        }
        else if (view.getId() == R.id.btn_fragment_business_pan_view) {
            showStreetViewDialog(new LatLng(business.getLatitude(), business.getLongitude()));
        }
        else {
            try {
                String uri = "geo: " + business.getLatitude() + "," + business.getLongitude();
                getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
            } catch (Exception e) {
            }
        }

    }

    private void showStreetViewDialog(LatLng pos){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("streetview");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment newFragment = StrretViewDialogFragment.newInstance(pos);
        newFragment.show(ft, "streetview");
    }


}
