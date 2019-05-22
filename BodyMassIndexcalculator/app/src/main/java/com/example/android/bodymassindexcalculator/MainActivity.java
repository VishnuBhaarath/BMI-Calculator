package com.example.android.bodymassindexcalculator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private Button submit;
    private Button reset;
    private TextView BMI;
    private TextView Submit;
    private TextView status;
    String getheight;
    String getweight;
    float numheight;
    private RelativeLayout body;
    float numweight;
    float a;
    private float value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        body = findViewById(R.id.body);
        body.setBackgroundColor(Color.rgb(204, 255, 255));
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        BMI = (TextView) findViewById(R.id.BMI);
        status = (TextView) findViewById(R.id.status);
        submit = (Button) findViewById(R.id.submit);
        height.setBackgroundColor(Color.rgb(255,255,255));
        weight.setBackgroundColor(Color.rgb(255,255,255));
        submit.setBackgroundColor(Color.GREEN);
        status.setBackgroundColor(Color.rgb(255,255,255));
        BMI.setBackgroundColor(Color.rgb(255,255,255));
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getheight = height.getText().toString();
                getweight = weight.getText().toString();
                if (getheight.length() != 0 && getweight.length() != 0) {
                    submit.setBackgroundColor(Color.RED);
                    status.setBackgroundColor(Color.rgb(255, 255, 0));
                    height.setBackgroundColor(Color.rgb(255, 255, 0));
                    weight.setBackgroundColor(Color.rgb(255, 255, 0));
                    numheight = Float.parseFloat(getheight);
                    numweight = Float.parseFloat(getweight);
                    a = (numheight * numheight) / (100 * 100);
                    value = numweight / a;


                    BMI.setText(String.valueOf(numweight / a));
                    BMI.setBackgroundColor(Color.rgb(255, 0, 0));
                    if (value > 25 && value <= 30) {
                        status.setText("Overweight");
                        body.setBackgroundColor(Color.rgb(255, 102, 102));
                        Toast.makeText(MainActivity.this, "Thor,you have to reduce you weight", Toast.LENGTH_LONG).show();
                    } else if (value > 30) {
                        status.setText("Obese");
                        Toast.makeText(MainActivity.this, "Thor,your condition is critical reduce you weight", Toast.LENGTH_LONG).show();
                        body.setBackgroundColor(Color.rgb(255, 51, 51));
                    } else if (value > 18.5 && value <= 25) {
                        status.setText("Healthyrange");
                        Toast.makeText(MainActivity.this, "Great work Thor", Toast.LENGTH_LONG).show();
                        body.setBackgroundColor(Color.rgb(51, 255, 51));
                    } else if (value <= 18.5) {
                        status.setText("underweight");
                        Toast.makeText(MainActivity.this, "Thor you have made a miracle, but please increase your weight", Toast.LENGTH_SHORT).show();
                        body.setBackgroundColor(Color.rgb(255, 51, 51));
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter the values", Toast.LENGTH_LONG).show();

                }
            }

        });
        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getheight = height.getText().toString();
                getweight = weight.getText().toString();
                weight.setText("");
                height.setText("");
                body.setBackgroundColor(Color.rgb(204,255,255));
                height.setBackgroundColor(Color.rgb(255,255,255));
                weight.setBackgroundColor(Color.rgb(255,255,255));
                submit.setBackgroundColor(Color.GREEN);
                status.setBackgroundColor(Color.rgb(255,255,255));
                BMI.setBackgroundColor(Color.rgb(255,255,255));
                BMI.setText("");
                status.setText("");


            }
        });

    }


}
