package com.project.proyek2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
    ListView listSayur;
    String[] sayuran = {"Bayam","Kangkung","Wortel","Sawi","Kacang Panjang","Buncis","Kentang","Selada"
                        ,"Brokoli"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().setTitle("List View");

        listSayur = findViewById(R.id.lv_sayur);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, sayuran);

        listSayur.setAdapter(adapter);
        listSayur.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListActivity.this, "Memilih: "+sayuran[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}