package com.example.game0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.WindowManager;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;
    public boolean isGameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        gameView = new GameView(this, point.x, point.y);

        setContentView(gameView);

        if (isGameOver) {
            startActivity(new Intent(GameActivity.this, GameOver.class));

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();

    }
/*
    protected void onGameOver() {
        if (isGameOver) {
            Intent gameOverIntent = new Intent(this, GameOver.class);
            startActivity(gameOverIntent);
        }
    }
 */
}