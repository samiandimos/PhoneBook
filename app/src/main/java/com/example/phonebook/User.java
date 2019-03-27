package com.example.phonebook;

import android.util.Log;

/**Create a class User with instance variables for keeping the following fields:
 NameLastName, Email, Address, Phone Number, Gender.
 The class User should implement the interface Comparable.
 Use Name and Last Name in the compareTo method to define how two users can be compared:
 Users u1 and u2 are considered to be equal if they have the same name and last name.
 User u1 is smaller than u2 if the concatenation of the name and last name of u1 is alphabetically smaller than that of u2.**/


public class User implements Comparable<User> {

    private static final String TAG = "USER CLASS";

    String mNameLastName, mConcutinatedName, mEmail, mAddress, mPhoneNumber, mGender;

    // Constructor
    public User(String nameLastName, String email, String address, String phoneNumber, String gender){
        mNameLastName = nameLastName;
        mEmail = email;
        mAddress = address;
        mPhoneNumber = phoneNumber;
        mGender = gender;
    }

    // Getters

    public String getNameLastName() {
        return mNameLastName;
    }

    public String getConcutinatedName() {
        return mConcutinatedName;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public String getGender() {
        return mGender;
    }


    // compareTo method for alphabetical sorting
    @Override
    public int compareTo(User user2) {
        // Checking the name lengths of two different users
        String concatUserName1 = (concatenateNameLastname(this.getNameLastName())).toLowerCase();
        String concatUserName2 = (concatenateNameLastname(user2.getNameLastName())).toLowerCase();

        if(concatUserName1.equals(concatUserName2)){
            Log.d(TAG, "Users have the same Name");
            return 0;
        }else if(concatUserName1.compareTo(concatUserName2) > 0){
            Log.d(TAG,"User 1 GREATER than User 2");
            return 1;
        } else {
            Log.d(TAG,"User 1 SMALLER than User 2");
            return -1;
        }
    }


    // Custom Methods
    private String concatenateNameLastname(String fullName){
        mConcutinatedName = fullName.replaceAll("\\s", "");
        return mConcutinatedName;
    }
}
