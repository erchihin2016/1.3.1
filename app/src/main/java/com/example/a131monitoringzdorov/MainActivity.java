package com.example.a131monitoringzdorov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ActionsMainActiv";

    private EditText fionEd;
    private EditText ageEd;
    private Button saveBut;
    private Button pressBut;
    private Button healthBut;

    private boolean flag = false;
    private static UserDat userdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        saveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Click Save button performed");
                try {

                    String fio = fionEd.getText().toString();
                    if ("".equals(fio)) {
                        fionEd.requestFocus();
                        fionEd.setError(getString(R.string.emptyErr));
                        flag = false;
                    } else {
                        int age = Integer.parseInt(ageEd.getText().toString());
                        if (age < 0) {
                            throw new RuntimeException(getString(R.string.negAgeErr));
                        }
                        userdata = new UserDat(fio, age);
                        flag = true;
                        Toast.makeText(MainActivity.this, getString(R.string.succesUD), Toast.LENGTH_SHORT).show();
                        Log.i(TAG, "Handler Save button finished");
                    }
                } catch (NumberFormatException e) {
                    Log.i(TAG, "Handler Save button NumberFormatException");
                    ageEd.requestFocus();
                    ageEd.setError(getString(R.string.numbErr));
                    flag = false;

                } catch (RuntimeException e) {
                    Log.i(TAG, "Handler Save button RuntimeException");
                    ageEd.requestFocus();
                    ageEd.setError(e.getMessage());
                    flag = false;
                }


            }
        });
        pressBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Add pressure measurement button clicked");
                pressBut.setError(null);
                if(flag){
                    startActivity(new Intent(MainActivity.this,PressureActivity.class));
                    Log.i(TAG, "Pressure Activity activated");
                } else {
                    Log.i(TAG, "Handler button Pressure Activity throw exception");
                    pressBut.requestFocus();
                    pressBut.setError(getString(R.string.needDataEr));
                    Toast.makeText(MainActivity.this, getString(R.string.needDataEr), Toast.LENGTH_SHORT).show();
                }
            }
        });
        healthBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Add health measurement button clicked");
                pressBut.setError(null);
                if (flag) {
                    startActivity(new Intent(MainActivity.this, BodyCondActivity.class));
                    Log.i(TAG, "Body Condition Activity activated");
                } else{
                    Log.i(TAG, "Handler button Body Condition Activity throw exception");
                    pressBut.requestFocus();
                    pressBut.setError(getString(R.string.needDataEr));
                    Toast.makeText(MainActivity.this, getString(R.string.needDataEr), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        fionEd = findViewById(R.id.nameEd);
        ageEd = findViewById(R.id.ageEd);
        saveBut = findViewById(R.id.saveBt);
        pressBut = findViewById(R.id.presBut);
        healthBut = findViewById(R.id.healthBut);
    }
}
