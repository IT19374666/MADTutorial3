package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private EditText inputno1,inputno2;
    private String num1,num2;
    private Button button;
    public static final String tag_number1 = "Activity1_input1";
    public static final String tag_number2 = "Activity1_input2";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        inputno1 = findViewById(R.id.enter_Number1);
        inputno2 = findViewById(R.id.enterNumber2);
        button = findViewById(R.id.Ok_btn);


        LayoutInflater laIn = getLayoutInflater();
        View layout = laIn.inflate(R.layout.activity_custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout));


        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);
        toast.show();
    }

    protected void onResume() {
        super.onResume();

        button.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v) {
                openSecondActivity();
                showToast();
            }
        }));


    }

    public void openSecondActivity() {
        num1 = inputno1.getText().toString();
        num2 = inputno2.getText().toString();
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(tag_number1,num1);
        intent.putExtra(tag_number2,num2);
        startActivity(intent);


    }
    public void showToast() {
        Context context = getApplicationContext();
        CharSequence message = "You just clicked the OK button";
        //Display string
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();

    }


}