package com.rohfl.mytasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/**
 * AppCompatActivity subclass which will be first activity when user opens the application.
 * @author Rohit Jangid
 * @author https://www.github.com/rohfl
 * @version 1.0
 * @since 1.0
 */

public class LoginActivity extends AppCompatActivity {

    private final String MY_PREF_NAME = "MyTaskPrefs";
    private final String USER_NAME = "username";
    private final String PASSWORD = "password";

    //    Variables
    private String userName;
    private String password;

    // Views
    private TextInputLayout userNameEditText;
    private TextInputLayout userPasswordEditText;
    private MaterialButton saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // retrieving username and password from shared preferences
        SharedPreferences prefs = getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE);
        userName = prefs.getString(USER_NAME, null);
        password = prefs.getString(PASSWORD,null);

        // if the user have already saved the details then go to the welcome activity
        if(userName != null && password!=null) {
            Intent intent = new Intent(this,WelcomeActivity.class);
            startActivity(intent);
            finish();
        }

        // setting the textinputlayouts
        userNameEditText = (TextInputLayout) findViewById(R.id.username_tv);
        userPasswordEditText = (TextInputLayout) findViewById(R.id.password_tv);
        saveButton = (MaterialButton) findViewById(R.id.save_button);

        // when user press save button
        saveButton.setOnClickListener(view -> {

            // getting the entered username and password
            userName = userNameEditText.getEditText().getText().toString();
            password = userPasswordEditText.getEditText().getText().toString();

            if(checkUserNameAndPassword(userName,password)) {

                // saving the data in shared preferences
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE).edit();
                editor.putString(USER_NAME, userName);
                editor.putString(PASSWORD,password);
                editor.apply();

                // after saving the data move on to WelcomeActivity
                Intent intent = new Intent(this,WelcomeActivity.class);
                startActivity(intent);
                finish();
            }

        });


    }

    /**
     * This method will check for valid username and password, lets say username and password
     * must be greater than 4 letters
     *
     * @param username the username entered by user
     * @param password the password entered by user
     * @return true if both username and password are greater than 4 in length
     */

    private boolean checkUserNameAndPassword(String username,String password) {
        // clearing the error message
        userNameEditText.setError(null);
        userPasswordEditText.setError(null);

        if(username.length()<4) {
            userNameEditText.setError("Username must be > 4 characters");
            return false ;
        }
        if(password.length()<4) {
            userPasswordEditText.setError("Password must be > 4 characters");
            return false ;
        }
        return true ;
    }

}