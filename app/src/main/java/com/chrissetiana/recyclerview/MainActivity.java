package com.chrissetiana.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GreenAdapter.ListItemClickListener {

    private static final int NUM_LIST_ITEMS = 100;
    private GreenAdapter adapter;
    private RecyclerView numberList;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberList = findViewById(R.id.rv_numbers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        numberList.setLayoutManager(layoutManager);
        numberList.setHasFixedSize(true);

        adapter = new GreenAdapter(NUM_LIST_ITEMS, this);
        numberList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_refresh:
                adapter = new GreenAdapter(NUM_LIST_ITEMS, this);
                numberList.setAdapter(adapter);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        if (toast != null) {
            toast.cancel();
        }

        String toastMessage = "Item # " + clickedItemIndex + " clicked.";
        toast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
        toast.show();

        Log.d("MainActivity", "Item # " + clickedItemIndex + " clicked.");
    }
}
