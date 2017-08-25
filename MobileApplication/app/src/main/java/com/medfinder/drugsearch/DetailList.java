package com.medfinder.drugsearch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pelum on 8/25/2017.
 */

public class DetailList extends AppCompatActivity {
    private ImageView imageView;
    private TextView tvName, tvCure, tvDosage, tvManufacturer, tvEffect;
    private String Name,Cure,Dosage,Manufacturer,Effect;
    private byte[] ba;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ba=getIntent().getByteArrayExtra("image");
        Name = getIntent().getStringExtra("name");
        Cure = getIntent().getStringExtra("cure");
        Dosage = getIntent().getStringExtra("dosage");
        Manufacturer = getIntent().getStringExtra("manufacturer");
        Effect = getIntent().getStringExtra("effect");

        setContentView(R.layout.drug_details_list);
        imageView = (ImageView) findViewById(R.id.list_image);
        tvName = (TextView) findViewById(R.id.list_tvName);
        tvCure = (TextView) findViewById(R.id.list_tvCure);
        tvDosage = (TextView) findViewById(R.id.list_tvDosage);
        tvManufacturer = (TextView) findViewById(R.id.list_tvManufacturer);
        tvEffect = (TextView) findViewById(R.id.list_tvEffect);

        Bitmap bmp = BitmapFactory.decodeByteArray(ba, 0, ba.length);

        imageView.setImageBitmap(bmp);
        tvName.setText(Name);
        tvCure.setText(Cure);
        tvDosage.setText(Dosage);
        tvManufacturer.setText(Manufacturer);
        tvEffect.setText(Effect);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return true;
    }
}
