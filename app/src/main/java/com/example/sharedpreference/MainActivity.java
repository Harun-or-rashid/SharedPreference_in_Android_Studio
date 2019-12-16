package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        btn_save =(Button)findViewById(R.id.btn_save);
        btn_show=(Button) findViewById(R.id.btn_show);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edit_name.getText().toString();
                String phone=edit_phone.getText().toString();

                if (name.equals("")&&phone.equals("")){
                    Toast.makeText(getApplicationContext(),"Please Enter Name and Phone",Toast.LENGTH_SHORT).show();
                }
                else{
                    SharedPreferences sharedPreferences=getSharedPreferences("Mydata", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nameKey",name);
                    editor.putString("phoneKey",phone);
                    editor.apply();
                    Toast.makeText(getApplicationContext(),"Saved Successfully",Toast.LENGTH_SHORT).show();

                }

            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("Mydata",Context.MODE_PRIVATE);
                if (sharedPreferences.contains("nameKey")&&sharedPreferences.contains("phoneKey")){
             String saved_name =      sharedPreferences.getString("nameKey","No Data Found");
             String saved_phone =    sharedPreferences.getString("phoneKey","No Data Found");

             result.setText(saved_name+"\n"+saved_phone);
                }
            }
        });


    }
}
