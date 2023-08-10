package com.example.memegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.memegenerator.databinding.ActivityShowMemeBinding;
import com.squareup.picasso.Picasso;

public class ShowMemeActivity extends AppCompatActivity {
    private ActivityShowMemeBinding binding;

    static final String MEME_URL= "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowMemeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String imageUrl = getIntent().getStringExtra(MEME_URL);
        showImageUrl(imageUrl);
    }

    private void showImageUrl(String imageUrl) {
        Picasso.get().load(imageUrl).into(binding.memeImg);
    }
}