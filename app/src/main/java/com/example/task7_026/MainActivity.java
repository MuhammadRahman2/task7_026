package com.example.task7_026;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txt2;
    EditText edt1, edt2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         edt1 = findViewById(R.id.edit1);
         edt2 = findViewById(R.id.edit2);
         btn1 = findViewById(R.id.button1);
        txt2 = findViewById(R.id.text2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double x = Double.valueOf(edt1.getText().toString());
                Double y = Double.valueOf(edt2.getText().toString());

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("val1", x);
                bundle.putDouble("val2", y);
                intent.putExtras(bundle);
//                startActivityForResult(intent,1111); not working
                activityResultLaunch.launch(intent);


            }
        });
    }
        ActivityResultLauncher<Intent> activityResultLaunch = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == 1111) {
                            // ToDo : Do your stuff...
                            Intent res = result.getData();
                            Bundle myResults = res.getExtras();
                            Double vresult = myResults.getDouble("sum");
                            txt2.setText("sum is " + vresult);

                        } else  {
//                            Toast.makeText(MainActivity.this, ""+result, Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }