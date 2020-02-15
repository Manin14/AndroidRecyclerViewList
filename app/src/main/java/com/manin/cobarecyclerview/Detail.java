package com.manin.cobarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Detail extends AppCompatActivity {
    AppCompatImageView iv=null;
    AppCompatTextView nama,detail=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        deklarasi();
    }

    private void deklarasi() {
       Intent intent = getIntent();
       // Toast.makeText(this,intent.getStringExtra("nama"), Toast.LENGTH_LONG).show();

        iv=findViewById(R.id.id_image);
        nama=findViewById(R.id.id_tv_nama);
        detail=findViewById(R.id.id_tV_detail);



        //cara ambil gambar yaitu pake glide
        Glide.with(this)
                .load(intent.getIntExtra("gambar",0))
                .apply(new RequestOptions().override(100,100))
                .into(iv);
        //cara ambil tex nama
        nama.setText(intent.getStringExtra("nama"));
         //cara ambil tex detail
        detail.setText(intent.getStringExtra("detail"));


    }


}
