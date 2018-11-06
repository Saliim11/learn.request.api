package com.saliim.learnrequestapi.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class BeritaItem implements Parcelable {

	@SerializedName("penulis")
	private String penulis;

	@SerializedName("foto")
	private String foto;

	@SerializedName("id")
	private String id;

	@SerializedName("judul_berita")
	private String judulBerita;

	@SerializedName("tanggal_posting")
	private String tanggalPosting;

	@SerializedName("isi_berita")
	private String isiBerita;

	public void setPenulis(String penulis){
		this.penulis = penulis;
	}

	public String getPenulis(){
		return penulis;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setJudulBerita(String judulBerita){
		this.judulBerita = judulBerita;
	}

	public String getJudulBerita(){
		return judulBerita;
	}

	public void setTanggalPosting(String tanggalPosting){
		this.tanggalPosting = tanggalPosting;
	}

	public String getTanggalPosting(){
		return tanggalPosting;
	}

	public void setIsiBerita(String isiBerita){
		this.isiBerita = isiBerita;
	}

	public String getIsiBerita(){
		return isiBerita;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.penulis);
		dest.writeString(this.foto);
		dest.writeString(this.id);
		dest.writeString(this.judulBerita);
		dest.writeString(this.tanggalPosting);
		dest.writeString(this.isiBerita);
	}

	public BeritaItem() {
	}

	protected BeritaItem(Parcel in) {
		this.penulis = in.readString();
		this.foto = in.readString();
		this.id = in.readString();
		this.judulBerita = in.readString();
		this.tanggalPosting = in.readString();
		this.isiBerita = in.readString();
	}

	public static final Parcelable.Creator<BeritaItem> CREATOR = new Parcelable.Creator<BeritaItem>() {
		@Override
		public BeritaItem createFromParcel(Parcel source) {
			return new BeritaItem(source);
		}

		@Override
		public BeritaItem[] newArray(int size) {
			return new BeritaItem[size];
		}
	};
}