package com.bulo4ka.bullik01.firstauthapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private final static Pattern pattern = Pattern.compile("([\\s\\S]+)@[\\s\\S]+\\.[\\s\\S]{2,}");

    EditText password, mail;
    TextView hello;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = (EditText) findViewById(R.id.yourPass);
        mail = (EditText) findViewById(R.id.yourMail);
        hello = (TextView) findViewById(R.id.textView);
        login = (Button) findViewById(R.id.button2);

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

                if(!pattern.matcher(mail.getText().toString()).find()){
                    Toast.makeText(MainActivity.this, R.string.badmail, Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.getText().length()<6){
                    Toast.makeText(MainActivity.this, R.string.badpass, Toast.LENGTH_SHORT).show();
                    return;
                }

                doLogin();
            }
        });
    }
    private void doLogin(){

    }
}
