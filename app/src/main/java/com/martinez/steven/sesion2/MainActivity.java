package com.martinez.steven.sesion2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText eCorreo, eNombre;
    //Button bGuardar;
    CheckBox cCine, cNadar, cGym, cBike;
    String nombre, correo, data="";

    /////////
    private static final String CERO = "0";
    private static final String BARRA = "/";

    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    //Variables para obtener la fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    //Widgets
    EditText etFecha;
    ImageButton ibObtenerFecha;
    /////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eCorreo = findViewById(R.id.eCorreo);
        eNombre = findViewById(R.id.eNombre);
        //bGuardar = findViewById(R.id.bGuardar);
        cCine = findViewById(R.id.cCine);
        cGym = findViewById(R.id.cGym);
        cNadar = findViewById(R.id.cNadar);
        cBike = findViewById(R.id.cBike);

        //Widget EditText donde se mostrara la fecha obtenida
        etFecha = (EditText) findViewById(R.id.et_mostrar_fecha_picker);
        //Widget ImageButton del cual usaremos el evento clic para obtener la fecha
        ibObtenerFecha = (ImageButton) findViewById(R.id.ib_obtener_fecha);
        //Evento setOnClickListener - clic
        ibObtenerFecha.setOnClickListener(this);

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
            data = data + " sexo Masculino";
        }else {
            data = data + " sexo Femenino";
        }
    }

    /*Otra forma de recibir los datos de conlos botones*/
    public void guardar(View view) {
        int id = view.getId();
        if (id == R.id.bGuardar) {
            data = data + eNombre.getText().toString();
            eCorreo.setText(data);

        }
    }

    public void onCheckBoxClicked(View view) {
        int id = view.getId();
        if (id == R.id.cCine) {
            data = data + "Pasatiempo: Cine";
            eCorreo.setText(data);
        }else if (id == R.id.cGym){
            data = data + "Pasatiempo: GYM";
            eCorreo.setText(data);
        }else if (id == R.id.cBike){
            data = data + "Pasatiempo: Bike";
            eCorreo.setText(data);
        }else {
            data = data + "Pasatiempo: Nadar";
            eCorreo.setText(data);
        }
    }

    // usar date picker para la fecha de nacimiento
    //usar spiner para seleccionar la ciudad de nacimiento

    //@Override
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

    }

    //version 2.0



}






