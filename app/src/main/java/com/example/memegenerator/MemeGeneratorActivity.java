package com.example.memegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.memegenerator.databinding.ActivityMemeGeneratorBinding;
import com.squareup.picasso.Picasso;

public class MemeGeneratorActivity extends AppCompatActivity {

    private ActivityMemeGeneratorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMemeGeneratorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleGenerateMemeBtn();
    }

    private void handleGenerateMemeBtn() {
        binding.memeGenerateBtn.setOnClickListener(v -> {
           String memeUrl = generateMemeUrl(getTemplate(), getTopText(), getBottomText());
           showImage(memeUrl);
        });
    }

    private String getTemplate() {
        return binding.templateNameTxt.getText().toString();
    }

    private String getTopText() {
        return binding.topTxt.getText().toString();
    }

    private String getBottomText() {
        return binding.bottomTxt.getText().toString();
    }

    private String generateMemeUrl(String templateText, String topText, String bottomText) {
        return "https://apimeme.com/meme?meme="+templateText+"&top="+topText+"&bottom="+bottomText;
    }

    private void showImage(String imageUrl) {
        Picasso.get().load(imageUrl).into(binding.memeImg);
    }
}