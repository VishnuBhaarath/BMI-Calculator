package com.example.android.bodymassindexcalculator;



import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    int numheight;
    int numweight;
    int a;
    float value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height=(EditText)findViewById(R.id.height);
                weight=(EditText)findViewById(R.id.weight);
                status=(TextView)findViewById(R.id.status);
                getheight=height.getText().toString();
                getweight=weight.getText().toString();
                if(getheight.length()!=0 && getweight.length()!=0)
                {
                    numheight=Integer.parseInt(getheight);
                    numweight=Integer.parseInt(getweight);
                    a=(numheight*numheight)/(100*100);
                    value=numweight/a;

                    BMI=(TextView)findViewById(R.id.BMI);
                    BMI.setText(String.valueOf(value));

                }
                else
                {
                    Toast.makeText(MainActivity.this,"Please enter the values",Toast.LENGTH_LONG).show();

                }
                if(value>25 && value<=30)
                {
                    status.setText("Overweight");
                    Toast.makeText(MainActivity.this,"Thor,you have to reduce you weight",Toast.LENGTH_LONG).show();

                }
                else if(value>30)
                {
                    status.setText("Obese");
                    Toast.makeText(MainActivity.this,"Thor,your condition is critical reduce you weight",Toast.LENGTH_LONG).show();


                }
                else if(value>18.5 && value<=25)
                {
                    status.setText("Healthyrange");
                    Toast.makeText(MainActivity.this,"Great work Thor",Toast.LENGTH_LONG).show();

                }
                else if(value<=18.5)
                {
                    status.setText("underweight");
                    Toast.makeText(MainActivity.this,"Thor you have made a miracle, but please increase your weight",Toast.LENGTH_SHORT).show();

                }
            }
        });
        reset=(Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight.setText("");
                height.setText("");
                BMI.setText("");
                status.setText("");
            }
        });

    }
}
