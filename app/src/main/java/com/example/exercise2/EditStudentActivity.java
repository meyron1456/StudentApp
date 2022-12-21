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

public class EditStudentActivity extends AppCompatActivity {
    List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_edit);
        studentList = Model.instance.getAllStudents();
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            int dataPosition = extras.getInt("position");
            Student student = Model.instance.getStudent(dataPosition);
            EditText nameText = (EditText) findViewById(R.id.edit_nameField);
            EditText idText = findViewById(R.id.edit_idField);
            EditText phoneText = findViewById(R.id.edit_phoneField);
            EditText addressText = findViewById(R.id.edit_addressField);
            CheckBox checkButton = findViewById(R.id.edit_checkBox);
            nameText.setText(student.getName());
            idText.setText(student.getId());
            phoneText.setText(student.getPhoneNumber());
            addressText.setText(student.getAddress());
            checkButton.setChecked(student.getIsChecked());

            Button cancelButton = (Button) findViewById(R.id.edit_cancelButton);
            Button saveButton = (Button) findViewById(R.id.edit_saveButton);
            Button deleteButton = (Button) findViewById(R.id.edit_deleteButton);

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("TAG","save edit was clicked");
                    student.setName(nameText.getText().toString());
                    student.setId(idText.getText().toString());
                    student.setIsChecked(checkButton.isChecked());
                    student.setPhoneNumber(phoneText.getText().toString());
                    student.setAddress(addressText.getText().toString());
                    Intent i = new Intent(view.getContext(), StudentListRvActivity.class);
                    startActivity(i);
                }
            });
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("TAG","cancel edit was clicked");
                    Intent i = new Intent(view.getContext(), StudentListRvActivity.class);
                    startActivity(i);
                }
            });
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("TAG","delete edit was clicked");
                    studentList.remove(dataPosition);
                    Intent i = new Intent(view.getContext(), StudentListRvActivity.class);
                    startActivity(i);
                }
            });
        }
    }
}