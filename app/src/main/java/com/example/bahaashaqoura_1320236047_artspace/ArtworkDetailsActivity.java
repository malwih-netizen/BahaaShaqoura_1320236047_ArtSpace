package com.example.bahaashaqoura_1320236047_artspace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtworkDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork_details);

        TextView tvTitle  = findViewById(R.id.tvDetailTitle);
        TextView tvArtist = findViewById(R.id.tvDetailArtist);
        TextView tvYear   = findViewById(R.id.tvDetailYear);
        Button btnVisit   = findViewById(R.id.btnVisit);
        Button btnBack    = findViewById(R.id.btnBack);

        String title  = getIntent().getStringExtra("title");
        String artist = getIntent().getStringExtra("artist");
        String year   = getIntent().getStringExtra("year");

        tvTitle.setText(title);
        tvArtist.setText("Artist: " + artist);
        tvYear.setText("Year: " + year);

        btnVisit.setOnClickListener(v -> {
            Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wikiart.org"));
            startActivity(browser);
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
