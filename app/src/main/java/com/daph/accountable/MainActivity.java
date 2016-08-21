package com.daph.accountable;

        import android.content.Intent;
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

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {
    User user;
    Spinner choose;
    ProgressBar XP;
    LinearLayout level;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = new User();
        initializeSpinner();
        initializeLevel();
        initializePoints();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("users");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("database", "hey I got something");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
        text1 = (TextView) findViewById(R.id.textView3);
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
