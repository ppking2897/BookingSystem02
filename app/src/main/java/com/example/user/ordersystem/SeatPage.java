package com.example.user.ordersystem;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class SeatPage extends AppCompatActivity {
    Button[] btns = new Button[10];
    private Button doSetDate;
    private Button doSetTime;
    private TextView textDate;
    private TextView textTime;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_page);

        doFindView();
        GregorianCalendar calendar = new GregorianCalendar();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                int month = monthOfYear+1;
                textDate.setText((year+"/"+month+"/"+dayOfMonth));
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                textTime.setText((hourOfDay>12?hourOfDay-12:hourOfDay)
                +":"+minute+" "+(hourOfDay>12?"PM":"AM"));

            }
        },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);

        Button button = (Button)findViewById(R.id.goSuccessPage);
        button.setOnClickListener(clickListenerGo);


        btns[0] = (Button)findViewById(R.id.b0);
        btns[1] = (Button)findViewById(R.id.b1);
        btns[2] = (Button)findViewById(R.id.b2);
        btns[3] = (Button)findViewById(R.id.b3);
        btns[4] = (Button)findViewById(R.id.b4);
        btns[5] = (Button)findViewById(R.id.b5);
        btns[6] = (Button)findViewById(R.id.b6);
        btns[7] = (Button)findViewById(R.id.b7);
        btns[8] = (Button)findViewById(R.id.b8);
        btns[9] = (Button)findViewById(R.id.b9);


        for (int i = 0; i < 10; i++) {
            btns[i].setOnClickListener(clickListener);}

    }
//找View By ID
    public void doFindView(){
        doSetDate = (Button)findViewById(R.id.buttonDate);
        doSetTime = (Button)findViewById(R.id.buttonTime);
        textDate = (TextView)findViewById(R.id.datetext);
        textTime = (TextView)findViewById(R.id.timetext);
    }

    //日期視窗
    public void setDate(View v){
        datePickerDialog.show();
    }
    //日期視窗
    public void setTime(View v){
        timePickerDialog.show();
    }

    //移動按鈕
    View.OnClickListener clickListenerGo = new View.OnClickListener(){
        public void onClick(View v){
            Intent it = new Intent();
            it.setClass(SeatPage.this,SuccessPage.class);
            startActivity(it);
            finish();
        }
    };

    //位置按鈕
    View.OnClickListener clickListener = new View.OnClickListener() {

        public void onClick(View v) {
            for(int i = 0;i<10;i++) {
                btns[i].setBackgroundColor(getResources().getColor(R.color.colorWhite));
            }
            v.setBackgroundColor(getResources().getColor(R.color.colorOrange));
        }
    };

}
