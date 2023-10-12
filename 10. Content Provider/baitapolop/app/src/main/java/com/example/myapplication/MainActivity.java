package com.example.myapplication;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="ContentProviderDemo";

    private TextView textViewQueryResult;

    private String [] mColumnProjection=new String[]{
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.HAS_PHONE_NUMBER};

    private String mSelectionCluse=ContactsContract.Contacts.DISPLAY_NAME_PRIMARY+ " = ?";

    private String [] mSelectionArguments = new String [] {"Ajay"};

    private String mOrderBy=ContactsContract.Contacts.DISPLAY_NAME_PRIMARY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnAddBulk = findViewById(R.id.btnAddBulk);
        EditText etInput = findViewById(R.id.etInput);
        EditText etNumberInput = findViewById(R.id.etNumberInput);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert(etInput.getText().toString(),etNumberInput.getText().toString());
            }
        });

        textViewQueryResult=(TextView)findViewById(R.id.textViewQueryResult);

        ContentResolver contentResolver=getContentResolver();
        Cursor cursor=contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                mColumnProjection,
                null,
                null,
                null);

        if(cursor!=null && cursor.getCount()>0){
            StringBuilder stringBuilderQueryResult=new StringBuilder("");
            while (cursor.moveToNext()){
                stringBuilderQueryResult.append(cursor.getString(0)+" , "+cursor.getString(1)+" , "+cursor.getString(2)+"\n");
            }
            textViewQueryResult.setText(stringBuilderQueryResult.toString());
        }else{
            textViewQueryResult.setText("No Contacts in device");
        }
    }

    // Add this method
    private void insert(String name, String number) {
        ContentResolver contentResolver = getContentResolver();

        ContentValues values = new ContentValues();
        values.put(ContactsContract.Contacts.DISPLAY_NAME, name);
        // Assuming that "number" refers to a phone number field, adjust this accordingly
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, String.valueOf(number));

        Uri contactUri = contentResolver.insert(ContactsContract.Contacts.CONTENT_URI, values);

        if (contactUri != null) {
            Log.d(TAG, "Contact inserted successfully");
        } else {
            Log.e(TAG, "Failed to insert contact");
        }
    }

}