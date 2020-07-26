package com.jayakim.wisatabelanja;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView,map;
    TextView texttitle,textdesc;

    String goolgeMap = "com.google.android.apps.maps";
    Uri gmmIntentUri;
    Intent mapIntent;
    String malioboro = "-6.894649906672214,110.63718136399984"; // koordinat Masjid Agung Demak
    /*Deklarasi variable*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView=findViewById(R.id.image_detail);
        texttitle=findViewById(R.id.title_detail);
        textdesc=findViewById(R.id.descdtview);
        map=findViewById(R.id.maps);

        imageView.setImageResource(getIntent().getIntExtra("image",0));
        texttitle.setText(getIntent().getStringExtra("title"));
        textdesc.setText(getIntent().getStringExtra("deskripsi"));

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Buat Uri dari intent string. Gunakan hasilnya untuk membuat Intent.
                gmmIntentUri = Uri.parse("google.navigation:q=" + malioboro);

                // Buat Uri dari intent gmmIntentUri. Set action => ACTION_VIEW
                mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Set package Google Maps untuk tujuan aplikasi yang di Intent yaitu google maps
                mapIntent.setPackage(goolgeMap);

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(DetailActivity.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                            Toast.LENGTH_LONG).show();
                }
            }

        });

    }
}
