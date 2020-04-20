package com.example.isupportlockdown;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemsAdapter extends ArrayAdapter<Items> {

    Context mContext;

    LayoutInflater inflater;

    ArrayList<Items> arrayItems;

    public ItemsAdapter(Context context,int resource, ArrayList<Items> arrayitems)
    {
        super(context, resource);

        this.mContext = context;
        this.arrayItems = arrayitems;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //Items currentItem = getItem(position);

        final ViewHolder holder;
        View listItemView = convertView;
        if(listItemView== null)
        {
            listItemView = inflater.inflate(R.layout.list_item,null);
            holder = new ViewHolder();
            holder.Sno= (TextView) listItemView.findViewById(R.id.Sno);
            holder.item= (EditText) listItemView.findViewById(R.id.item);
            holder.quantity= (EditText) listItemView.findViewById(R.id.quantity);
            listItemView.setTag(holder);
        }
        else
        {
            holder= (ViewHolder) listItemView.getTag();
        }

        Items aitem = arrayItems.get(position);
        holder.Sno.setText(aitem.getSno());


        holder.quantity.setText(aitem.getQuantity());
        holder.quantity.setId(position);

        holder.item.setText(aitem.getItem_name());
        holder.item.setId(position);

        holder.item.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {
                    final int position = v.getId();
                    final EditText Caption = (EditText) v;
                    arrayItems.get(position).setitem(Caption.getText().toString());
                }

            }

        });

        holder.quantity.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {
                    final int position = v.getId();
                    final EditText Caption = (EditText) v;
                    arrayItems.get(position).setquan(Caption.getText().toString());
                }

            }

        });


        /*TextView snoTextView =(TextView) listItemView.findViewById(R.id.Sno);

        snoTextView.setText(currentItem.getSno());*/

        return listItemView;
    }

    @Override

    public int getCount() {

        return arrayItems.size();

    }

    static class ViewHolder {
        TextView Sno;
        EditText item;
        EditText quantity;
    }

}
