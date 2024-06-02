package ru.nvgsoft.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView textViewTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTimer =findViewById(R.id.textViewTimer);
        CountDownTimer timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                int seconds = (int)(l / 1000);
                textViewTimer.setText(Integer.toString(seconds));
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Таймер завершен", Toast.LENGTH_SHORT).show();
            }
        };
        timer.start();
    }
}