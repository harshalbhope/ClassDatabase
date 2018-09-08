package com.example.acer.classdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {

    EditText etDeleteRno;
    Button btnDeleteSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        etDeleteRno = (EditText)findViewById(R.id.etDeleteRno);
        btnDeleteSave = (Button)findViewById(R.id.btnDeleteSave);

        btnDeleteSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rno = etDeleteRno.getText().toString();
                if (rno.length() == 0){
                    etDeleteRno.setError("Rno is empty");
                    etDeleteRno.requestFocus();
                    return;
                }
                MainActivity.db.deleteRecord(Integer.parseInt(rno));
                etDeleteRno.setText("");

                etDeleteRno.requestFocus();
            }
        });
    }
}
