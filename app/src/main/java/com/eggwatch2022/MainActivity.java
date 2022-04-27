package com.eggwatch2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageButton;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    // Initializing
    private TextView textViewCountDown;
    private Button buttonStartStop;
    private ImageButton imSoft;
    private ImageButton imMedium;
    private ImageButton imHard;

    private CountDownTimer countDownTimer;
    private long timeStart;
    private boolean timerRun;
    private long timeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting view that is identified by the android:id
        imSoft = findViewById(R.id.softBoiledButton);
        imMedium = findViewById(R.id.mediumBoiledButton);
        imHard = findViewById(R.id.hardBoiledButton);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        buttonStartStop = findViewById(R.id.button_start_stop);

        // Perform click event using lambda on image button
        imSoft.setOnClickListener(v -> {
            if (true) {

                // Set specific time for timer, display start status and enable start button
                timeStart = 300000;
                textViewCountDown.setText("05:00");
                buttonStartStop.setVisibility(View.VISIBLE);
            }
        });

        // perform click event using lambda on image button
        imMedium.setOnClickListener(v -> {
            if (true) {

                // Set specific time for timer, display start status and enable start button
                timeStart = 450000;
                textViewCountDown.setText("07:50");
                buttonStartStop.setVisibility(View.VISIBLE);
            }
        });

        // Perform click event using lambda on image button
        imHard.setOnClickListener(v -> {
            if (true) {

                // Set specific time for timer, display start status and enable start button
                timeStart = 600000;
                textViewCountDown.setText("10:00");
                buttonStartStop.setVisibility(View.VISIBLE);
            }
        });

        // Perform click event using lambda on button
        buttonStartStop.setOnClickListener(v -> {
            if (timerRun) {

                stopTimer();

            } else {

                timeLeft = timeStart;
                startTimer();
            }
        });

        updateCountDownText();
    }

    // Method for starting timer
    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long timeUntilFinished) {
                timeLeft = timeUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRun = false;

                // Display finish status and disable start button
                buttonStartStop.setText("Start");
                buttonStartStop.setVisibility(View.INVISIBLE);
                textViewCountDown.setText("Egg boiled");

            }
        }.start();

        timerRun = true;
        buttonStartStop.setText("Stop");
    }

    // Method for stopping timer
    private void stopTimer() {
        countDownTimer.cancel();
        timerRun = false;
        buttonStartStop.setText("Start");
    }

    // Method for display countdown status
    private void updateCountDownText() {

        // Used for formatting digit
        NumberFormat f = new DecimalFormat("00");

        int minute = (int) (timeLeft / 1000) / 60;
        int second = (int) (timeLeft / 1000) % 60;

        textViewCountDown.setText(f.format(minute) + ":" + f.format(second));
    }
}