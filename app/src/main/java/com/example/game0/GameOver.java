package com.example.game0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameOver extends AppCompatActivity {

    private Button StartGameAgain;
    private static int screenX = 1080, screenY = 2220;
    private Context context;

    public GameOver(Context context) {
        this.context = context;
    }

    public static void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(128);
        paint.setColor(Color.WHITE);

        //canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
        //canvas.drawBitmap(background2.background, background2.x, background2.y, paint);
        canvas.drawText("Game Over!", screenX / 2, screenY / 2, paint);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);


        StartGameAgain = (Button) findViewById(R.id.play_again);
        StartGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameOver.this, GameActivity.class));
            }
        });

    }



}