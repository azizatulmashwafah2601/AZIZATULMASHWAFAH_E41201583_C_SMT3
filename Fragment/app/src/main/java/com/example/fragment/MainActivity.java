package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    //Menginisialisasi BottomNavigationView
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Untuk menampilkan list view pada BooksFragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BooksFragment()).commit();
        }

        //Untuk memanggil id dari activity_main.xml yaitu bottom_navigation
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Untuk menampilkan menampilkan HomeFragment pada saat aplikasi terbuka secara default
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Untuk membuat objek Fragment bernilai null
                Fragment selectedFragment = null;

                //Untuk mengambil data item pada file bottom_navigation.xml
                switch (item.getItemId()) {
                    //jika memilih nav_home maka akan muncul HomeFragment
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    //jika memilih nav_book maka akan muncul BooksFragment
                    case R.id.nav_books:
                        selectedFragment = new BooksFragment();
                        break;
                    //jika memilih nav_account maka akan muncul AccountFragment
                    case R.id.nav_account:
                        selectedFragment = new AccountFragment();
                        break;
                }

                //Untuk menampilkan fragment yang dipilih sesuai dengan button yang tersedia
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }
}