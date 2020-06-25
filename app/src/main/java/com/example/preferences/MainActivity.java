package com.example.preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE="Account";
    private static final String PREF_NAME="Name";
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nameBox=findViewById(R.id.nameBox);
        settings=getSharedPreferences(PREFS_FILE, MODE_PRIVATE);

        //получаем настройки
        String name=settings.getString(PREF_NAME, "");
        nameBox.setText(name);
    }

    @Override
    protected void onPause(){
        super.onPause();
        EditText nameBox=findViewById(R.id.nameBox);
        String name=nameBox.getText().toString();
        SharedPreferences.Editor prefEditor=settings.edit();
        prefEditor.putString(PREF_NAME, name);
        prefEditor.apply();
    }

    public void saveName(View view){
        //получаем введенное имя
        EditText nameBox=findViewById(R.id.nameBox);
        String name=nameBox.getText().toString();
        //сохраняем его в настройках
        SharedPreferences.Editor prefEditor=settings.edit();
        prefEditor.putString(PREF_NAME, name);
        prefEditor.apply();
    }

    public void getName(View view){
        //получаем сохраненое имя
        TextView nameView=findViewById(R.id.nameView);
        String name=settings.getString(PREF_NAME, "не определено");
        nameView.setText(name);
    }
}
