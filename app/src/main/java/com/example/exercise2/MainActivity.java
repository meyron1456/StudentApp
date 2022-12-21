package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {
    EditText nameText;
    EditText idText;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.main_name_et);
        idText = findViewById(R.id.main_id_et);
        checkBox = findViewById(R.id.main_cb);
        Button saveButton = findViewById(R.id.main_save_btn);
        Button cancelButton = findViewById(R.id.main_cancel_btn);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save() {
        String name = nameText.getText().toString();
        String id = idText.getText().toString();
        boolean flag = checkBox.isChecked();
        Log.d("TAG","saved name:" + name + " id:" + id + " flag:" + flag);
    }
}