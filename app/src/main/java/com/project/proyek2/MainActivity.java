package com.project.proyek2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etInput;
    Button btnInput, btnKalkulator;
    TextView outputNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Input Nama");

        etInput = findViewById(R.id.etNama);
        btnInput = findViewById(R.id.btnInput);
        outputNama = findViewById(R.id.txtHasil);
        btnKalkulator = findViewById(R.id.btnKalkulator);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etInput.getText().toString();
                outputNama.setText(nama);
                etInput.setText("");
            }
        });

        btnKalkulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, KalkulatorActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}