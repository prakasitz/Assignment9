package com.mydomain.app.week9.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mydomain.app.week9.R;
import com.mydomain.app.week9.util.DBHelper;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener {

    private DBHelper dbHelper;
    private EditText etAddName, etAddAge, etAddSalary;
    private Button btnAddEmploy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        dbHelper = new DBHelper(this);

        etAddName = (EditText) findViewById(R.id.etAddName);
        etAddAge = (EditText) findViewById(R.id.etAddAge);
        etAddSalary = (EditText) findViewById(R.id.etAddSalary);

        btnAddEmploy = (Button) findViewById(R.id.btnAddEmployee);
        btnAddEmploy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = etAddName.getText().toString();
        int age = Integer.parseInt(etAddAge.getText().toString());
        double salary = Double.valueOf(etAddSalary.getText().toString());
        if ("".equals(name) || name.length() == 0){
            Toast.makeText(this, "Cannot add - Contact name is empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        dbHelper.addContact(name, age, salary);
        Toast.makeText(this, "New contact added!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
