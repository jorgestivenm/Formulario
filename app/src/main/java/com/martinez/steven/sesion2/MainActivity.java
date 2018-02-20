package com.martinez.steven.sesion2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText eCorreo, eNombre, elogin, epass1, epass2, eshow_info, etFecha;
    //private Button bGuardar;
    private CheckBox cCine, cNadar, cGym, cBike;
    private String nombre, correo, ciudad, sexo, data="", fecha ="";
    private List<String> list = new ArrayList<String>();
    private Spinner spinner;
    private ImageButton ibObtenerFecha;
    private static final String CERO = "0";
    private static final String BARRA = "/";
    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();
    //Variables para obtener la fecha
    private final int mes = c.get(Calendar.MONTH);
    private final int dia = c.get(Calendar.DAY_OF_MONTH);
    private final int anio = c.get(Calendar.YEAR);
    int flag = 0;
    int a = 0, b = 0, e = 0, d = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--------edittext-------------//
        elogin = findViewById(R.id.elogin);
        epass1 = findViewById(R.id.epass1);
        epass2 = findViewById(R.id.epass2);
        eCorreo = findViewById(R.id.eCorreo);
        eNombre = findViewById(R.id.eNombre);
        eshow_info = findViewById(R.id.eShow_info);

        //------------Date---------------//
        //Widget EditText donde se mostrara la fecha obtenida
        etFecha = (EditText) findViewById(R.id.et_mostrar_fecha_picker);
        //Widget ImageButton del cual usaremos el evento clic para obtener la fecha
        ibObtenerFecha = (ImageButton) findViewById(R.id.ib_obtener_fecha);
        //Evento setOnClickListener - clic
        ibObtenerFecha.setOnClickListener(this);

        //----------spinner-------------//
        spinner = (Spinner) findViewById(R.id.city_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.city_born, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //spinner = (Spinner) findViewById(R.id.city_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                  ciudad = adapterView.getItemAtPosition(position).toString();
              }

              @Override
              public void onNothingSelected(AdapterView<?> parent) {

              }
          });

        //-----------checkbox--------//
        cCine = findViewById(R.id.cCine);
        cGym = findViewById(R.id.cGym);
        cNadar = findViewById(R.id.cNadar);
        cBike = findViewById(R.id.cBike);
        //bGuardar = findViewById(R.id.bGuardar);



        /*bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                nombre = eNombre.getText().toString();
                eCorreo.setText(nombre);
            }
        });*/

    }


    public void onRadioButtonClicked(View view) {
        int id = view.getId();
        if (id == R.id.rMasculino) {
            sexo = " Sexo: Masculino";
        }else {
            sexo = " Sexo: Femenino";
        }
    }


    public void onCheckBoxClicked(View view) {
        int id = view.getId();

        if (id == R.id.cCine && a == 0) {
            data = data + "Pasatiempo: Cine";
            a=1;
        }else if (id == R.id.cGym && b ==0){
            data = data + "Pasatiempo: GYM";
            b = 1;
        }else if (id == R.id.cBike && e == 0){
            data = data + "Pasatiempo: Bike";
            e = 1;
        }else if(id == R.id.cNadar && d== 0){
            data = data + "Pasatiempo: Nadar";
            d = 1;
        }
    }

    ///----------Metodos para obtener la fecha-----------------//
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_obtener_fecha:
                obtenerFecha();
                break;
        }
    }

    private void obtenerFecha(){
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                etFecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);


            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
            /**
             *También puede cargar los valores que usted desee
             */
        },anio, mes, dia);
        //Muestro el widget
        recogerFecha.show();
        //fecha =  anio +BARRA+ mes + BARRA+ dia;

    }

    /*Otra forma de recibir los datos de conlos botones*/
    public void guardar(View view) {
        int id = view.getId();
        eshow_info.setEnabled(false);
        if (id == R.id.bGuardar) {

            if (eNombre.toString() != "" && elogin.toString() != "" && epass1.toString() != ""&&
                    epass2.toString() != "" && eCorreo.toString() != ""&& sexo != ""){
                list =new ArrayList<String>();
                list.add("User Name:" + elogin.getText().toString());
                if (epass1.toString() != epass2.toString()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Verifique el password, no concuerda", Toast.LENGTH_SHORT);
                    toast.show();
                    flag= 1;
                } else {
                    flag = 0;
                    list.add("Password:" + epass1.getText().toString());
                }
                if (ciudad.toString() == "Select" || ciudad.toString() == "" ) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Selecione la ciudad de nacimiento", Toast.LENGTH_SHORT);
                    toast.show();
                    flag = 1;
                }
                list.add("Nombre:" + eNombre.getText().toString());
                list.add("Correo:" + eCorreo.getText().toString());
                list.add(sexo);
                list.add("Fecha de Nacimiento:" + etFecha.getText().toString());
                list.add("Ciudad:" + ciudad);
                list.add(data);
                if (flag == 0);{
                    eshow_info.setEnabled(true);
                    eshow_info.setText(list.toString());
                    eshow_info.setEnabled(false);
                    list =new ArrayList<String>();
                    data = "";
                }
            }

        }
    }
    //version 3.0

}






