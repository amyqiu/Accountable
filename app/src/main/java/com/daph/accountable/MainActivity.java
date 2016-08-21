package com.daph.accountable;

        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.content.res.Resources;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.LinearLayout;
        import android.widget.ProgressBar;
        import android.widget.Spinner;
        import android.widget.TextView;

        import com.daph.accountable.model.User;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.text.Format;
        import java.util.ArrayList;
        import java.util.Formatter;
        import java.util.List;

public class MainActivity extends AppCompatActivity {
    User user;
    Spinner choose;
    ProgressBar XP;
    LinearLayout level;
    TextView text1;
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userList = new ArrayList<>();
        SharedPreferences prefs = this.getSharedPreferences(
                "com.daph.accountable", Context.MODE_PRIVATE);
        final String name = prefs.getString("com.daph.accountable.name", "");
        ((TextView) findViewById(R.id.textView)).setText(String.format(this.getResources().getString(R.string.Intro), name));
        user = null;
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("users");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("database", "hey I got something");
                ArrayList<User> userList = User.stringListToUserList((ArrayList<String>) dataSnapshot.getValue());
                int pos = User.userPos(name, userList);
                if (pos > -1) {
                    user = userList.get(pos);
                } else {
                    user = new User(name);
                    userList.add(user);
                }
                initializeLevel();
                initializePoints();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        initializeSpinner();
    }

    protected void initializeSpinner() {
        choose = (Spinner) findViewById(R.id.Points);
        //Listing the data into the spinner
        List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("By Week");
        spinnerArray.add("By Month");
        spinnerArray.add("By Year");
        spinnerArray.add("All Time");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choose.setAdapter(adapter);
    }

    protected void initializeLevel() {
        text1 = (TextView) findViewById(R.id.textView4);
        text1.setText(String.valueOf(user.getLevel()));
    }

    protected void initializePoints() {
        text1 = (TextView) findViewById(R.id.textView5);
        text1.setText(String.valueOf(user.getPoints()));
    }

    public void addAccomplishment(View view)
    {
        Intent intent = new Intent(MainActivity.this, AddAccomplishmentActivity.class);
        startActivity(intent);
    }

}
