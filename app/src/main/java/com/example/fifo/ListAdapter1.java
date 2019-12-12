package com.example.fifo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter1 extends BaseAdapter {

    Context context;
    ArrayList<String> ID;
    ArrayList<String> Name;
    ArrayList<String> Password;


    public ListAdapter1(
            Context context2,
            ArrayList<String> id,
            ArrayList<String> name,
            ArrayList<String> pass
    )
    {

        this.context = context2;
        this.ID = id;
        this.Name = name;
        this.Password = pass;
    }

    public int getCount() {
        return ID.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View child, ViewGroup parent) {

        Holder holder;
        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            child = layoutInflater.inflate(R.layout.items, null);
            holder = new Holder();
            holder.ID_TextView = (TextView) child.findViewById(R.id.textViewID);
            holder.Name_TextView = (TextView) child.findViewById(R.id.textViewNAME);
            holder.PasswordTextView = (TextView) child.findViewById(R.id.textViewPassword);

            child.setTag(holder);

        } else {

            holder = (Holder) child.getTag();
        }
        holder.ID_TextView.setText(ID.get(position));
        holder.Name_TextView.setText(Name.get(position));
        holder.PasswordTextView.setText(Password.get(position));

        return child;
    }

    public class Holder {

        TextView ID_TextView;
        TextView Name_TextView;
        TextView PasswordTextView;
    }

}
