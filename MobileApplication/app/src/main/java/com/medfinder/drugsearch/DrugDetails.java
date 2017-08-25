package com.medfinder.drugsearch;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by pelum on 8/23/2017.
 */

public class DrugDetails extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter adapter;
    private ProgressBar progressBar;
    private ArrayList<DrugModel> drugModels;
    private ArrayList<DrugModel> result;
    private String searchquery;
    private boolean loadDone = false;
    private TextView tvNoDrug;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchquery = getIntent().getStringExtra("search");

        setContentView(R.layout.activity_drug_details);
        mRecyclerView = (RecyclerView) findViewById(R.id.recDrugDetails);
        progressBar = (ProgressBar) findViewById(R.id.drugdetails_pgbar);
        tvNoDrug = (TextView) findViewById(R.id.tvNo_drug_found);

        tvNoDrug.setVisibility(View.GONE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(drugModels==null || drugModels.size()==0) {

            progressBar.setVisibility(View.VISIBLE);

            int secondsDelayed = 1;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    loadDrug();
                }
            }, secondsDelayed * 3000);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            finish();
        }
        return true;
    }

    private synchronized void loadDrug() {
//        LoadDrug loadDrug = new LoadDrug();
//        loadDrug.execute();

        LoadArrayList();
        if(searchquery.equals("all")){
            result = drugModels;
        }else {
            result = new ArrayList<>();
            for (int i = 0; i < drugModels.size(); i++) {
                if (drugModels.get(i).getName().toLowerCase().contains(searchquery.toLowerCase())) {
                    result.add(drugModels.get(i));
                }
            }
        }




        if(result==null || result.size()==0){
            tvNoDrug.setVisibility(View.VISIBLE);

        }else {
            pasteToRecyclerView();
        }

        progressBar.setVisibility(View.GONE);
    }

    private void LoadArrayList() {
        drugModels = new ArrayList<>();
        DrugModel model1 = new DrugModel();
        model1.setDrug_id(1);
        model1.setName("Doxycylin");
        model1.setDisease("Acne, Rashes, skin irritation");
        model1.setDosage("Rub on skin after bath");
        model1.setManufacturer("Comodox");
        model1.setEffect("No side effect");
        model1.setDrawable(getResources().getDrawable(R.drawable.image1));

        DrugModel model2 = new DrugModel();
        model2.setDrug_id(2);
        model2.setName("Atripla");
        model2.setDisease("HIV/AIDS");
        model2.setDosage("4 at morning, 2 at Night");
        model2.setManufacturer("Lenri pharmaceuticals");
        model2.setEffect("Causes stomach upset when taken with alcohol");
        model2.setDrawable(getResources().getDrawable(R.drawable.image2));

        DrugModel model3 = new DrugModel();
        model3.setDrug_id(3);
        model3.setName("Dulera");
        model3.setDisease("Asthma");
        model3.setDosage("1 at morning, 2 at Night");
        model3.setManufacturer("Lenri pharmaceuticals");
        model3.setEffect("No side effect");
        model3.setDrawable(getResources().getDrawable(R.drawable.image3));

        DrugModel model4 = new DrugModel();
        model4.setDrug_id(4);
        model4.setName("Atorvastatine");
        model4.setDisease("Cholesterol");
        model4.setDosage("2 at morning,1 at afternoon, 2 at Night");
        model4.setManufacturer("Bright pharmaceuticals");
        model4.setEffect("Causes diziness");
        model4.setDrawable(getResources().getDrawable(R.drawable.image4));

        DrugModel model5 = new DrugModel();
        model5.setDrug_id(5);
        model5.setName("Atropine");
        model5.setDisease("Fibromyaglia");
        model5.setDosage("2 teaspoonful morning and evening");
        model5.setManufacturer("May & Baker Plc.");
        model5.setEffect("No side effect");
        model5.setDrawable(getResources().getDrawable(R.drawable.image5));


        DrugModel model6 = new DrugModel();
        model6.setDrug_id(6);
        model6.setName("penycylin");
        model6.setDisease("swollen skin, pain, rashes");
        model6.setDosage("Rub on skin after bath");
        model6.setManufacturer("Comodox");
        model6.setEffect("Skin feels numb after use");
        model6.setDrawable(getResources().getDrawable(R.drawable.image1));


        DrugModel model7 = new DrugModel();
        model7.setDrug_id(7);
        model7.setName("fasprin");
        model7.setDisease("Acne, Rashes, skin irritation");
        model7.setDosage("Rub on skin after bath");
        model7.setManufacturer("anudio pharmeceuticals");
        model7.setEffect("Causes cattarh when taken with 7up");
        model7.setDrawable(getResources().getDrawable(R.drawable.image3));


        DrugModel model8 = new DrugModel();
        model8.setDrug_id(8);
        model8.setName("aspirin");
        model8.setDisease("Mental disorder");
        model8.setDosage("1 in the morning");
        model8.setManufacturer("Elaxor");
        model8.setEffect("No side effect");
        model8.setDrawable(getResources().getDrawable(R.drawable.image2));


        DrugModel model9 = new DrugModel();
        model9.setDrug_id(9);
        model9.setName("halfprin");
        model9.setDisease("Acne, Rashes, skin irritation");
        model9.setDosage("Rub on skin after bath");
        model9.setManufacturer("Comodox");
        model9.setEffect("No side effect");
        model9.setDrawable(getResources().getDrawable(R.drawable.image4));


        DrugModel model10 = new DrugModel();
        model10.setDrug_id(10);
        model10.setName("zorprin");
        model10.setDisease("Acne, Rashes, skin irritation");
        model10.setDosage("Rub on skin after bath");
        model10.setManufacturer("Comodox");
        model10.setEffect("No side effect");
        model10.setDrawable(getResources().getDrawable(R.drawable.image1));

        DrugModel model11 = new DrugModel();
        model11.setDrug_id(11);
        model11.setName("ecprin");
        model11.setDisease("Acne, Rashes, skin irritation");
        model11.setDosage("Rub on skin after bath");
        model11.setManufacturer("Comodox");
        model11.setEffect("No side effect");
        model11.setDrawable(getResources().getDrawable(R.drawable.image2));


        drugModels.add(model1);drugModels.add(model2);drugModels.add(model3);drugModels.add(model4);drugModels.add(model5);
        drugModels.add(model6);drugModels.add(model7);drugModels.add(model8);drugModels.add(model9);drugModels.add(model10);
        drugModels.add(model11);
    }

    private void pasteToRecyclerView() {
        if (adapter == null) {
            adapter = new DrugAdapter(result);
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

}
