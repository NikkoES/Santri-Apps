package com.nikkoes.santriapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nikkoes.santriapps.R;
import com.nikkoes.santriapps.activity.DetailSantriActivity;
import com.nikkoes.santriapps.model.Santri;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SantriAdapter extends RecyclerView.Adapter<SantriAdapter.ViewHolder> {

    private Context context;
    private List<Santri> listSantri;

    public SantriAdapter(Context context, List<Santri> listSantri) {
        this.context = context;
        this.listSantri = listSantri;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_santri, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Santri santri = listSantri.get(position);
        Glide.with(context).load(santri.getImage()).into(holder.imageSantri);
        holder.txtNamaSantri.setText(santri.getNama());
        holder.txtJenisKelamin.setText(santri.getJenisKelamin());
        holder.cvSantri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailSantriActivity.class);
                i.putExtra("santri", santri);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSantri.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_santri)
        ImageView imageSantri;
        @BindView(R.id.txt_nama_santri)
        TextView txtNamaSantri;
        @BindView(R.id.txt_jenis_kelamin)
        TextView txtJenisKelamin;
        @BindView(R.id.cv_santri)
        CardView cvSantri;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
