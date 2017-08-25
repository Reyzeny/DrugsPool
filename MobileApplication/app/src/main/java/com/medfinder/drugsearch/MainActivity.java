package com.medfinder.drugsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AutoCompleteTextView suggest;
    Button btnSearch, btnSeeAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearch = (Button) findViewById(R.id.search_button);
        btnSeeAll = (Button) findViewById(R.id.see_all);
        btnSearch.setOnClickListener(this);
        btnSeeAll.setOnClickListener(this);
        // create text auto complete
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        suggest = (AutoCompleteTextView)
                findViewById(R.id.search);
        suggest.setThreshold(1);
        suggest.setAdapter(adapter);
    }
    // Array of the drugs in stock
    private static final String[] COUNTRIES = new String[] {
            "Atripla", "Dulera", "Atropine", "fasprin", "ecprin"};
    // Method to get text from search box.
    public String autoSuggest(){
        return suggest.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_button:
                performSearch();
                break;
            case R.id.see_all:
                search_all();
                break;
        }
    }

    private void search_all() {
        Intent intent = new Intent(this,DrugDetails.class);
        intent.putExtra("search","all");
        startActivity(intent);
    }

    private void performSearch() {
        String search = suggest.getText().toString().trim();
        if(search==null || search.isEmpty()){
            suggest.setError("Enter something to search");
            suggest.requestFocus();
            return;
        }
        Intent intent = new Intent(this,DrugDetails.class);
        intent.putExtra("search",search);
        startActivity(intent);
    }
}
