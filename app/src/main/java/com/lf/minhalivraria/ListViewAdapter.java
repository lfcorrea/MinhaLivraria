package com.lf.minhalivraria;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by luizfernando on 8/9/15.
 */
public class ListViewAdapter extends BaseAdapter {

    public ArrayList<HashMap<String,String>> list;
    Activity activity;
    TextView txtStoreName;
    TextView txtPrice;

    public ListViewAdapter(Activity activity, ArrayList<HashMap<String, String>> list){
        super();
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();

        if(convertView == null){
            convertView = inflater.inflate(R.layout.offer_item_row, null);

            txtStoreName = (TextView) convertView.findViewById(R.id.storeName);
            txtPrice = (TextView) convertView.findViewById(R.id.offerPrice);

        }

        HashMap<String,String> map = list.get(position);
        txtStoreName.setText(map.get(Constants.STORE_COLUMN));
        txtPrice.setText(map.get(Constants.PRICE_COLUMN));

        return convertView;
    }
}
