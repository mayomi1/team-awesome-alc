package com.example.mayomi.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class detailActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private String item;

    ArrayAdapter<String> itemsAdapter;

    ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        list = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        //define list view
        ListView listView = (ListView) findViewById(R.id.my_list);
        listView.setAdapter(itemsAdapter);


        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Meatpies");
        categories.add("Chocolate");
        categories.add("Coffee");
        categories.add("Bread");
        categories.add("Tea");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        item = parent.getItemAtPosition(position).toString();
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //add cart to list view
    public void addCart(View view) {
        if (!list.contains(item)) {
            itemsAdapter.add(item);
        }
    }


}
