package com.daph.accountable;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ArrayAdapter;
        import android.widget.LinearLayout;
        import android.widget.ProgressBar;
        import android.widget.Spinner;
        import android.widget.TextView;

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

}
