package com.example.phonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FillinActivity extends AppCompatActivity {

    private static final String TAG = "FillinActivity";

    private EditText mEditTextName;
    private EditText mEditTextEmail;
    private EditText mEditTextAddress;
    private EditText mEditTextPhone;

    private RadioGroup mGender;
    private RadioButton mMale;
    private RadioButton mFemale;

    private Button mAddContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillin);

        mEditTextName = (EditText) findViewById(R.id.editTextName);
        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
        mEditTextAddress = (EditText) findViewById(R.id.editTextAddress);
        mEditTextPhone = (EditText) findViewById(R.id.editTextPhone);

        mGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        mMale = (RadioButton) findViewById(R.id.radioButtonMale);
        mFemale = (RadioButton) findViewById(R.id.radioButtonFemale);

        // New activity Button with intent passing information
        mAddContact = (Button) findViewById(R.id.add_contact_Button);
        mAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameValue = mEditTextName.getText().toString();
                String emailValue = mEditTextEmail.getText().toString();
                String addressValue = mEditTextAddress.getText().toString();
                String phoneValue =mEditTextPhone.getText().toString();

                String maleCheck = mMale.getText().toString();
                String femaleCheck = mFemale.getText().toString();

                if(nameValue.isEmpty() || emailValue.isEmpty() || addressValue.isEmpty() || phoneValue.isEmpty() || mGender.getCheckedRadioButtonId() == -1){
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.fill_in_prompt_toast, Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Intent intent = new Intent(FillinActivity.this, FinalInfoActivity.class);
                    intent.putExtra("name", nameValue);
                    intent.putExtra("email", emailValue);
                    intent.putExtra("address", addressValue);
                    intent.putExtra("phone", phoneValue);

                    if(mMale.isChecked()){
                        intent.putExtra("gender", maleCheck);
                    }else{
                        intent.putExtra("gender", femaleCheck);
                    }

                    startActivity(intent);
                }
            }
        });
    }

//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//        Log.d(TAG, "onSaveInstanceState called");
//        savedInstanceState.putCharSequence(KEY_NAME, mNameEditText.getText());
//        savedInstanceState.putCharSequence(KEY_EMAIL, mEmailEditText.getText());
//        savedInstanceState.putCharSequence(KEY_ADDRESS, mAddressEditText.getText());
//        savedInstanceState.putCharSequence(KEY_PHONE, mPhoneEditText.getText());
//    }

}
