package com.example.acer.classdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText etAddRno, etAddName;
    Button btnAddSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etAddName = (EditText)findViewById(R.id.etAddName);
        etAddRno = (EditText)findViewById(R.id.etAddRno);
        btnAddSave = (Button)findViewById(R.id.btnAddSave);

        btnAddSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rno = etAddRno.getText().toString();
                if (rno.length() == 0){
                    etAddRno.setError("Rno is empty");
                    etAddRno.requestFocus();
                    return;
                }
                String name = etAddName.getText().toString();
                if (name.length() == 0){
                    etAddName.setError("Name is empty");
                    etAddName.requestFocus();
                    return;
                }

               MainActivity.db.addRecord(Integer.parseInt(rno),name);
                etAddRno.setText("");
                etAddName.setText("");
                etAddRno.requestFocus();
            }
        });
    }
}
