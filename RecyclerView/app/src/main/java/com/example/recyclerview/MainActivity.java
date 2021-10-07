package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

//        Memasukkan data berdasarakan objek yang telah dibuat
        ArrayList<Book> objBook = new ArrayList<>();
        objBook.add(new Book("Tentang Kamu", "Manga, Fiksi Fantasi", "Tere Liye", "Republika",
                "Menceritakan perjuangan Zaman, seorang pengacara muda dari Thompson & Co, untuk mengurus warisan Sri Ningsih", "2016"));
        objBook.add(new Book("Maripossa", "Fiski, Romantis, Komedi", "Luluk HF", "Coconut Books",
                "Menceritakan seorang Natasha Loovi yang berusaha mendekati seorang pria yang bernama Iqbal", "2018"));
        objBook.add(new Book("Ayah", "Fiksi Sastra", "Andrea Hirata", "Bentang Pustaka",
                "Menceritakan tentang perjuangan serta persaan ayah kepada anaknya, tanpa mengenal ikatan darah sekalipun", "2015"));

        BookRecyclerViewAdapter adapter = new BookRecyclerViewAdapter(objBook);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}