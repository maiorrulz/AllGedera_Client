package allgedera.com.allgederaapp.contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import allgedera.com.allgederaapp.R;

public class ContactUsActivity extends AppCompatActivity {

    Button mSendBtn;
    EditText mSubjectET;
    EditText mMessageET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        mSubjectET = (EditText) findViewById(R.id.et_subject);
        mMessageET = (EditText) findViewById(R.id.et_message);

        mSendBtn = (Button) findViewById(R.id.btn_sendMessage);
        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailTo 		= "zvp230@gmail.com";
                String emailSubject = mSubjectET.getText().toString();
                String emailContent = mMessageET.getText().toString();

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ emailTo});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, emailContent);

                //need this to prompts email client only
                emailIntent.setType("message/rfc822");

                startActivity(Intent.createChooser(emailIntent, "Select an Email Client:"));
            }
        });
    }
}
