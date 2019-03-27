package com.example.phonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FinalInfoActivity extends AppCompatActivity {

    private Button mConfirm;

    private TextView mNameTextView;
    private TextView mEmailTextView;
    private TextView mAddressTextView;
    private TextView mPhoneTextView;
    private TextView mGenderTextView;

    private String mNameValue, mEmailValue, mAddressValue, mPhoneValue, mGenderValue;

    private User mNewUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_info);

        mNameTextView = (TextView) findViewById(R.id.textViewNameInfo);
        mEmailTextView = (TextView) findViewById(R.id.textViewEmailInfo);
        mAddressTextView = (TextView) findViewById(R.id.textViewAddressInfo);
        mPhoneTextView = (TextView) findViewById(R.id.textViewPhoneInfo);
        mGenderTextView = (TextView) findViewById(R.id.textViewGenderInfo);

        Intent intent = getIntent();
        mNameValue = intent.getStringExtra("name");
        mEmailValue = intent.getStringExtra("email");
        mAddressValue = intent.getStringExtra("address");
        mPhoneValue = intent.getStringExtra("phone");
        mGenderValue = intent.getStringExtra("gender");

        mNameTextView.setText(mNameValue);
        mEmailTextView.setText(mEmailValue);
        mAddressTextView.setText(mAddressValue);
        mPhoneTextView.setText(mPhoneValue);
        mGenderTextView.setText(mGenderValue);

        mConfirm = (Button) findViewById(R.id.confirm_Button);
        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create the new user object
                mNewUser = new User(mNameValue, mEmailValue, mAddressValue, mPhoneValue, mGenderValue);

                // Check if the new user object exists inside the List
                if(FillinActivity.mStoredUsers.contains(mNewUser)){
                    Toast.makeText(getApplicationContext(),"User already exists", Toast.LENGTH_SHORT).show();
                } else{
                    FillinActivity.mStoredUsers.add(mNewUser);
                    Toast.makeText(getApplicationContext(), "New User added", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(getApplicationContext(), R.string.confirm_toast, Toast.LENGTH_SHORT).show();
                Log.i("MESSAGE", "User added successfully!");
            }
        });

    }

}
