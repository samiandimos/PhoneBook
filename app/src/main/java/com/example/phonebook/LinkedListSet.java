package com.example.phonebook;

import android.util.Log;

import java.util.LinkedList;

/** Implement a generic class LinkedListSet<E> by using a LinkedList through composition.
 The LinkedListSet<E> doesn't have to implement the interface Set<E> (if you do so, it is completely fine though).
 You should implement at least the following methods:

 void add(E e) - Adds the element in the set if it's not already in the set.
 boolean contains(E e) - returns True if the element is in the set.
 void remove(E e) - Deletes the element from the set.
 int size() - returns the number of elements in the set.**/



public class LinkedListSet <E extends Comparable<E> >{

    private static final String TAG = "LinkedListSet";

    private LinkedList<E> mLinkedList;

    // Constructor
    public LinkedListSet(){
        mLinkedList = new LinkedList<>();
    }



    // Custom Methods

    public boolean contains(E user){
        for(E element : mLinkedList){
            if(user.compareTo(element) == 0){
                Log.d(TAG, "User Already contained in the list");
                return true;
            }
        }
        return false;
    }

    public void add(E user){
        if(!contains(user)){
            mLinkedList.add(user);
        }
        Log.d(TAG, "New User added: " + user);
    }

    public void remove(E user){
        if(contains(user)){
            mLinkedList.remove(user);
        }
    }

    public int size(){
        return mLinkedList.size();
    }
}