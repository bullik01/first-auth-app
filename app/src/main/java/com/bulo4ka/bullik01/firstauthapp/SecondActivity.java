package com.bulo4ka.bullik01.firstauthapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends Activity {

    String color_names[] = {"red", "green", "blue", "yellow", "pink", "brown", "black", "orange", "limegreen", "purple"};
    Integer image_id[] = {R.drawable.red, R.drawable.green, R.drawable.blue, R.drawable.yellow, R.drawable.pink, R.drawable.brown, R.drawable.black, R.drawable.orange, R.drawable.limegreen, R.drawable.purple};
    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        CustomListAdapter adapter = new CustomListAdapter(this, image_id, color_names);
//        ListView lv = (ListView) findViewById(R.id.listView);
//        lv.setAdapter(adapter);
    }
}