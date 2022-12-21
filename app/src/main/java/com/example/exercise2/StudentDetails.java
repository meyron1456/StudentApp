package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.exercise2.model.Model;
import com.example.exercise2.model.Student;

public class StudentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list_details);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int dataPosition = extras.getInt("position");
            Student student = Model.instance.getStudent(dataPosition);
            TextView nameText= findViewById(R.id.nameField);
            TextView idText= findViewById(R.id.idField);
            TextView phoneText= findViewById(R.id.phoneField);
            TextView addressText = findViewById(R.id.addressField);
            CheckBox checkButton = findViewById(R.id.checkBox);

            nameText.setText(student.getName());
            idText.setText(student.getId());
            phoneText.setText(student.getPhoneNumber());
            addressText.setText(student.getAddress());
            checkButton.setChecked(student.getIsChecked());
            checkButton.setClickable(false);
            Button editButton = (Button) findViewById(R.id.details_buttonEdit);
            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("TAG","edit details was clicked " + dataPosition);
                    Intent i = new Intent(getApplicationContext(), EditStudentActivity.class);
                    i.putExtra("position",dataPosition);
                    startActivity(i);
                }
            });
        }
    }
}