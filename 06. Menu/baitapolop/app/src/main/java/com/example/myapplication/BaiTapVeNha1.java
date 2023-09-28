package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaiTapVeNha1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap_ve_nha1);
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
                Intent intent = new Intent(this,btvn1Constraint.class);
                startActivity(intent);
                break;
            case R.id.miBtvn1Linear:
                Intent intent2 = new Intent(this,btvn1Linear.class);
                startActivity(intent2);
                break;
            case R.id.miBtvn1Relative:
                Intent intent3 = new Intent(this,btvn1Relative.class);
                startActivity(intent3);
                break;
            case R.id.miBtvn1Table:
                Intent intent4 = new Intent(this,btnv1Table.class);
                startActivity(intent4);
                break;
        }
        return true;
    }
}