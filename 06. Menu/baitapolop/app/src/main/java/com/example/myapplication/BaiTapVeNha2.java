package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class BaiTapVeNha2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap_ve_nha2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bai1_option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.miBtvn1Constraint:
                Intent intent = new Intent(this,btnv2Constraint.class);
                startActivity(intent);
                break;
            case R.id.miBtvn1Linear:
                Intent intent2 = new Intent(this,btnv2Linear.class);
                startActivity(intent2);
                break;
            case R.id.miBtvn1Relative:
                Intent intent3 = new Intent(this,btnv2Relative.class);
                startActivity(intent3);
                break;
            case R.id.miBtvn1Table:
                Intent intent4 = new Intent(this,btnv2Table.class);
                startActivity(intent4);
                break;
        }
        return true;
    }
}