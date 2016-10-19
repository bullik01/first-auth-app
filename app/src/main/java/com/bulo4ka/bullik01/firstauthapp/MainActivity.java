package com.bulo4ka.bullik01.firstauthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private final static Pattern pattern = Patterns.EMAIL_ADDRESS;

    @BindView(R.id.textView) TextView hello;
    @BindView(R.id.yourMail) AppCompatEditText mail;
    @BindView(R.id.yourPass) AppCompatEditText password;
    @BindView(R.id.button2) Button login;
    @BindView(R.id.activity_main) LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

        @OnClick(R.id.button2)
        public void onMyButtonClick(View view)  {
                    // Checking 4 length of text
                    if (mail.getText().length() < 1) {
                        mail.setError(getString(R.string.nomail));
                        return;
                    }
                    // Checking 4 mail pattern
                    if (!pattern.matcher(mail.getText().toString()).find()) {
                        mail.setError(getString(R.string.badmail));
                        return;
                    }
                    // Checking 4 password length.
                    if (password.getText().length() < 6) {
                        password.setError(getString(R.string.badpass));
                        return;
                    }
                    // Getting mail & saying hi (stupid way, but it work perfect)
                    if (mail.getText().length() > 1) {
                        hello.setText(getString(R.string.whatuneed) + mail.getText());
                    }
        public void onMyButtonClick(View view) {
            // Starting new activity on click
            Intent intent = new Intent(this, SecondActivity.class)
            startActivity(intent);
                }
        }
                doLogin();
            }

    private void doLogin() {

    }
}
