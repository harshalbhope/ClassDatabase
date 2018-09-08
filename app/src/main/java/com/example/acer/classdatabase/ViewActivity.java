package com.example.acer.classdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView tvViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        tvViewData = (TextView)findViewById(R.id.tvViewData);

        String data = MainActivity.db.viewRecord();
        if (data.length() == 0){
            tvViewData.setText("No records");
        }
        else tvViewData.setText(data);
    }
}
