package com.example.kpweav13.androidproject1;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText input = (EditText)findViewById(R.id.input_edit);
        final Button convertbutton = (Button)findViewById(R.id.convert_button);
        final Spinner inputspinner = (Spinner)findViewById(R.id.inputspinner);
        final Spinner outputspinner = (Spinner)findViewById(R.id.outputspinner);
        final TextView output = (TextView) findViewById(R.id.output);
        final Drawable defcolor = input.getBackground();


        convertbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                input.setBackground(defcolor);
                if(input.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(MainActivity.this, "Please enter a number to convert.", Toast.LENGTH_LONG);
                    toast.show();
                    input.setBackgroundColor(getResources().getColor(R.color.lightred));

                }

                try{
                    int inputvalue = Integer.parseInt(input.getText().toString(),Integer.parseInt(inputspinner.getSelectedItem().toString()));
                    String outputvalue = Integer.toString(inputvalue, Integer.parseInt(outputspinner.getSelectedItem().toString()));
                    output.setText(outputvalue);


                }
                catch(Exception e){
                    Toast ntoast = Toast.makeText(MainActivity.this, "That number is invalid for the selected base.", Toast.LENGTH_LONG);
                    ntoast.show();
                    input.requestFocus();
                    input.setBackgroundColor(getResources().getColor(R.color.lightred));
                }




            }
        });
    }
}
