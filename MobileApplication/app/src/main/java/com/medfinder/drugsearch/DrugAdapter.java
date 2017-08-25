package com.medfinder.drugsearch;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by pelum on 8/23/2017.
 */

class DrugAdapter extends RecyclerView.Adapter<DrugAdapter.Viewholder> {
    private ArrayList<DrugModel> drugModels;
    public DrugAdapter(ArrayList<DrugModel> drugModels) {
        this.drugModels = drugModels;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drug_search_design,parent,false);
        Viewholder vh = new Viewholder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final Viewholder holder, final int position) {
        holder.img.setImageDrawable(drugModels.get(position).getDrawable());
        holder.tvName.setText(drugModels.get(position).getName());
        holder.tvDisease.setText(drugModels.get(position).getDisease());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(v.getContext(),DetailList.class);

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                holder.img.buildDrawingCache();
                Bitmap b = holder.img.getDrawingCache();
                b.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] ba = stream.toByteArray();

                intent.putExtra("image",ba);
                intent.putExtra("name",drugModels.get(position).getName());
                intent.putExtra("cure",drugModels.get(position).getDisease());
                intent.putExtra("dosage",drugModels.get(position).getDosage());
                intent.putExtra("manufacturer",drugModels.get(position).getManufacturer());
                intent.putExtra("effect",drugModels.get(position).getEffect());

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(drugModels!=null && drugModels.size()>0){
            return drugModels.size();

        }
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView img;
        private TextView tvName, tvDisease;
        public Viewholder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.drug_cardview);
            img = (ImageView) itemView.findViewById(R.id.design_img);
            tvName = (TextView) itemView.findViewById(R.id.tvDrugName);
            tvDisease = (TextView) itemView.findViewById(R.id.tvDiseases);

        }
    }
}
