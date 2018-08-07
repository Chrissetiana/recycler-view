package com.chrissetiana.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_LIST_ITEMS = 100;
    private GreenAdapter adapter;
    private RecyclerView numberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberList = findViewById(R.id.rv_numbers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        numberList.setLayoutManager(layoutManager);

        numberList.setHasFixedSize(true);

        adapter = new GreenAdapter(NUM_LIST_ITEMS);
        numberList.setAdapter(adapter);
    }
}
