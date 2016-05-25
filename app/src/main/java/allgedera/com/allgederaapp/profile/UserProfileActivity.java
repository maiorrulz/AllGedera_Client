package allgedera.com.allgederaapp.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import allgedera.com.allgederaapp.R;
import allgedera.com.allgederaapp.menus.MainActivity;
import allgedera.com.allgederaapp.urlImages.ImageLoader;

public class UserProfileActivity extends AppCompatActivity {

    ImageView iv_profilePicture;
    TextView tv_userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        iv_profilePicture = (ImageView) findViewById(R.id.fb_userImage);
        tv_userName = (TextView) findViewById(R.id.tv_userName);

        tv_userName.setText(MainActivity.user);
        Log.d("profile image null?", MainActivity.profileImage == null ? "yes" : "no");
        if (MainActivity.profileImage != null) {
            ImageLoader imgLoader = new ImageLoader(getApplicationContext());
            imgLoader.displayImage(MainActivity.profileImage, iv_profilePicture);

        }
            //iv_profilePicture.setImageBitmap(MainActivity.profileImage);



    }
}
