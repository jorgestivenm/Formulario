package com.martinez.steven.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bclear, bone, btwo, bthree, bfour, bfive, bsix,
            bseven, beight, bnine, bzero, bpor, bdiv, bminus, badd, bequal, bcoma;
    private ImageButton berase;
    private EditText resultado;
    private String data = "", data2 = "";
    private Integer flag = 0;
    double value1 = 0.0, value2 = 0.0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bclear = findViewById(R.id.bclear);
        badd = findViewById(R.id.badd);
        bcoma = findViewById(R.id.bcoma);
        bdiv = findViewById(R.id.bdiv);
        bminus = findViewById(R.id.bminus);
        bpor = findViewById(R.id.bpor);
        berase = findViewById(R.id.berase);
        bone = findViewById(R.id.bone);
        btwo = findViewById(R.id.btwo);
        bthree = findViewById(R.id.bthree);
        bfour = findViewById(R.id.bfour);
        bfive = findViewById(R.id.bfive);
        bsix = findViewById(R.id.bsix);
        bseven = findViewById(R.id.bseven);
        beight = findViewById(R.id.beight);
        bnine = findViewById(R.id.bnine);
        bzero = findViewById(R.id.bzero);
        bequal = findViewById(R.id.bequal);
        resultado = findViewById(R.id.eresult);


    }

    public void boton(View view) {
        switch (view.getId()){
            case R.id.bclear:
                resultado.setText("");
                value1 = 0.0;
                value2 = 0.0;
                flag = 0;
                data = "";
                break;
            case R.id.bcoma:
                data = data + bcoma.getText().toString();
                resultado.setText(data);
                break;
            case R.id.bzero:
                data = data + bzero.getText().toString();
                resultado.setText(data);
                break;
            case R.id.bone:
                data = data + bone.getText().toString();
                resultado.setText(data);
                break;
            case R.id.btwo:
                data = data + btwo.getText().toString();
                resultado.setText(data);
                break;
            case R.id.bthree:
                data = data + bthree.getText().toString();
                resultado.setText(data);
                break;
            case R.id.bfour:
                data = data + bfour.getText().toString();
                resultado.setText(data);
                break;
            case R.id.bfive:
                data = data + bfive.getText().toString();
                resultado.setText(data);
                break;
            case R.id.bsix:
                data = data + bsix.getText().toString();
                resultado.setText(data);
                break;
            case R.id.bseven:
                data = data + bseven.getText().toString();
                resultado.setText(data);
                break;
            case R.id.beight:
                data = data + beight.getText().toString();
                resultado.setText(data);
                break;
            case R.id.bnine:
                data = data + bnine.getText().toString();
                resultado.setText(data);
                break;
            case R.id.bpor:
                data2  = "*";
                if(!resultado.getText().toString().isEmpty()){
                    if (flag == 0 ){
                        value1 = Double.parseDouble( resultado.getText().toString().replace(",",".") );
                        data = "";
                        flag = 1;
                        resultado.setText("");
                    }else {
                        value2 = Double.parseDouble( resultado.getText().toString().replace(",",".") );
                        data = "";
                    }
                }
                break;
            case R.id.bdiv:
                data2 = "/";
                if(!resultado.getText().toString().isEmpty()) {
                    if (flag == 0) {
                        value1 = Double.parseDouble(resultado.getText().toString().replace(",", "."));
                        data = "";
                        flag = 1;
                        resultado.setText("");
                    } else {
                        value2 = Double.parseDouble(resultado.getText().toString().replace(",", "."));
                        data = "";
                    }
                }
                break;
            case R.id.bminus:
                data2 = "-";
                if(!resultado.getText().toString().isEmpty()) {
                    if (flag == 0) {
                        value1 = Double.parseDouble(resultado.getText().toString().replace(",", "."));
                        data = "";
                        flag = 1;
                        resultado.setText("");
                    } else {
                        value2 = Double.parseDouble(resultado.getText().toString().replace(",", "."));
                        data = "";
                    }
                }
                break;
            case R.id.badd:
                data2 = "+";
                if(!resultado.getText().toString().isEmpty()) {
                    if (flag == 0) {
                        value1 = Double.parseDouble(resultado.getText().toString().replace(",", "."));
                        data = "";
                        flag = 1;
                        resultado.setText("");
                    } else {
                        value2 = Double.parseDouble(resultado.getText().toString().replace(",", "."));
                        data = "";
                    }
                }
                break;
            case R.id.berase:
                if (!data.equals("")) {
                    int m = Math.max(0, data.length() - 1);
                    char[] cs = data.toCharArray();
                    data = new String(cs, 0, m);
                    resultado.setText(data);
                    break;
                }else{
                    data = "";
                    data2 = "";
                    value1 = 0.0;
                    value2 = 0.0;
                    flag = 0;
                    resultado.setText("");
                }
                break;
            case R.id.bequal:
                if(!resultado.getText().toString().isEmpty()) {
                    operacion();
                }
                break;





        }
    }

    public void operacion() {
        value2 = Double.parseDouble( resultado.getText().toString().replace(",",".") );
        switch (data2){
            case "+":
                value1 =(value1 + value2);
                resultado.setText(String.valueOf(value1));
                value2 = 0.0;
                data2 = "";
                data = "";
                break;
            case "-":
                value1 =(value1 - value2);
                resultado.setText(String.valueOf(value1));
                value2 = 0.0;
                data2 = "";
                data = "";
                break;
            case "*":
                value1 =(value1 * value2);
                resultado.setText(String.valueOf(value1 ));
                value2 = 0.0;
                data2 = "";
                data = "";
                break;
            case "/":
                if (value2!=0.0) {
                    value1 = (value1 / value2);
                    resultado.setText(String.valueOf(value1));
                    value2 = 0.0;
                    data2 = "";
                    data = "";
                    break;
                }
                resultado.setText("ERROR");
                value2 = 0.0;
                data2 = "";
                data = "";
                resultado.setText("");
                break;

        }

    }
}
