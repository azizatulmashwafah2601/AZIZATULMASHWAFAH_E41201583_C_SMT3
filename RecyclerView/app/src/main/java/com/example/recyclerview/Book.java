package com.example.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

//    Membuat private variable
    private String title;
    private String genre;
    private String penulis;
    private String penerbit;
    private String deskripsi;
    private String tahun;

//    Menambahkan adapter
    public Book(String title, String genre, String penulis, String penerbit, String deskripsi, String tahun) {
        this.title = title;
        this.genre = genre;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.deskripsi = deskripsi;
        this.tahun = tahun;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.genre);
        dest.writeString(this.penulis);
        dest.writeString(this.penerbit);
        dest.writeString(this.deskripsi);
        dest.writeString(this.tahun);
    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        this.genre = source.readString();
        this.penulis = source.readString();
        this.penerbit = source.readString();
        this.deskripsi = source.readString();
        this.tahun = source.readString();
    }

    protected Book(Parcel in) {
        this.title = in.readString();
        this.genre = in.readString();
        this.penulis = in.readString();
        this.penerbit = in.readString();
        this.deskripsi = in.readString();
        this.tahun = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
