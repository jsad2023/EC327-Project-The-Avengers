package com.example.game0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.Button;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class GameOverTxt {

    public static Bitmap gameovertxt;
    private Button StartGameAgain;
    private static int screenX = 1080, screenY = 2220;
    private Context context;

    GameOverTxt (Context context, int screenY, Resources res)
    {
        gameovertxt = BitmapFactory.decodeResource(res, R.layout.activity_game_over);
    }

    static Bitmap getGameovertxt()
    {
        return gameovertxt;
    }

    /*public static void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(128);
        paint.setColor(Color.WHITE);

        //canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
        //canvas.drawBitmap(background2.background, background2.x, background2.y, paint);
        //canvas.drawText("Game Over!", screenX / 2, screenY / 2, paint);
    } */
}
