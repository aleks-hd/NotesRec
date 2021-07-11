package com.hfad.notesrec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    inittoolbar();
    }

    private void inittoolbar() {
        Toolbar toolbar = findViewById(R.id.toolBarContainer);
        setSupportActionBar(toolbar);
    }



}