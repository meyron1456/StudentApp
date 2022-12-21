package com.example.exercise2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.exercise2.model.Model;
import com.example.exercise2.model.Student;

import java.util.List;

public class StudentListRvActivity extends AppCompatActivity {
    List<Student> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list_rv_acivity);
        data = Model.instance.getAllStudents();
        RecyclerView list = findViewById(R.id.studentlist_rv);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter();
        list.setAdapter(adapter);

        Button plusButton = (Button)findViewById(R.id.plusButton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG","button + was clicked ");
                Intent i = new Intent(view.getContext(), NewStudentActivity.class);
                startActivity(i);
            }
        });

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("TAG","row was clicked " + position);
                Intent i = new Intent(getApplicationContext(), StudentDetails.class);
                i.putExtra("position",position);
                startActivity(i);
            }
        });
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameText;
        TextView idText;
        CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameText = itemView.findViewById(R.id.listrow_name_tv);
            idText = itemView.findViewById(R.id.listrow_id_tv);
            checkBox = itemView.findViewById(R.id.listrow_cb);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    listener.onItemClick(position);
                }
            });
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data.get(getAdapterPosition()).setIsChecked(checkBox.isChecked());
                }
            });
        }
    }

    interface OnItemClickListener{
        void onItemClick(int position);
    }
    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        OnItemClickListener listener;
        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row,parent,false);
            MyViewHolder viewHolder = new MyViewHolder(view,listener);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Student student = data.get(position);
            holder.nameText.setText(student.getName());
            holder.idText.setText(student.getId());
            holder.checkBox.setChecked(student.getIsChecked());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}