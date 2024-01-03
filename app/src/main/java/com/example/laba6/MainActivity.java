package com.example.laba6;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private DBHelper helper;
    private SQLiteDatabase database;
    private ListView list;
    private Button button4, button5, button6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        helper = new DBHelper(getApplicationContext());

        try {
            database = helper.getWritableDatabase();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<HashMap<String, String>> eat = new ArrayList<>();
                HashMap<String, String> eats;
                Cursor cursor = database.rawQuery("SELECT * FROM eat", null);
                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {
                    eats = new HashMap<>();
                    eats.put("name", cursor.getString(1));
                    eats.put("description",cursor.getString(2) + "\n" + cursor.getString(3) + "руб.");
                    eat.add(eats);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        eat, android.R.layout.simple_list_item_2,
                        new String[]{"name", "description", "price"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );
                list.setAdapter(adapter);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<HashMap<String, String>> toys = new ArrayList<>();
                HashMap<String, String> toy;
                Cursor cursor = database.rawQuery("SELECT * FROM toys", null);
                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {
                    toy = new HashMap<>();
                    toy.put("name", cursor.getString(1));
                    toy.put("description",cursor.getString(2) + "\n" + cursor.getString(3) + "руб.");
                    toys.add(toy);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        toys, android.R.layout.simple_list_item_2,
                        new String[]{"name", "description", "price"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );
                list.setAdapter(adapter);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<HashMap<String, String>> clothes = new ArrayList<>();
                HashMap<String, String> thing;
                Cursor cursor = database.rawQuery("SELECT * FROM clothes", null);
                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {
                    thing = new HashMap<>();
                    thing.put("name", cursor.getString(1));
                    thing.put("description",cursor.getString(2) + "\n" + cursor.getString(3) + "руб.");
                    clothes.add(thing);
                    cursor.moveToNext();
                }
                cursor.close();

                SimpleAdapter adapter = new SimpleAdapter(
                        getApplicationContext(),
                        clothes, android.R.layout.simple_list_item_2,
                        new String[]{"name", "description", "price"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );
                list.setAdapter(adapter);
            }
        });
    }
}