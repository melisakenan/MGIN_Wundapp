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
import java.util.Iterator;
import java.util.List;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {

    ListView listview_werte;
    ArrayList<String> listw;
    ArrayList<String> listw2;
    ArrayList<String> listp;
    ArrayList<String> listvor;
    Button btnspeichern;
    EditText editText;
    ArrayAdapter<String> arrayAdapter;
    ListView listview_patienten;
    EditText patienteneingabe;
    Spinner spinner;
    ArrayAdapter<String> arrayAdap;
    TextView differenz;
    ArrayAdapter<String> arrayAdapter2;

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
        differenz = (TextView) findViewById(R.id.differenz);

        listw = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, listw);

        listw2 = new ArrayList<String>();
        arrayAdapter2 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, listw2);

        listp = new ArrayList<String>();
        arrayAdap = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, listp);

        btnspeichern.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String werte = editText.getText().toString();
                String patienten = patienteneingabe.getText().toString();

                listw.add(werte);
                listw2.add(werte);
                listp.add(patienten);
                listview_werte.setAdapter(arrayAdapter);
                listview_werte.setAdapter(arrayAdapter2);
                spinner.setAdapter(arrayAdap);

                arrayAdapter.notifyDataSetChanged();
                arrayAdap.notifyDataSetChanged();
            }
        });

        /*spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String spinnertext = spinner.getSelectedItem().toString();
                //int x = listp.indexOf(spinnertext);
                //int y = Integer.parseInt(listw.get(x));
                //listw2.add(x, String.valueOf(y));
                //listw.add(x, String.valueOf(editText));
                //int berechnung = (Integer.parseInt(String.valueOf(editText)) / y ) * 100;
                //differenz.setText(berechnung);
            }
        });*/

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinnertext = spinner.getSelectedItem().toString();
                int x = listp.indexOf(spinnertext);
                String y = listw.get(x);
                listw2.add(x, y);
                listw.add(x, editText.getText().toString());
                //int berechnung = (Integer.parseInt(String.valueOf(editText)) / y ) * 100;
                //differenz.setText(berechnung);

                //String.valueOf(editText)
                //String.valueOf(y)
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }



    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();




}
