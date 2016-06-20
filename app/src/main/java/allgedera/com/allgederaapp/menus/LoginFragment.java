package allgedera.com.allgederaapp.menus;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import allgedera.com.allgederaapp.R;

public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button loginButton = (Button) view.findViewById(R.id.btn_fbLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFblogin();
            }
        });

        return view;
    }

    public void onFblogin()
    {
        MainActivity.mCallbackManager = CallbackManager.Factory.create();

        // Set permissions
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email"));

        LoginManager.getInstance().registerCallback(MainActivity.mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        System.out.println("Success");
                        GraphRequest.newMeRequest(
                                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject json, GraphResponse response) {
                                        if (response.getError() != null) {
                                            // handle error
                                            System.out.println("ERROR");
                                        } else {
                                            System.out.println("Success");
                                            try {

                                                String jsonresult = String.valueOf(json);
                                                System.out.println("JSON Result" + jsonresult);

                                                //String str_email = json.getString("email");
                                                //String str_id = json.getString("id");
                                                MainActivity.user = json.getString("name");
                                                //String str_id = json.getString("id");
                                                String userId = json.getString("id");
                                                if (userId != null) {
                                                    try {
                                                        MainActivity.profileImage = "https://graph.facebook.com/" + userId + "/picture?type=large";
                                                        //Log.d("in login frag, url:", imageURL.toString());
                                                        //MainActivity.profileImage = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
                                                        //Log.d("login, pic null?:", MainActivity.profileImage == null ? "yes" : "no");
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                                //String str_lastname = json.getString("last_name");

                                                Log.d("user full name: ", MainActivity.user);// + " " + str_lastname);
                                                MainActivity.loggedIn = true;
                                                MainActivity.goToMain();
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }

                                }).executeAsync();

                    }

                    @Override
                    public void onCancel() {
                        Log.d("cancel", "On cancel");
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Log.d("error", error.toString());
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MainActivity.mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
