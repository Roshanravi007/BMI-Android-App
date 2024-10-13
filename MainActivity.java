package com.example.bmi_3_iteration;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private View newimage;
    private View newheading;
    private View newmale;
    private View newfemale;
    private EditText newfeet;
    private EditText newinches;
    private EditText newweight;
    private View newcalculate;
    private EditText newage;
    private TextView newresult;


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
        idcalling();
        newcalculate.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                double bmiresult=  bmicalculation();
                                                display(bmiresult);

                                            }
                                        }
        );
    }

    private void idcalling(){
        newimage = findViewById(R.id.image);
        newheading = findViewById(R.id.heading);
        newmale =findViewById(R.id.male);
        newfemale = findViewById(R.id.female);
        newfeet =findViewById(R.id.feet);
        newinches =findViewById(R.id.inches);
        newweight =findViewById(R.id.weight);
        newcalculate = findViewById(R.id.calculate);
        newage =findViewById(R.id.age);
        newresult = findViewById(R.id.result);

    }
    private double bmicalculation() {

        //getting the text and converting into string
        String textage = newage.getText().toString();
        String textfeet = newfeet.getText().toString();
        String textinches = newinches.getText().toString();
        String textweight = newweight.getText().toString();

        //String number string to number variables to perform calculation.
        int nfeet= Integer.parseInt(textfeet);
        int ninches= Integer.parseInt(textinches);
        int nweight= Integer.parseInt(textweight);

        //converting feet to inches
        double totinches= (nfeet*12)+ninches;

        //inches to meters
        double totmet= totinches*0.0254;

        //bmi cal
        return (nweight)/(totmet * totmet);

    }
    private void display(double bmiresult){
        DecimalFormat decimal = new DecimalFormat("0.0");
        String stringdecimal= decimal.format(bmiresult);
        String condition;
        if(bmiresult<16.0){
            condition= stringdecimal+ " " + "You are underweight";
        } else if (bmiresult>25) {
            condition= stringdecimal+" "+ "You are overweight";

        }else{
            condition= stringdecimal+" "+ "You are normalweight";
        }
        newresult.setText(condition);

    }


}
