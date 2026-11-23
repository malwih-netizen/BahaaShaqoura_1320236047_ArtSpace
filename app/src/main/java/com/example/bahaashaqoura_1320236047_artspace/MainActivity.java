package com.example.bahaashaqoura_1320236047_artspace;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.art1, R.drawable.art2, R.drawable.art3,
                    R.drawable.art4, R.drawable.art5, R.drawable.art6};

    String[] titles = {"The Starry Night", "Mona Lisa", "The Scream",
                       "Girl with a Pearl Earring", "The Great Wave off Kanagawa", "Water Lilies"};

    String[] artists = {"Vincent van Gogh", "Leonardo da Vinci", "Edvard Munch",
                        "Johannes Vermeer", "Katsushika Hokusai", "Claude Monet"};

    String[] years = {"1889", "1503", "1893", "1665", "1831", "1906"};

    int index = 0;

    TextView tvCounter, tvTitle, tvArtist;
    ImageView imgArt;
    Button btnPrev, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        tvTitle   = findViewById(R.id.tvTitle);
        tvArtist  = findViewById(R.id.tvArtist);
        imgArt    = findViewById(R.id.imgArt);
        btnPrev   = findViewById(R.id.btnPrev);
        btnNext   = findViewById(R.id.btnNext);

        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("index", 0);
        }

        btnNext.setOnClickListener(v -> {
            index++;
            updateUI();
        });

        btnPrev.setOnClickListener(v -> {
            index--;
            updateUI();
        });

        imgArt.setOnClickListener(v -> {
            Intent intent = new Intent(this, ArtworkDetailsActivity.class);
            intent.putExtra("title", titles[index]);
            intent.putExtra("artist", artists[index]);
            intent.putExtra("year", years[index]);
            startActivity(intent);
        });

        updateUI();
    }

    private void updateUI() {
        imgArt.setImageResource(images[index]);
        tvTitle.setText(titles[index]);
        tvArtist.setText(artists[index] + "  (" + years[index] + ")");
        tvCounter.setText((index + 1) + " / " + images.length);

        btnPrev.setEnabled(index > 0);
        btnNext.setEnabled(index < images.length - 1);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", index);
    }
}
