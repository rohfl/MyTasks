package com.rohfl.mytasks.fragments;

import com.rohfl.mytasks.R;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    private static final String USERNAME = "username";

//    Variables
    private String username;


//  Views
    private MaterialButton myTaskButton;
    private MaterialTextView welcomeTV;


    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * This method will be used to pass data from the base activity to
     * this fragment.
     *
     * @param username username passed by the activity.
     * @return New Instance of the WelcomeFragment.
     */
    public static FirstFragment newInstance(String username) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(USERNAME, username);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString(USERNAME);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        // init views
        myTaskButton = (MaterialButton)v.findViewById(R.id.my_task_button);
        welcomeTV = (MaterialTextView)v.findViewById(R.id.tv_welcome);

        // setting the username in the welcome textview which is received by the activity
        welcomeTV.setText("Welcome " + username);

        // setting the onClickListener to the MyTask button, used lambda for less clutter and
        // better readability
        myTaskButton.setOnClickListener(view -> {

        });

        return v ;
    }

}