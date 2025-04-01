package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    TextView textKQ;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Anh xa id
        textKQ = findViewById(R.id.textKQ);
        btnBack = findViewById(R.id.btnBack);
        //Nhan Intent
        Intent myIntent = getIntent();
        //Lay bundle khoi intent
        Bundle myBundle = myIntent.getBundleExtra("mypackage");
        //Lay du lieu khoi bundle
        String HoTen = myBundle.getString("HoTen");
        String Mssv = myBundle.getString("Mssv");
        String Lop = myBundle.getString("Lop");
        String Sdt = myBundle.getString("Sdt");
        String SvNam = myBundle.getString("SvNam");
        String chuyenNganh = myBundle.getString("chuyenNganh");
        String PhatTrien = myBundle.getString("PhatTrien");
        textKQ.setText("Họ và tên: " + HoTen + "\n\n" + "MSSV: " + Mssv + "\n\n" + "Lớp: " + Lop + "\n\n" + "SĐT: " + Sdt + "\n\n"
                       + "Sinh viên: " + SvNam + "\n\n" + "Chuyên ngành: " + chuyenNganh + "\n\n" +
                       "Kế hoạch phát triển bản thân: " + "\n" + PhatTrien);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}