package com.example.indraarianggi.biodatasqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodata extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText edtText1, edtText2, edtText3, edtText4, edtText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);

        dbHelper = new DataHelper(this);
        edtText1 = (EditText)findViewById(R.id.editText1);
        edtText2 = (EditText)findViewById(R.id.editText2);
        edtText3 = (EditText)findViewById(R.id.editText3);
        edtText4 = (EditText)findViewById(R.id.editText4);
        edtText5 = (EditText)findViewById(R.id.editText5);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount()>0) {
            cursor.moveToPosition(0);
            edtText1.setText(cursor.getString(0).toString());
            edtText2.setText(cursor.getString(1).toString());
            edtText3.setText(cursor.getString(2).toString());
            edtText4.setText(cursor.getString(3).toString());
            edtText5.setText(cursor.getString(4).toString());
        }

        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE biodata SET nama='" +
                        edtText2.getText().toString()+ "', tgl='" +
                        edtText3.getText().toString()+ "', jk='" +
                        edtText4.getText().toString()+ "', alamat='" +
                        edtText5.getText().toString()+ "' WHERE no='" +
                        edtText1.getText().toString()+ "'");

                Toast.makeText(getApplicationContext(), "Berhasil Update Data", Toast.LENGTH_LONG).show();
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
