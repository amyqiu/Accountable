package com.daph.accountable;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ArrayAdapter;
        import android.widget.Spinner;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner choose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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



}
