package com.nikkoes.santriapps.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.nikkoes.santriapps.R;
import com.nikkoes.santriapps.adapter.SantriAdapter;
import com.nikkoes.santriapps.model.Santri;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_santri)
    RecyclerView rvSantri;

    private SantriAdapter mAdapter;

    List<Santri> listSantri = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initSantriData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        rvSantri.setHasFixedSize(true);
        rvSantri.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SantriAdapter(this, listSantri);
        rvSantri.setAdapter(mAdapter);
    }

    private void initSantriData() {
        listSantri.add(new Santri("Nikko Eka Saputra", "Laki-laki", "Cibiru, Bandung", "Jakarta, 04 Oktober 1997", "https://scontent-sin6-2.cdninstagram.com/vp/09b790ebdc0e1f97be971e1537fb5662/5C744191/t51.2885-19/s150x150/44421097_373333243484836_8361092429457129472_n.jpg"));
        listSantri.add(new Santri("Raka Sulthonuddin", "Laki-laki", "Cibiru, Bandung", "Bekasi, 26 Juli 1997", "https://scontent-sin6-2.cdninstagram.com/vp/dad6badfcf4324a9277511ae0aa02f0d/5C67761E/t51.2885-19/s150x150/24254333_335581140184175_7038474598026838016_n.jpg"));
        listSantri.add(new Santri("Ardi Saeful Milah", "Laki-laki", "Cibiru, Bandung", "Cimahi, 04 April 1997", "https://scontent-sin6-2.cdninstagram.com/vp/a4133abb4664c7bacf75555d7ff2e3be/5C6E11C5/t51.2885-19/s150x150/36803861_556063951463701_3259678202531938304_n.jpg"));
        listSantri.add(new Santri("Lili Sholihah", "Perempuan", "Cibiru, Bandung", "Cirebon, 27 Juli 1998", "https://scontent-sin6-2.cdninstagram.com/vp/b7a90e0753580aa13aad065959cc62a8/5C8A20F3/t51.2885-19/s150x150/27573746_324525141372341_1605691652666556416_n.jpg"));
        listSantri.add(new Santri("Sri Lestari", "Perempuan", "Cibiru, Bandung", "Purwakarta, 13 Mei 1997", "https://scontent-sin6-2.cdninstagram.com/vp/66bd34995c62030a535e7080767b085e/5C82BA18/t51.2885-19/s150x150/31386528_1712756468811927_8609628833823326208_n.jpg"));
        listSantri.add(new Santri("Firman Wahyu", "Laki-laki", "Cibiru, Bandung", "Bekasi, 17 Agustus 1996", "https://scontent-sin6-2.cdninstagram.com/vp/40e5a5237af1379ba95ff763ee04e689/5C89B984/t51.2885-19/s150x150/14478556_1827294494155505_3223085734005047296_a.jpg"));
        listSantri.add(new Santri("Laila Afifah", "Perempuan", "Cibiru, Bandung", "Tangerang, 24 September 1997", "https://scontent-sin6-2.cdninstagram.com/vp/1ceae81662b9ebdc26845cc78d13e7d0/5C7DABF8/t51.2885-19/s150x150/28752781_2002324226697683_7443881182481088512_n.jpg"));
        listSantri.add(new Santri("M. Japar Sidiq", "Laki-laki", "Cibiru, Bandung", "Tasikmalaya, 08 Maret 1996", "https://scontent-sin6-2.cdninstagram.com/vp/a344d78307e9851c2e17652311470735/5C881A7D/t51.2885-19/s150x150/42653033_303986247061017_6109189394822856704_n.jpg"));
        listSantri.add(new Santri("Manarul Huda", "Laki-laki", "Cibiru, Bandung", "Purwakarta, 06 Desember 1997", "https://scontent-sin6-2.cdninstagram.com/vp/fb1be289854421051ce3bb4c3b00c32e/5C78D7CC/t51.2885-19/s150x150/22636941_315094295635569_5973984146467323904_n.jpg"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_profile:
                Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(i);
                break;
            case R.id.nav_bahasa:
                Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(intent);
                break;
        }
        return true;
    }
}