package com.lalit.spaak_demo.ui.Contacts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lalit.spaak_demo.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder>{

    ArrayList<String> response ;

    public ContactsAdapter(ArrayList<String> contacts){

        this.response = contacts ;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_contacts, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(response.get(i));

    }


    @Override
    public int getItemCount() {
        return response.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.txt_contact);
        }
    }



}
