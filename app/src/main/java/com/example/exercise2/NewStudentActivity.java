package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.exercise2.model.Model;
import com.example.exercise2.model.Student;

import java.util.List;

public class NewStudentActivity extends AppCompatActivity {
    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_new);

        data = Model.instance.getAllStudents();
        EditText newName = (EditText) findViewById(R.id.new_nameField);
        EditText newID = (EditText) findViewById(R.id.new_idField);
        EditText newPhone = (EditText) findViewById(R.id.new_phoneField);
        EditText newAddress = (EditText) findViewById(R.id.new_addressField);
        CheckBox newCheckBox = findViewById(R.id.new_checkBox);
        Button cancelButton = (Button) findViewById(R.id.new_cancelButton);
        Button saveButton = (Button) findViewById(R.id.new_saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG","save new was clicked");
                Student s = new Student(newName.getText().toString(), newID.getText().toString(),
                        newCheckBox.isChecked(), newPhone.getText().toString(), newAddress.getText().toString());
                data.add(s);
                Intent i = new Intent(view.getContext(), StudentListRvActivity.class);
                startActivity(i);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG","cancel new was clicked");
                Intent i = new Intent(view.getContext(), StudentListRvActivity.class);
                startActivity(i);
            }
        });
    }
}
