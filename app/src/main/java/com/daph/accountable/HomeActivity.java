package com.daph.accountable;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Henry on 2016-08-21.
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_home);
        SharedPreferences prefs = this.getSharedPreferences(
                "com.daph.accountable", Context.MODE_PRIVATE);
        String name = prefs.getString("com.daph.accountable.name", "");

        if (!"".equals(name)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void addName (View view) {
        String name = ((EditText) findViewById(R.id.nameField)).getText().toString();
        if ("".equals(name)) return;
        SharedPreferences prefs = this.getSharedPreferences(
                "com.daph.accountable", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("com.daph.accountable.name", name);
        editor.commit();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
