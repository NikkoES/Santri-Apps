package com.nikkoes.santriapps.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nikkoes.santriapps.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.image_mahasiswa)
    ImageView imageMahasiswa;
    @BindView(R.id.txt_nama)
    TextView txtNama;
    @BindView(R.id.txt_nim)
    TextView txtNim;
    @BindView(R.id.txt_tanggal_lahir)
    TextView txtTanggalLahir;
    @BindView(R.id.txt_alamat)
    TextView txtAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_santri);
        ButterKnife.bind(this);

        initToolbar();
        initUI();
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.detail_profil_mahasiswa));
    }

    private void initUI() {
        Glide.with(this)
                .load("https://scontent-sin6-2.cdninstagram.com/vp/09b790ebdc0e1f97be971e1537fb5662/5C744191/t51.2885-19/s150x150/44421097_373333243484836_8361092429457129472_n.jpg")
                .into(imageMahasiswa);
        txtNama.setText("Nikko Eka Saputra");
        txtNim.setText("1157050115");
        txtTanggalLahir.setText("Jakarta, 04 Oktober 1997");
        txtAlamat.setText("Pondok Pesantren Mahasiswa Universal, Cipadung, Cibiru, Bandung");
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
