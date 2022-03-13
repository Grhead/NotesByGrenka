package com.example.notesbygrenka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText UserNotes;
    Button AddBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddBtn = (Button) findViewById(R.id.AddBtn);
        UserNotes = (EditText) findViewById(R.id.UserNote);
        ArrayList<String> notes = new ArrayList<>();
        SharedPreferences memory = getSharedPreferences("Notes", MODE_PRIVATE);
        SharedPreferences.Editor editor = memory.edit();
        int backup = memory.getInt("Integer", 0);
        String key = "";
        for (int i = 0; i < backup; i++){
            key = "Note" + i;
            notes.add(memory.getString(key, ""));
        }
        RecyclerView DogsView = findViewById(R.id.RecLine);
        NotesLayout adapter = new NotesLayout();
        adapter.setData(notes);
        DogsView.setLayoutManager(new LinearLayoutManager(this));
        DogsView.setAdapter(adapter);

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentP = memory.getInt("Integer", 0);
                String UserInput = UserNotes.getText().toString();
                notes.add(UserInput);
                editor.putString("Note" + currentP, UserInput);
                currentP++;
                editor.putInt("Integer", currentP);
                editor.apply();
                adapter.setData(notes);

            }
        });
    }

}