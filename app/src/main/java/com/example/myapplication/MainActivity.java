package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen, edtMssv, edtLop, edtSdt, edtPhatTrien;
    Button btnGui, btnXoa;
    RadioGroup rdNam;
    CheckBox checkDT, checkVT, checkMTHTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Anh xa id
        edtHoTen = findViewById(R.id.edtHoTen);
        edtMssv = findViewById(R.id.edtMssv);
        edtLop = findViewById(R.id.edtLop);
        edtSdt = findViewById(R.id.edtSdt);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtPhatTrien = findViewById(R.id.edtPhatTrien);
        btnGui = findViewById(R.id.btnGui);
        btnXoa = findViewById(R.id.btnXoa);
        rdNam = findViewById(R.id.rdNam);
        checkDT = findViewById(R.id.checkDT);
        checkVT = findViewById(R.id.checkVT);
        checkMTHTN = findViewById(R.id.checkMTHTN);
        // Xu ly listen vao button
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                //Thong tin sinh vien
                String HoTen = edtHoTen.getText().toString();
                String Mssv = edtMssv.getText().toString();
                String Lop = edtLop.getText().toString();
                String Sdt = edtSdt.getText().toString();
                //Sinh vien nam
                int idselect = rdNam.getCheckedRadioButtonId();
                RadioButton rdselect = findViewById(idselect);
                String SvNam = rdselect.getText().toString();
                //Chuyen nganh
                String chuyenNganh = "";
                if (checkDT.isChecked())
                    chuyenNganh += checkDT.getText().toString() + " ";
                if (checkVT.isChecked())
                    chuyenNganh += checkVT.getText().toString()+ " ";
                if (checkMTHTN.isChecked())
                    chuyenNganh += checkMTHTN.getText().toString()+ " ";
                //Ke hoach phat trien
                String PhatTrien = edtPhatTrien.getText().toString();
                //Dong goi du lieu vao bundle
                Bundle myBundle = new Bundle();
                //Dua du lieu vao bundle
                myBundle.putString("HoTen", HoTen);
                myBundle.putString("Mssv", Mssv);
                myBundle.putString("Lop", Lop);
                myBundle.putString("Sdt", Sdt);
                myBundle.putString("SvNam", SvNam);
                myBundle.putString("chuyenNganh", chuyenNganh);
                myBundle.putString("PhatTrien", PhatTrien);
                myIntent.putExtra("mypackage", myBundle);
                startActivity(myIntent);
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHoTen.setText("");
                edtMssv.setText("");
                edtLop.setText("");
                edtSdt.setText("");
                edtPhatTrien.setText("");
                rdNam.clearCheck();
                checkDT.setChecked(false);
                checkVT.setChecked(false);
                checkMTHTN.setChecked(false);
            }
        });
    }
}