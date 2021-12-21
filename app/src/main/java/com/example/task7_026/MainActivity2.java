package com.example.task7_026;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textShow = findViewById(R.id.textshow);
        Button btnresult = findViewById(R.id.btnshow);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Double x = bundle.getDouble("val1");
        Double y = bundle.getDouble("val2");
        double sum = x+y;
        textShow.setText("Data Received is \n" + "val1=" + x
                + "\n val2 = " + y + "\n result = " + sum);

        btnresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                bundle.putDouble("sum", sum);
                //attach updated bumble to invoking intent
                intent.putExtras(bundle);
                setResult(1111, intent);
                finish();
            }
        });

    }
}