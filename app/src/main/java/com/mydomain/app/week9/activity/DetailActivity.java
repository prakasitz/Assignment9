package com.mydomain.app.week9.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mydomain.app.week9.R;
import com.mydomain.app.week9.model.Contact;
import com.mydomain.app.week9.util.DBHelper;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private DBHelper dbHelper;
    public Contact contact;

    private TextView tvId;
    private EditText etName, etAge, etSalary;
    private Button btnUpdateEmployee, btnDeleteEmployee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dbHelper = new DBHelper(this);

        int contactId = getIntent().getIntExtra(DBHelper.COLUMN_ID, 0);
        contact = getContactFromId(contactId);

        tvId = (TextView) findViewById(R.id.tvId);
        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etSalary = (EditText) findViewById(R.id.etSalary);

        if (contact != null){
            tvId.setText("ID: " + contact.getId());
            etName.setText(contact.getName());
            etAge.setText(String.valueOf(contact.getEmail()));
            etSalary.setText(String.valueOf(contact.getPhone()));
        }

        btnUpdateEmployee = (Button) findViewById(R.id.btnUpdateEmployee);
        btnDeleteEmployee = (Button) findViewById(R.id.btnDeleteEmployee);
        btnUpdateEmployee.setOnClickListener(this);
        btnDeleteEmployee.setOnClickListener(this);
    }

    private Contact getContactFromId(int contactId){
        return dbHelper.getContactFromId(contactId);
    }

    @Override
    public void onClick(View v) {
        if (contact  == null){
            return;
        }
        if (v == btnUpdateEmployee){
            contact.setName(etName.getText().toString());
            contact.setEmail(Integer.parseInt(etAge.getText().toString()));
            contact.setPhone(Double.valueOf(etSalary.getText().toString()));

            dbHelper.updateContact(contact);

            Toast.makeText(this, "Employee updated!", Toast.LENGTH_SHORT).show();
            finish();
        }
        else if (v == btnDeleteEmployee){
            dbHelper.deleteContact(contact.getId());

            contact = null;

            Toast.makeText(this, "Employee deleted!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
