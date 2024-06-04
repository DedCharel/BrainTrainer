package ru.nvgsoft.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    private static final String EXTRAS_RESULT = "result";
    private static final String PREFERENCES_MAX = "max";
    private TextView texViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        initViews();
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(EXTRAS_RESULT)){
            int result = intent.getIntExtra(EXTRAS_RESULT, 0);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            int max = preferences.getInt(PREFERENCES_MAX, 0);
            String score = String.format("Ваш результат %s\nМаксимальный результат %s", result, max);
            texViewResult.setText(score);
        }

    }

    private void initViews(){
        texViewResult = findViewById(R.id.texViewResult);
    }

    public void onClickStartNewGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}