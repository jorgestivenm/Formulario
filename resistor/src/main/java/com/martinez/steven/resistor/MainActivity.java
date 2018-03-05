package com.martinez.steven.resistor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1, spinner2, spinner3;
    private String banda1, banda2, banda3, tol="";
    private RadioButton runo, rdos, rcinco, rdiez;
    private Button bcalc;
    private EditText eresult;
    private int band1, band2;
    private double multi, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eresult = findViewById(R.id.eresult);

        //-----------band1----------------//
        spinner1 = (Spinner) findViewById(R.id.spinner_band1);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.band_1, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);

        //spinner = (Spinner) findViewById(R.id.city_spinner);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                banda1 = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //-----------band2----------------//
        spinner2 = (Spinner) findViewById(R.id.spinner_band2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.band_2, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);

        //spinner = (Spinner) findViewById(R.id.city_spinner);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                banda2 = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //-----------band3---------------//
        spinner3 = (Spinner) findViewById(R.id.spinner_multi);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.band_3, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner3.setAdapter(adapter3);

        //spinner = (Spinner) findViewById(R.id.city_spinner);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                banda3 = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    public void onRadioButtonClicked(View view) {

        int id = view.getId();
        if (id == R.id.runo) {
            tol = "1%";
        }else if(id == R.id.rdos) {
            tol = "2%";
        }else if (id == R.id.rcinco){
            tol = "5%";
        }else{
            tol = "10%";
        }

    }

    public void calculo_valor(View view) {
        if (banda1.equals("Select") || banda1.equals("") || banda2.equals("Select") || banda2.equals("") || banda3.equals("Select") || banda3.equals("") || tol.equals("")) {
            eresult.setText("Selecione algúno de los campos qe no ha llenado");
        } else {
            if (banda1.equals("Negro")) {
                band1 = 0;
            } else if (banda1.equals("Cafe")) {
                band1 = 1;
            } else if (banda1.equals("Rojo")) {
                band1 = 2;
            } else if (banda1.equals("Naranja")) {
                band1 = 3;
            } else if (banda1.equals("Amarillo")) {
                band1 = 4;
            } else if (banda1.equals("Verde")) {
                band1 = 5;
            } else if (banda1.equals("Azul")) {
                band1 = 6;
            } else if (banda1.equals("Violeta")) {
                band1 = 7;
            } else if (banda1.equals("Gris")) {
                band1 = 8;
            } else if (banda1.equals("Blanco")) {
                band1 = 9;
            }
            if (banda2.equals("Negro")) {
                band2 = 0;
            } else if (banda2.equals("Cafe")) {
                band2 = 1;
            } else if (banda2.equals("Rojo")) {
                band2 = 2;
            } else if (banda2.equals("Naranja")) {
                band2 = 3;
            } else if (banda2.equals("Amarillo")) {
                band2 = 4;
            } else if (banda2.equals("Verde")) {
                band2 = 5;
            } else if (banda2.equals("Azul")) {
                band2 = 6;
            } else if (banda2.equals("Violeta")) {
                band2 = 7;
            } else if (banda2.equals("Gris")) {
                band2 = 8;
            } else if (banda2.equals("Blanco")) {
                band2 = 9;
            }
            if (banda3.equals("Negro")) {
                band1 = 1;
            } else if (banda3.equals("Cafe")) {
                multi = 10;
            } else if (banda3.equals("Rojo")) {
                multi = 100;
            } else if (banda3.equals("Naranja")) {
                multi = 1000;
            } else if (banda3.equals("Amarillo")) {
                multi = 10000;
            } else if (banda3.equals("Verde")) {
                multi = 100000;
            } else if (banda3.equals("Azul")) {
                multi = 1000000;
            } else if (banda3.equals("Dorado")) {
                multi = 0.1;
            } else if (banda3.equals("Plateado")) {
                multi = 0.01;
            }

            result =Integer.valueOf(String.valueOf(band1) + String.valueOf(band2)) * multi;
            eresult.setText(("El valor del resistor selecionado es = " + String.valueOf(result) + "Ω con una tolerancia de " + tol));

        }
    }
}
