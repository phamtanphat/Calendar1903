package com.ptp.phamtanphat.calendar1903;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtMin,edtMax;
    Button btnTinhtoan;
    TextView txtKetqua;
    Calendar calendarMin,calendarMax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        calendarMin = Calendar.getInstance();
        calendarMax = Calendar.getInstance();
        edtMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerMin();
            }
        });
        edtMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerMax();
            }
        });
        btnTinhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int songay = (int) ((calendarMax.getTimeInMillis() - calendarMin.getTimeInMillis()) / (1000*60*60*24));
                txtKetqua.setText(songay + "");
            }
        });
    }

    private void DatePickerMax() {
        final int ngay = calendarMax.get(Calendar.DATE);
        int thang = calendarMax.get(Calendar.MONTH);
        int nam = calendarMax.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //In ra ngay thang nam tren edittext
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                calendarMax.set(year,month,dayOfMonth);
                edtMax.setText(simpleDateFormat.format(calendarMax.getTime()));
//                edtMin.setText(dayOfMonth + " / " + month + " / " + year);
                //Khi click lai se hien trong datepicker la ngay vua duoc chon
                view.setMinDate(calendarMin.getTimeInMillis());

            }
        },nam,thang,ngay);
        datePickerDialog.getDatePicker().setMinDate(calendarMin.getTimeInMillis());
        datePickerDialog.show();
    }

    private void DatePickerMin() {
        final int ngay = calendarMin.get(Calendar.DATE);
        int thang = calendarMin.get(Calendar.MONTH);
        int nam = calendarMin.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //In ra ngay thang nam tren edittext
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                calendarMin.set(year,month,dayOfMonth);
                edtMin.setText(simpleDateFormat.format(calendarMin.getTime()));
//                edtMin.setText(dayOfMonth + " / " + month + " / " + year);
                //Khi click lai se hien trong datepicker la ngay vua duoc chon
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    private void anhxa() {
        edtMax = findViewById(R.id.edittextMax);
        edtMin = findViewById(R.id.edittextMin);
        btnTinhtoan = findViewById(R.id.buttontinhtoan);
        txtKetqua = findViewById(R.id.textviewketqua);
    }
}
