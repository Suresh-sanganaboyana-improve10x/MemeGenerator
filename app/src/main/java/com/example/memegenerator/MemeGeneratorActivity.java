package com.example.memegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.memegenerator.databinding.ActivityMemeGeneratorBinding;
import com.squareup.picasso.Picasso;

public class MemeGeneratorActivity extends AppCompatActivity {

    private ActivityMemeGeneratorBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMemeGeneratorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupSpinner();
        handleGenerateMemeBtn();
    }

    private void setupSpinner() {
        String [] templateNames = getResources().getStringArray(R.array.templates);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, templateNames);
        binding.memeSp.setAdapter(adapter);
    }

    private void handleGenerateMemeBtn() {
        binding.memeGenerateBtn.setOnClickListener(v -> {
           String memeUrl = generateMemeUrl(getTemplate(), getTopText(), getBottomText());
            Intent intent = new Intent(this, ShowMemeActivity.class);
            intent.putExtra(ShowMemeActivity.MEME_URL, memeUrl);
            startActivity(intent);
        });
    }

    private String getTemplate() {
        return binding.memeSp.getSelectedItem().toString();
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
}