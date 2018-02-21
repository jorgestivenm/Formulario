package com.martinez.steven.geometria;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import static java.lang.Math.*;

public class MainActivity extends AppCompatActivity {

    private EditText elado , eresult, eradio, ebase, ealtura;
    private int id1, lado = 0, base = 0 , altura = 0, radio = 0;
    double area;
    double perimetro;
    double volumen;
    String figura="";
    ImageView imagen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elado = findViewById(R.id.elado);
        eradio = findViewById(R.id.eradio);
        ebase = findViewById(R.id.ebase);
        ealtura = findViewById(R.id.ealtura);
        eresult = findViewById(R.id.eresult);
        imagen = findViewById(R.id.imagen);
    }

    public void onRadioButtonClicked(View view) {
        id1 = view.getId();
        if(id1 == R.id.rCuadro){
            imagen.setBackgroundResource(R.drawable.cuadro);
            figura = "cuadro";
            elado.setEnabled(true);
            eradio.setEnabled(false);
            ebase.setEnabled(false);
            ealtura.setEnabled(false);
        }else if (id1 == R.id.rCirculo){
            imagen.setBackgroundResource(R.drawable.circulo);
            figura = "circulo";
            eradio.setEnabled(true);
            ebase.setEnabled(false);
            ealtura.setEnabled(false);
            elado.setEnabled(false);
        }else if (id1 == R.id.rTriangulo){
            imagen.setBackgroundResource(R.drawable.triangulo);
            figura = "triangulo";
            ebase.setEnabled(true);
            ealtura.setEnabled(true);
            elado.setEnabled(false);
            eradio.setEnabled(false);

        }else{
            imagen.setBackgroundResource(R.drawable.cubo);
            figura = "cubo";
            elado.setEnabled(true);
            eradio.setEnabled(false);
            ebase.setEnabled(false);
            ealtura.setEnabled(false);
        }
    }


    public void calcular(View view) {
        int id = view.getId();
        eresult.setEnabled(true);
        if (id == R.id.bcalcular){
            if (figura.equals("cuadro")){
                lado  = Integer.valueOf(elado.getText().toString());
                area =lado * lado;
                perimetro = 4*lado;
                eresult.setText(("El Area es:" + String.valueOf(area) + "El Perimetro es:" + String.valueOf(perimetro)));
            }else if (figura.equals("circulo")){
                radio = Integer.valueOf(eradio.getText().toString());
                perimetro = 2* PI *radio;
                area = PI * radio* radio;
                eresult.setText(("El Area es:" + String.valueOf(area) + "El Perimetro es:" + String.valueOf(perimetro)));
            }else if (figura.equals("triangulo")){
                base = Integer.valueOf(ebase.getText().toString());
                altura = Integer.valueOf(ealtura.getText().toString());
                perimetro = base+altura+ Math.pow((base*base+altura*altura),0.5);
                area = ( base* altura)/2;
                eresult.setText(("El Area es:" + String.valueOf(area) + "El Perimetro es:" + String.valueOf(perimetro)));
            }else if(figura.equals("cubo")){
                lado  = Integer.valueOf(elado.getText().toString());
                area =lado * lado;
                perimetro = 12*lado;
                volumen = lado * lado * lado;
                eresult.setText(("El Area es:" + String.valueOf(area) + "El Perimetro es:" + String.valueOf(perimetro) + "El Volumen es:" + String.valueOf(volumen)));
            }
            eresult.setEnabled(false);
        }

    }
}
