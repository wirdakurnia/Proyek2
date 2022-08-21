package com.project.proyek2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KalkulatorActivity extends AppCompatActivity {
    EditText inputAngka1, inputAngka2;
    Button btnTambah, btnKurang, btnKali, btnBagi, btnReset, btnInputNama, btnList;
    TextView hasil;
    private double angka1, angka2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);
        getSupportActionBar().setTitle("Kalkulator");

        inputAngka1 = findViewById(R.id.etAngka1);
        inputAngka2 = findViewById(R.id.etAngka2);
        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        btnReset = findViewById(R.id.btnReset);
        hasil = findViewById(R.id.txtHasil);
        btnInputNama = findViewById(R.id.btnInputNama);
        btnList = findViewById(R.id.btnList);

        btnTambah.setOnClickListener(view -> {
            if(TextUtils.isEmpty(inputAngka1.getText().toString()) && TextUtils.isEmpty(inputAngka2.getText().toString())){
                validasi();
            }else{
                getInputAngka();
                hasil.setText(String.valueOf(hitung('+', angka1, angka2)));
            }
        });
        btnKurang.setOnClickListener(view -> {
            if(TextUtils.isEmpty(inputAngka1.getText().toString()) && TextUtils.isEmpty(inputAngka2.getText().toString())){
                validasi();
            }else{
                getInputAngka();
                hasil.setText(String.valueOf(hitung('-', angka1, angka2)));
            }
        });
        btnKali.setOnClickListener(view -> {
            if(TextUtils.isEmpty(inputAngka1.getText().toString()) && TextUtils.isEmpty(inputAngka2.getText().toString())){
                validasi();
            }else{
                getInputAngka();
                hasil.setText(String.valueOf(hitung('*', angka1, angka2)));
            }
        });
        btnBagi.setOnClickListener(view -> {
            if(TextUtils.isEmpty(inputAngka1.getText().toString()) && TextUtils.isEmpty(inputAngka2.getText().toString())){
                validasi();
            }else if(inputAngka2.getText().toString().equals("0")){
                Toast.makeText(this,"Tak Terhingga",Toast.LENGTH_LONG).show();
            }else{
                getInputAngka();
                hasil.setText(String.valueOf(hitung('/', angka1, angka2)));
            }
        });
        btnReset.setOnClickListener(view -> {
            inputAngka1.setText("");
            inputAngka2.setText("");
            hasil.setText("0");
        });

        btnInputNama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KalkulatorActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KalkulatorActivity.this, ListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void getInputAngka(){
        angka1 = Double.parseDouble(inputAngka1.getText().toString());
        angka2 = Double.parseDouble(inputAngka2.getText().toString());
    }

    private void validasi(){
        Toast.makeText(this, "Mohon masukkan Angka pertama & kedua", Toast.LENGTH_LONG).show();
    }

    private double hitung(char operator, double angka1, double angka2){
        switch (operator){
            case '+':
                return angka1 + angka2;
            case '-':
                return angka1 - angka2;
            case '*':
                return angka1 * angka2;
            case '/':
                return angka1 / angka2;
            default:
                return 0;
        }
    }
}