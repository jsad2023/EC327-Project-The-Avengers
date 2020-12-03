package com.example.game0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.WindowManager;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;
    // 2 variables to track the time the user has been playing
    // elaspedTime -- elasped time in seconds
    public long elaspedTime;
    private long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        gameView = new GameView(this, point.x, point.y);

        setContentView(gameView);

        // initialize time values
        elaspedTime = 0;
        startTime = System.currentTimeMillis();
        /*
        if (isGameOver) {

            // Increment elaspedTime one fil
            elaspedTime += (System.currentTimeMillis() - startTime) / 1000;
            startActivity(new Intent(GameActivity.this, GameOver.class));

        }
        */
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
        // increment elapse time
        elaspedTime += (System.currentTimeMillis() - startTime) / 1000;

    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
        startTime = System.currentTimeMillis();
    }

    protected void LaunchGameOver() {
            // increment elasped time for game over screen
            elaspedTime += (System.currentTimeMillis() - startTime) / 1000;
            Intent gameOverIntent = new Intent(GameActivity.this, GameOver.class);
            startActivity(gameOverIntent);
    }

}