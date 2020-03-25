package com.example.tugas0316;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.*;

public class MainActivity extends AppCompatActivity {

    ButtonOnClick buttonOnClick = new ButtonOnClick(this, MainActivity.this);
    EditText tglL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tglL = (EditText) findViewById(R.id.editTGL);
        Date_Picker datePickerC = new Date_Picker(this, MainActivity.this);

        //Date Picker//
        datePickerC.datePicker();

        //backButtonAcM
        buttonOnClick.activityMainBackButton();

        //ButtonDaftarClick
        buttonOnClick.validateButton();
    }


}
