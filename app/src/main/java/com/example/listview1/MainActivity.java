package com.example.listview1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewCities;
    private Spinner spinnerStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listViewCities = findViewById(R.id.listViewCities);

        ArrayList<String> cities = new ArrayList<>();

        cities.add("Nairobi");
        cities.add("Kisumu");
        cities.add("Nakuru");
        cities.add("Mombasa");

        ArrayAdapter<String> adapterCities = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                cities
        );
        listViewCities.setAdapter(adapterCities);

        listViewCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, cities.get(i) + "selected", Toast.LENGTH_SHORT).show();
            }
        });

        spinnerStudents = findViewById(R.id.spinnerStudents);
//
//        ArrayList<String> arrayListStudents = new ArrayList<>();
//
//        arrayListStudents.add("Michael");
//        arrayListStudents.add("Collins");
//        arrayListStudents.add("Osman");
//        arrayListStudents.add("CodeM");
//
//        ArrayAdapter<String> arrayAdapterStudents = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_spinner_dropdown_item,
//                arrayListStudents
//        );
//
//        spinnerStudents.setAdapter(arrayAdapterStudents);
//
        spinnerStudents.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, spinnerStudents.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}