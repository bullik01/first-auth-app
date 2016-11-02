package com.bulo4ka.bullik01.firstauthapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class CustomListAdapter extends ArrayAdapter {
    String[] color_names;
    Integer[] image_id;


    public CustomListAdapter(Activity, Integer[] image_id, String[] text) {
        super(R.layout.list_row, text);
        this.color_names = text;
        this.image_id = image_id;
    }

    static class ViewHolder {
        public ImageView imageView;
        public TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater(context)
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            return inflater
                    .inflate(android.R.layout.activity_list_item, parent, false);
            rowView = inflater.inflate(R.layout.list_row, null, true);
            holder = new ViewHolder();
            holder.textView = (TextView) rowView.findViewById(R.id.textView);
            holder.imageView = (ImageView) rowView.findViewById(R.id.imageView);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }
        return rowView;

    }
}