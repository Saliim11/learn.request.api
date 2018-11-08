package com.saliim.learnrequestapi.detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.saliim.learnrequestapi.R;
import com.saliim.learnrequestapi.model.BeritaItem;
import com.saliim.learnrequestapi.network.ConfigRetrofit;

public class DetailBerita extends AppCompatActivity {
    TextView dJudul, dPenulis, dTgl, dIsi;
    ImageView dGambar;

    //TODO : buat variabel secara konstan sebagai key nya / penampung
    public final String EXTRA_OBJECT = getString(R.string.object);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        dJudul = findViewById(R.id.detail_judul);
        dGambar = findViewById(R.id.detail_gambar);
        dIsi = findViewById(R.id.detail_isi);
        dPenulis = findViewById(R.id.detail_penulis);
        dTgl = findViewById(R.id.detail_tgl);

        //TODO : cara get dgn parcelabel
        BeritaItem get = getIntent().getParcelableExtra(EXTRA_OBJECT);
        dJudul.setText(get.getJudulBerita());
        dIsi.setText(get.getIsiBerita());
        dPenulis.setText(get.getPenulis());
        dTgl.setText(get.getTanggalPosting());

        Glide.with(DetailBerita.this)
                .load(get.getFoto())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(dGambar);
    }
}
