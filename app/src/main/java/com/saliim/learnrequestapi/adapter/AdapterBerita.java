package com.saliim.learnrequestapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.saliim.learnrequestapi.model.BeritaItem;
import com.saliim.learnrequestapi.network.ConfigRetrofit;
import com.saliim.learnrequestapi.detail.DetailBerita;
import com.saliim.learnrequestapi.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.ViewHolder> {

    //TODO : deklarasi
    private Context ctx;
    private List<BeritaItem> dataBerita;

    public AdapterBerita(Context ctx, List<BeritaItem> dataBerita) {
        this.ctx = ctx;
        this.dataBerita = dataBerita;
    }

    //TODO create funtion / method constructor

    //TODO : menyisipkan sebuah layout kedalam adapter dan recylerview
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_berita, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //TODO : eksekusi data yg mau ditampilkan
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        //TODO : tampung data nya ke variabel
        final String judul = dataBerita.get(i).getJudulBerita();
        final String images = ConfigRetrofit.IMAGES + dataBerita.get(i).getFoto();
        final String posting = dataBerita.get(i).getTanggalPosting();
        final String penulis = dataBerita.get(i).getPenulis();
        final String content = dataBerita.get(i).getIsiBerita();

        viewHolder.tvJudulBerita.setText(judul);
        viewHolder.tvPenulis.setText(penulis);
        viewHolder.tvTglTerbit.setText(posting);

        Glide.with(ctx)
                .load(images)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.ivGambarBerita);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kirim = new Intent(ctx, DetailBerita.class);
//
                //TODO : buat object dari class yg mau kita kirim
                BeritaItem data = new BeritaItem();
                data.setJudulBerita(judul);
                data.setFoto(images);
                data.setPenulis(penulis);
                data.setTanggalPosting(posting);
                data.setIsiBerita(content);

                //TODO : intent data nya
                kirim.putExtra(DetailBerita.EXTRA_OBJECT, data);

                ctx.startActivity(kirim);
            }
        });

    }

    //TODO : return data yang ingin ditampilkan / proses looping
    @Override
    public int getItemCount() {
        return dataBerita.size();
    }

    //TODO : deklarasi widget atau component nya
    static public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_gambar_berita)
        ImageView ivGambarBerita;
        @BindView(R.id.tv_judul_berita)
        TextView tvJudulBerita;
        @BindView(R.id.tv_tgl_terbit)
        TextView tvTglTerbit;
        @BindView(R.id.tv_penulis)
        TextView tvPenulis;

        //TODO : casting view / hub dgn id nya masing"
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            }
        }
    }
