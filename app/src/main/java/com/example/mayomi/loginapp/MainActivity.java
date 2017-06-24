package com.example.mayomi.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private Button loginButton;
    private EditText usernameEditText;
    private EditText passwordEditText;

    private static final String CORRECT_USERNAME = "Team Awesome";
    private static final String CORRECT_PASSWORD = "password";

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWRD = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.pass);
        loginButton = (Button) findViewById(R.id.btn1);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)){
                    verifyLogin(name, password);
                }
            }
        });

    }

    public void verifyLogin(String username, String password){
        if(username.equalsIgnoreCase(CORRECT_USERNAME) && password.equalsIgnoreCase(CORRECT_PASSWORD)){
            //todo launch detail activity

            Intent intent = new Intent(this, detailActivity.class);

            intent.putExtra(KEY_USERNAME, username);
            intent.putExtra(KEY_PASSWRD, password);

            startActivity(intent);

            if(!username.equalsIgnoreCase(CORRECT_USERNAME)){
                usernameEditText.setError("your username is wrong");
                passwordEditText.setError("your password is wrong");
            }


        }
    }



}
