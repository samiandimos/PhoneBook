package com.example.phonebook;

import android.content.Context;
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

    private String mNameInfo, mEmailInfo, mAddressInfo, mPhoneInfo, mGenderInfo;


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
        mNameInfo = intent.getStringExtra("name");
        mEmailInfo = intent.getStringExtra("email");
        mAddressInfo = intent.getStringExtra("address");
        mPhoneInfo = intent.getStringExtra("phone");
        mGenderInfo = intent.getStringExtra("gender");

        mNameTextView.setText(mNameInfo);
        mEmailTextView.setText(mEmailInfo);
        mAddressTextView.setText(mAddressInfo);
        mPhoneTextView.setText(mPhoneInfo);
        mGenderTextView.setText(mGenderInfo);

        mConfirm = (Button) findViewById(R.id.confirm_Button);
        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.confirm_toast, Toast.LENGTH_SHORT).show();
                Log.i("MESSAGE", "User added successfully!");
            }
        });

    }

}
