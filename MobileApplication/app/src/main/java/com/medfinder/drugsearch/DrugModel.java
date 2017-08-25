package com.medfinder.drugsearch;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by pelum on 8/23/2017.
 */

class DrugModel {
    private int drug_id;
    private String name,disease, dosage, effect, manufacturer;
    private Drawable drawable;
    private Bitmap bitmap;

    public int getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(int drug_id) {
        this.drug_id = drug_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
