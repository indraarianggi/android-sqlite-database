package com.example.indraarianggi.biodatasqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatBiodata extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText edtText1, edtText2, edtText3, edtText4, edtText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dbHelper = new DataHelper(this);
        edtText1 = (EditText)findViewById(R.id.editText1);
        edtText2 = (EditText)findViewById(R.id.editText2);
        edtText3 = (EditText)findViewById(R.id.editText3);
        edtText4 = (EditText)findViewById(R.id.editText4);
        edtText5 = (EditText)findViewById(R.id.editText5);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO biodata (no, nama, tgl, jk, alamat) VALUES ('" +
                            edtText1.getText().toString()+ "','" +
                            edtText2.getText().toString()+ "','" +
                            edtText3.getText().toString()+ "','" +
                            edtText4.getText().toString()+ "','" +
                            edtText5.getText().toString()+ "')");

                Toast.makeText(getApplicationContext(), "Berhasil Simpan Data", Toast.LENGTH_LONG).show();
                MainActivity.mainActivity.RefreshList();
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
