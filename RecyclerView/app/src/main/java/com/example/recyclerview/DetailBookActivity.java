package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailBookActivity extends AppCompatActivity {

    public static final  String EXTRA_BOOK = "extra_book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

//        Mendeklarasikan objek yang akan menampilkan isi dari data yang sudah diisikan
        TextView textViewTitle = findViewById(R.id.tvTitle);
        TextView textViewTahun = findViewById(R.id.tvTahun);
        TextView textViewPenulis = findViewById(R.id.tvPenulis);
        TextView textViewGenre = findViewById(R.id.tvGenre);
        TextView textViewPenerbit = findViewById(R.id.tvPenerbit);
        TextView textViewDeskripsi = findViewById(R.id.tv_Deskripsi);

//        Memasukkan dan mengambil data yang diinputkan
        Book book = getIntent().getParcelableExtra(EXTRA_BOOK);
        textViewTitle.setText(book.getTitle());
        textViewTahun.setText(book.getTahun());
        textViewPenulis.setText(book.getPenulis());
        textViewGenre.setText(book.getGenre());
        textViewPenerbit.setText(book.getPenerbit());
        textViewDeskripsi.setText(book.getDeskripsi());
    }
}