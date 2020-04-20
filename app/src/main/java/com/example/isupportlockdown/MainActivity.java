package com.example.isupportlockdown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    ItemsAdapter adapter;
    ListView listview;
    int counter=0;
    String message="";
    Items bitem;
    ArrayList<Items> list = new ArrayList<Items>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);


        for (int i = 0; i < 5; i++) {
            bitem=new Items();
            bitem.setSno(""+(i+1));
            bitem.setitem("");
            bitem.setquan("");
            list.add(bitem);
            counter++;
        }



        adapter = new ItemsAdapter( this, R.layout.list_item,  list);
        listview.setAdapter(adapter);


    }

    public void confirmMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editname = (EditText) findViewById(R.id.name);
        message=message.concat(editname.getText().toString());
        message=message.concat("\n");
        EditText editaddress = (EditText) findViewById(R.id.address);
        message=message.concat(editaddress.getText().toString());
        message=message.concat("\n\n\n");

        for(int j=1;j<=counter;j++)
        {   if(list.get(j-1).getItem_name()!=""&&list.get(j-1).getQuantity()!=null)
            {
                message=message.concat(j+". "+list.get(j-1).getItem_name()+"-"+list.get(j-1).getQuantity()+"\n");
            }
        }




        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    }


    public void addRow(View view) {

        bitem=new Items();
        bitem.setSno(""+(++counter));
        bitem.setitem("");
        bitem.setquan("");
        list.add(bitem);
        adapter.notifyDataSetChanged();

    }
}

















