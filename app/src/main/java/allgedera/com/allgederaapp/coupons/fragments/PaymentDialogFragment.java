package allgedera.com.allgederaapp.coupons.fragments;


import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.coupons.entities.Purchase;
import allgedera.com.allgederaapp.menus.MainActivity;
import allgedera.com.allgederaapp.rest.RestAPI;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PaymentDialogFragment extends DialogFragment {

    public int couponId, price;
    public TextView mTVCouponNumber, mTVToPay;
    EditText mETCreditNumber, mETValidityYear, mETValidityMonth;
    Button mBtnCancel, mBtnPurchase;

    public PaymentDialogFragment() {
        couponId = 0;
        price = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.dialog_payment, null);

        mTVCouponNumber = (TextView) view.findViewById(R.id.tv_couponToPurchase);
        mTVToPay = (TextView) view.findViewById(R.id.tv_toPay);

        mTVCouponNumber.setText(getString(R.string.coupon_to_purchase, couponId));
        mTVToPay.setText(getString(R.string.to_pay, price));


        mETCreditNumber = (EditText) view.findViewById(R.id.et_creditNumber);
        mETValidityMonth = (EditText) view.findViewById(R.id.et_validityMonth);
        mETValidityYear = (EditText) view.findViewById(R.id.et_validityYear);

        mBtnCancel = (Button) view.findViewById(R.id.btn_cancelPurchase);
        mBtnPurchase = (Button) view.findViewById(R.id.btn_makePurchase);


        mBtnPurchase.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                RestAdapter adapter = new RestAdapter.Builder().setEndpoint(RestAPI.BASE_URL).build();
        /*
         *  create an instance of the api that implements the methods needed to
         *  make requests to the server
         */
                                                RestAPI restAPI = adapter.create(RestAPI.class);


                                                Calendar c = Calendar.getInstance();
                                                SimpleDateFormat sdf = new SimpleDateFormat("dd:MMMM:yyyy HH:mm:ss a");
                                                String strDate = sdf.format(c.getTime());

                                                Purchase purchase = new Purchase(0,
                                                        MainActivity.user,
                                                        couponId,
                                                        price,
                                                        Integer.parseInt(mETCreditNumber.getText().toString()),
                                                        Integer.parseInt(mETValidityMonth.getText().toString()),
                                                        Integer.parseInt(mETValidityYear.getText().toString()),
                                                        strDate,
                                                        null);

                                                System.out.println("purchase: " + purchase.toString());

                                                restAPI.addPurchase(purchase, new Callback<Response>() {
                                                    @Override
                                                    public void success(Response response, Response response2) {
                                                        Toast.makeText(getActivity().getApplicationContext(), "התבצעה רכישה", Toast.LENGTH_SHORT).show();
                                                        System.out.println("response: " + response.toString());
                                                        PaymentDialogFragment.this.dismiss();
                                                    }

                                                    @Override
                                                    public void failure(RetrofitError error) {
                                                        Toast.makeText(getActivity().getApplicationContext(), "שגיאה - לא בוצעה רכישה", Toast.LENGTH_SHORT).show();
                                                        System.out.println("not sent: " + error.toString());
                                                        PaymentDialogFragment.this.dismiss();
                                                    }
                                                });
                                            }
                                        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaymentDialogFragment.this.dismiss();
            }
        });

        return view;
    }

}
