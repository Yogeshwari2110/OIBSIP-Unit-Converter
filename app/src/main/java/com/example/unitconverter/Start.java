package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Start extends AppCompatActivity {
    TextView conversion;
    EditText enternum;
    Button miles;
    Button meters;
    Button kilometers;
    Button centimeters;
    Spinner unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        conversion= findViewById(R.id.conversion);
        enternum=findViewById(R.id.enternum);
        miles=findViewById(R.id.miles);
        meters=findViewById(R.id.meters);
        kilometers=findViewById(R.id.kilometers);
        unit = findViewById(R.id.unit);
        centimeters=findViewById(R.id.centimeters);
        String[] arr = {"km", "m", "cm", "mile"};
        unit.setAdapter(new ArrayAdapter(Start.this, android.R.layout.simple_list_item_1, arr));


        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        enternum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update();
            }
        });
    }
    private void update() {
        if (!enternum.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")) {
            double in = Double.parseDouble(enternum.getText().toString());
            switch (unit.getSelectedItem().toString()) {
                case "km":
                    setKm(in);
                    break;
                case "m":
                    setKm(in/1000);
                    break;
                case "cm":
                    setKm(in/100000);
                    break;
                case "mile":
                    setKm(in*1.609);
                    break;

            }
        }
    }

    private void setKm(double km_in) {

        meters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double meter = (km_in * 1000);
                conversion.setText(("Meters:" + meter));

            }
        });

        kilometers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double kmeter = (km_in );
                conversion.setText(("Kilometers:" + kmeter));

            }
        });

        centimeters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cmeter = (km_in*100000);
                conversion.setText(("Centimeters:" + cmeter));

            }
        });

        miles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double mile = (km_in / 1.609);
                conversion.setText(("Miles:" + mile));

            }
        });

    }
    }
