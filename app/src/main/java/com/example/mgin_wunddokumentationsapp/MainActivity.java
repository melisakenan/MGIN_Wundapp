package com.example.mgin_wunddokumentationsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listview_werte;
    ArrayList<String> list;
    Button btnspeichern;
    EditText editText;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview_werte = (ListView) findViewById(R.id.listview_werte);
        btnspeichern = (Button) findViewById(R.id.btnspeichern);
        editText = (EditText) findViewById(R.id.zahlenwert);

        list = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, list);

        btnspeichern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = editText.getText().toString();

                list.add(names);
                listview_werte.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
        });






    }



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();




}
