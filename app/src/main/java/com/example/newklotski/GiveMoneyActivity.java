/**
 * This class represents the GiveMoneyActivity, which is an activity in the Android app.
 * It is responsible for displaying the user interface related to giving money or donations.
 * The activity extends AppCompatActivity and overrides the onCreate method to set the content view.
 */
package com.example.newklotski;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GiveMoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_money); // Set the layout for this activity
    }
}
