package com.mydomain.app.week9.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mydomain.app.week9.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnListEmployee, btnSearchEmployee, btnAddEmployee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btnListEmployee = (Button) findViewById(R.id.btnListEmployee);
        btnListEmployee.setOnClickListener(this);

        btnSearchEmployee = (Button) findViewById(R.id.btnSearchEmployee);
        btnSearchEmployee.setOnClickListener(this);

        btnAddEmployee = (Button) findViewById(R.id.btnAddEmployees);
        btnAddEmployee.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        if(v == btnListEmployee){
            i = new Intent(this, ListContactActivity.class);
        }
        else if(v == btnSearchEmployee){
            i = new Intent(this, SearchContactActivity.class);
        }
        else if(v == btnAddEmployee){
            i = new Intent(this, AddContactActivity.class);
        }
        startActivity(i);
    }
}
