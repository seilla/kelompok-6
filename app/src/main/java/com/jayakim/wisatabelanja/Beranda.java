package com.jayakim.wisatabelanja;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Beranda extends AppCompatActivity {
    TextView lihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        MyListAdapter adapter=new MyListAdapter(setdataList());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        lihat=findViewById(R.id.textView4);

        lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Beranda.this,rekomendasi.class);
                startActivity(intent);
            }
        });
    }
    public DataList[] setdataList(){
        DataList[] myListData=new DataList[]{
                new DataList(R.drawable.bringharjo,getString(R.string.beringharjo),getString(R.string.psr),getString(R.string.beringharjodesc)),
                new DataList(R.drawable.gabusan,getString(R.string.gabusan),getString(R.string.psr),getString(R.string.gabusandesc)),
                new DataList(R.drawable.hartono,getString(R.string.hartono),getString(R.string.sm),getString(R.string.hartonodesc)),
                new DataList(R.drawable.ngasem,getString(R.string.ngasem),getString(R.string.psr),getString(R.string.ngasemdesc)),
                new DataList(R.drawable.pasty,getString(R.string.pasty),getString(R.string.psr),getString(R.string.pastydetail)),
                new DataList(R.drawable.malioboro,getString(R.string.malio),getString(R.string.jlndiyk),getString(R.string.maliodesc)),
        };
        return myListData;
    }
}
