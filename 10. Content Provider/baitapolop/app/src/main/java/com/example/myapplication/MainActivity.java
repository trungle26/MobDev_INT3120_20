package com.example.myapplication;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextWord;
    Button buttonAdd;
    ListView listViewWords;
    ArrayAdapter<String> adapter;
    ArrayList<String> wordList;

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editTextWord = findViewById(R.id.editTextWord);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewWords = findViewById(R.id.listViewWords);

        wordList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wordList);
        listViewWords.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = editTextWord.getText().toString();
                addToUserDictionary(word);
            }
        });

        loadWordsFromUserDictionary();

    }
    private void addToUserDictionary(String word) {
        ContentResolver resolver = getContentResolver();
        ContentValues values = new ContentValues();
        values.put(UserDictionary.Words.APP_ID, "com.example.myapplication");
        values.put(UserDictionary.Words.LOCALE, "en_US");
        values.put(UserDictionary.Words.WORD, word);
        resolver.insert(UserDictionary.Words.CONTENT_URI, values);

        loadWordsFromUserDictionary();
        Log.d("DictionaryDemo", "Adding word: " + word);

    }

    private void loadWordsFromUserDictionary() {
        wordList.clear();
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(UserDictionary.Words.CONTENT_URI,
                new String[]{UserDictionary.Words.WORD}, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String word = cursor.getString(cursor.getColumnIndex(UserDictionary.Words.WORD));
                wordList.add(word);
            }
            cursor.close();
            // Create a new adapter and set it to the ListView
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wordList);
            listViewWords.setAdapter(adapter);
        }
    }

}