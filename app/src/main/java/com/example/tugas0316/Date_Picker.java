package com.example.tugas0316;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Date_Picker {

    private Context context;
    private Activity activity;
    DatePickerDialog picker;
    public EditText tglL;
    public Date_Picker(Activity _activity, Context _context) {
        this.activity = _activity;
        this.context = _context;
    }

    public void datePicker() {
        tglL = (EditText)this.activity.findViewById(R.id.editTGL);
        tglL.setInputType(InputType.TYPE_NULL);
        tglL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tglL.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
    }
}
