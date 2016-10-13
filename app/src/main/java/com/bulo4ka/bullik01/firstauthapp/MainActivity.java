package com.bulo4ka.bullik01.firstauthapp;

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

public class MainActivity extends AppCompatActivity {
    private final static Pattern pattern = Patterns.EMAIL_ADDRESS;

    @BindView(R.id.textView)
    TextView hello;
    @BindView(R.id.yourMail)
    AppCompatEditText mail;
    @BindView(R.id.yourPass)
    AppCompatEditText password;
    @BindView(R.id.button2)
    Button login;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    hello.setVisibility(View.VISIBLE);
                    hello.setText(getString(R.string.whatuneed) + matcher.group(1));
                } else {
                    hello.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mail.getText().length() < 1) {
                    mail.setError(getString(R.string.nomail));
                    return;
                }
                if (!pattern.matcher(mail.getText().toString()).find()) {
                    mail.setError(getString(R.string.badmail));
                    return;
                }
                if (password.getText().length() < 6) {
                    password.setError(getString(R.string.badpass));
                    return;
                }

                doLogin();
            }
        });
    }

    private void doLogin() {

    }
}
