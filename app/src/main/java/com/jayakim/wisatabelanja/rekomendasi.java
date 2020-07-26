package com.jayakim.wisatabelanja;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class rekomendasi extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        MyListAdapter adapter=new MyListAdapter(setdataList());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    public DataList[] setdataList(){
        DataList[] myListData=new DataList[]{
                new DataList(R.drawable.malioboro,getString(R.string.malio),getString(R.string.jlndiyk),getString(R.string.maliodesc)),
                new DataList(R.drawable.hartono,getString(R.string.hartono),getString(R.string.sm),getString(R.string.maliodesc)),
                new DataList(R.drawable.bringharjo,getString(R.string.beringharjo),getString(R.string.psr),getString(R.string.maliodesc)),
        };
        return myListData;
    }
}
