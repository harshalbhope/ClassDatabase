package com.example.acer.classdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    Button btnUpdateSave;
    EditText etUpdateRno, etUpdateName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        btnUpdateSave = (Button)findViewById(R.id.btnUpdateSave);
        etUpdateName = (EditText)findViewById(R.id.etUpdateName);
        etUpdateRno = (EditText)findViewById(R.id.etUpdateRno);

        btnUpdateSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rno = etUpdateRno.getText().toString();
                if (rno.length() == 0){
                    etUpdateRno.setError("Rno is empty");
                    etUpdateRno.requestFocus();
                    return;
                }
                String name = etUpdateName.getText().toString();
                if (name.length() == 0){
                    etUpdateName.setError("Name is empty");
                    etUpdateName.requestFocus();
                    return;
                }

                MainActivity.db.updateRecord(Integer.parseInt(rno),name);
                etUpdateRno.setText("");
                etUpdateName.setText("");
                etUpdateRno.requestFocus();
            }
        });
    }
}
