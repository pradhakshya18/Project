package com.example.fifo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter2 extends BaseAdapter {

    Context context;
    ArrayList<String> ID;
    ArrayList<String> Name;
    ArrayList<String> Container_no;


    public ListAdapter2(
            Context context2,
            ArrayList<String> id,
            ArrayList<String> name,
            ArrayList<String> cno
    )
    {

        this.context = context2;
        this.ID = id;
        this.Name = name;
        this.Container_no = cno;
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

        ListAdapter2.Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            child = layoutInflater.inflate(R.layout.items2, null);

            holder = new ListAdapter2.Holder();

            holder.ID_TextView = (TextView) child.findViewById(R.id.textViewID);
            holder.Name_TextView = (TextView) child.findViewById(R.id.textViewNAME);
            holder.Container_noTextView = (TextView) child.findViewById(R.id.textViewCONTAINER_NO);

            child.setTag(holder);

        } else {

            holder = (ListAdapter2.Holder) child.getTag();
        }
        holder.ID_TextView.setText(ID.get(position));
        holder.Name_TextView.setText(Name.get(position));
        holder.Container_noTextView.setText(Container_no.get(position));

        return child;
    }

    public class Holder {

        TextView ID_TextView;
        TextView Name_TextView;
        TextView Container_noTextView;
    }

}
