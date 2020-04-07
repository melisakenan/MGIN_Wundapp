package com.example.mgin_wunddokumentationsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listview_werte;
    ArrayList<String> list;
    ArrayList<String> listp;
    ArrayList<String> listvor;
    Button btnspeichern;
    EditText editText;
    ArrayAdapter<String> arrayAdapter;
    ListView listview_patienten;
    EditText patienteneingabe;
    Spinner spinner;
    ArrayAdapter<String> arrayAdap = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview_werte = (ListView) findViewById(R.id.listview_werte);
        listview_patienten = (ListView) findViewById(R.id.listview_patienten);
        btnspeichern = (Button) findViewById(R.id.btnspeichern);
        editText = (EditText) findViewById(R.id.zahlenwert);
        patienteneingabe = (EditText) findViewById(R.id.patienteneingabe);

        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);

        list = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, list);

        //listvor = new ArrayList<String>();
        //arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
          //      android.R.layout.simple_expandable_list_item_1, listvor);

        listp = new ArrayList<String>();
        arrayAdap = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, listp);




        int lastIndex = list.lastIndexOf(patienteneingabe);




        btnspeichern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = editText.getText().toString();
                String patienten = patienteneingabe.getText().toString();

                list.add(names);
                list.add(patienten);
                listp.add(patienten);
                listview_werte.setAdapter(arrayAdapter);
                listview_patienten.setAdapter(arrayAdapter);
                spinner.setAdapter(arrayAdap);


                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        listview_patienten.setAdapter(arrayAdapter);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                arrayAdapter.notifyDataSetChanged();
                arrayAdap.notifyDataSetChanged();
            }
        });









    }



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();




}
