package com.rohfl.mytasks;

import com.rohfl.mytasks.fragments.FirstFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * AppCompatActivity subclass
 * @author Rohit Jangid
 * @author https://www.github.com/rohfl
 * @version 1.0
 * @since 1.0
 */

public class WelcomeActivity extends AppCompatActivity {

    // final strings which will be used as keys
    private final String MY_PREF_NAME = "MyTaskPrefs";
    private final String USER_NAME = "username";

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // get the shared preferences
        SharedPreferences prefs = getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE);
        String userName = prefs.getString(USER_NAME, null);

        // create a FragmentManager
        fragmentManager = getSupportFragmentManager();

        // create a FragmentTransaction to begin the transaction and replace the Fragment
        fragmentTransaction = fragmentManager.beginTransaction();

        // create FirstFragment because it is to be shown first when user login in app
        Fragment fragment = FirstFragment.newInstance(userName);

        // replace the FrameLayout with the FirstFragment
        fragmentTransaction.replace(R.id.fragment_container, fragment);

        // save the changes
        fragmentTransaction.commit();

    }
}