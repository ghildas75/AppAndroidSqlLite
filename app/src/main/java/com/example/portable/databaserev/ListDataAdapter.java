package com.example.portable.databaserev;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.*;

/**
 * Created by Portable on 2017-12-07.
 */

public class ListDataAdapter extends ArrayAdapter {
List list= new ArrayList();
    public ListDataAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
   static class LayoutHandler{

        TextView txtuserName, txtMob,txtEmail;
   }
    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
       // return super.getCount();
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        //return super.getItemViewType(position);
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        LayoutHandler layoutHandler;
        if(row==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler=new LayoutHandler();
            layoutHandler.txtuserName=(TextView) row.findViewById(R.id.id_result_user);
            layoutHandler.txtMob=(TextView) row.findViewById(R.id.id_result_mob);
            layoutHandler.txtuserName=(TextView) row.findViewById(R.id.id_result_email);
            row.setTag(layoutHandler);
        }

        else{

            layoutHandler=(LayoutHandler) row.getTag();
        }
        DataProvider dataProvider= (DataProvider) this.getItem(position);
        layoutHandler.txtuserName.setText(dataProvider.getName());
        layoutHandler.txtMob.setText(dataProvider.getMobile());
        layoutHandler.txtEmail.setText(dataProvider.getEmail());
        return row;
    }
}
