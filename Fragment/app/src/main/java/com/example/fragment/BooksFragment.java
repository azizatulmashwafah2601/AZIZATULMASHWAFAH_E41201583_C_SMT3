package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BooksFragment extends Fragment implements AdapterView.OnItemClickListener {

    public BooksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_books, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Menambahkan item list book yang ingin dimasukkan dalam listview
        String[] listbook = {"Tentang Kamu", "Maripossa", "Ayah", "Pulang",
                "Laut Bercerita", "Hujan", "Rindu", "Laskar Pelangi"};
        //Untuk memanggil listView
        ListView listViewBook = (ListView) view.findViewById(R.id.listView);
        //Untuk membuat layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listbook);

        listViewBook.setAdapter(adapter);
        listViewBook.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Untuk membuat toast yang akan ditampilkan pada saat item di klik
        if (position == 0) return;
        Toast.makeText(getActivity(), "Anda memilih buku " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
    }
}