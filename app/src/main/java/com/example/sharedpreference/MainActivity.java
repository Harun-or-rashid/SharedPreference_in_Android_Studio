package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edit_name;
    EditText edit_phone;
    Button   btn_save;
    Button   btn_show;
    EditText result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_name =(EditText) findViewById(R.id.edit_name);
        edit_phone =(EditText) findViewById(R.id.edit_phone);
        result =(EditText) findViewById(R.id.result);


    }
}
