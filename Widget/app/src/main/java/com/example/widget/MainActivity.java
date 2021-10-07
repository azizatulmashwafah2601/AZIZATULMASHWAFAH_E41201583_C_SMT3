package com.example.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.widget.fragmen.DatePickerFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener, DatePickerDialog.OnDateSetListener{

//    Membuuat array list yang berisikan data untuk autocomplete
    private static final String[] CITY = new String[]{
            "Ambon", "Aceh", "Bandung", "Banten", "Bogor", "Bondowoso", "Cirebon", "Cikarang", "Jember",
            "Probolinggo", "Nganjuk"
    };

    private EditText edtBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *  Date Picker * */
        edtBirthday = findViewById(R.id.edt_birthday);

        ImageButton btnBirthday = findViewById(R.id.btn_birthday);
        btnBirthday.setOnClickListener(this);

        /**
         *  AutoComplete * */
        AutoCompleteTextView editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CITY);
        editText.setAdapter(adapterr);

        /**
         *  Spinner * */
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            Untuk menampilkan spinner yang dipilih
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String drpgender = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

//    Untuk menampilkan kalender atau date picker
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        final Calendar choosenDate = Calendar.getInstance();
        choosenDate.set(year, month, dayOfMonth);

        @SuppressLint("SimpleDateFormat")
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        final Date date = choosenDate.getTime();
        final String strDate = simpleDateFormat.format(date);

        edtBirthday.setText(strDate);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_birthday) {
            DatePickerFragment datePickerFragment = new DatePickerFragment();
            datePickerFragment.show(getSupportFragmentManager(), datePickerFragment.getClass().getSimpleName());
        }
    }
}