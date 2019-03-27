package com.example.phonebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class ListOfUsersActivity extends AppCompatActivity {

    private TextView mTitle, mContacts;
    private ScrollView mScrollView;
    private Button mGobackButton;
    private StringBuilder mStringBuilder;
    private String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_user);

        mScrollView = findViewById(R.id.scrollView_id_ListOfUsersActivity);
        mContacts = findViewById(R.id.contact_text_id_ListOfUsersActivity);

    }
}
