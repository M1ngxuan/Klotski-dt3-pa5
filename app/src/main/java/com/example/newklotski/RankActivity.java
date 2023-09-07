// This class represents the RankActivity, which displays a list of ranked game levels
// and the number of steps taken to complete each level.
package com.example.newklotski;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RankActivity extends AppCompatActivity {

    private ListView listView; // ListView to display the ranked game levels
    private ArrayList<String> rankList = new ArrayList<>(); // List to store ranked game data
    private ArrayAdapter<String> adapter; // Adapter to connect the list data to the ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        listView = findViewById(R.id.rank_list);

        // Set up the ArrayAdapter to display the rankList data in the ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rankList);
        listView.setAdapter(adapter);

        // Load ranked game data from the database and populate the rankList
        loadData();
    }

    // This method retrieves ranked game data from the database and populates the rankList.
    private void loadData() {
        DataHelper dbHelper = new DataHelper(this, DataHelper.DATABASE_NAME, null, 1);
        SQLiteDatabase sqliteDatabase = dbHelper.getReadableDatabase();

        // Query the database to retrieve game_name and steps, ordered by game_name and steps.
        Cursor cursor = sqliteDatabase.rawQuery("SELECT game_name, steps FROM user ORDER BY game_name ASC, steps ASC", null);

        while (cursor.moveToNext()) {
            String gameName = cursor.getString(cursor.getColumnIndex("game_name"));
            int steps = cursor.getInt(cursor.getColumnIndex("steps"));

             // Format the game level and steps, then add it to rankList.
            String formattedGameName = "Level " + (Integer.parseInt(gameName) + 1);

            rankList.add(formattedGameName + ": " + steps + " steps");
        }
        cursor.close();
        sqliteDatabase.close();

        // Notify the adapter that data has changed so it updates the ListView.
        adapter.notifyDataSetChanged();
    }

}
