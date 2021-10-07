package com.example.recyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.BookViewHolder>{
    private final ArrayList<Book> arrayListBook;

    public BookRecyclerViewAdapter(ArrayList<Book> arrayListBook) {
        this.arrayListBook = arrayListBook;
    }

//    Menampilkan layout
    @NonNull
    @Override
    public BookRecyclerViewAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new BookViewHolder(view);
    }

//    Mengambil data dari setiap item
    @Override
    public void onBindViewHolder(@NonNull  BookRecyclerViewAdapter.BookViewHolder holder, int position) {
        final Book book = arrayListBook.get(position);

        holder.textViewTitle.setText(book.getTitle());
        holder.textViewTahun.setText(book.getTahun());
        holder.textViewPenulis.setText(book.getPenulis());

//        Menambahkan aksi klik
        holder.itemView.setOnClickListener(view ->  {
//            Berpindah ke DetailBookActivity
                Intent intent = new Intent(holder.itemView.getContext(), DetailBookActivity.class);
//                Menyimpan data didalam memori terlebih dahulu kemudian diterima oleh DetailBookActivity
                intent.putExtra(DetailBookActivity.EXTRA_BOOK, book);
//                Mengirimkan data
                holder.itemView.getContext().startActivity(intent);
        });
    }

//    Menentukan urutan item
    @Override
    public int getItemCount() { return arrayListBook.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
//        Menambahkan property
        TextView textViewTitle, textViewTahun, textViewPenulis;
//        Membuat konstruktor class ViewHolder
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.tvTitle);
            textViewTahun = itemView.findViewById(R.id.tvTahun);
            textViewPenulis = itemView.findViewById(R.id.tvPenulis);
        }
    }
}
