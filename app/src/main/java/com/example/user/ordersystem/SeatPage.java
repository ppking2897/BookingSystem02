package com.example.user.ordersystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SeatPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_page);

        Button button = (Button)findViewById(R.id.goSuccessPage);
        button.setOnClickListener(clickListener);
    }
    View.OnClickListener clickListener = new View.OnClickListener(){
        public void onClick(View v){
            Intent it = new Intent();
            it.setClass(SeatPage.this,SuccessPage.class);
            startActivity(it);
            finish();
        }
    };
}
