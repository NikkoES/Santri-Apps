package com.nikkoes.santriapps.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nikkoes.santriapps.R;
import com.nikkoes.santriapps.model.Santri;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailSantriActivity extends AppCompatActivity {

    @BindView(R.id.image_santri)
    ImageView imageSantri;
    @BindView(R.id.txt_nama_santri)
    TextView txtNamaSantri;
    @BindView(R.id.txt_jenis_kelamin)
    TextView txtJenisKelamin;
    @BindView(R.id.txt_tanggal_lahir)
    TextView txtTanggalLahir;
    @BindView(R.id.txt_alamat)
    TextView txtAlamat;

    Santri santri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_santri);
        ButterKnife.bind(this);

        santri = (Santri) getIntent().getSerializableExtra("santri");

        initToolbar();
        initUI();
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.detail_profil_santri));
        getSupportActionBar().setSubtitle(santri.getNama());
    }

    private void initUI() {
        Glide.with(this).load(santri.getImage()).into(imageSantri);
        txtNamaSantri.setText(santri.getNama());
        txtJenisKelamin.setText(santri.getJenisKelamin());
        txtTanggalLahir.setText(santri.getTanggalLahir());
        txtAlamat.setText(santri.getAlamat());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
