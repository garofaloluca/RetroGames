package com.nullpointerexception.retrogames.Breakout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.nullpointerexception.retrogames.R;

public class Paddle
{
    private RectF rect;
    private int x, y,length, height, paddleSpeed;

    // Which ways can the paddle move
    public final int STOPPED = 0;
    public final int LEFT = 1;
    public final int RIGHT = 2;

    private Bitmap bitmap;

    private int paddleMoving = STOPPED;

    public Paddle(int screenX, int screenY, int speed)
    {
        this.length = screenX / 4;
        this.height = 30;

        this.x = (screenX / 2) - (length / 2);
        this.y = screenY - (screenY / 16);

        this.rect = new RectF(this.x, this.y, this.x + this.length, this.y + this.height);

        this.paddleSpeed = speed;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public RectF getRect(){
        return this.rect;
    }

    // This method will be used to change/set if the paddle is going left, right or nowhere
    public void setMovementState(int state){
        this.paddleMoving = state;
    }

    //  Aggiorna le coordinate durante movimento
    public void update(int w)
    {
        if(this.paddleMoving == this.LEFT && this.x > 0)
        {
            this.x -= this.paddleSpeed;
        }

        if(this.paddleMoving == this.RIGHT && this.x + this.length < w)
        {
            this.x += this.paddleSpeed;
        }

        this.rect.left = this.x;
        this.rect.right = this.x + this.length;
    }

    //  Aggiorna le coordinate durante movimento
    public void update(int w, float delay)
    {
        if(this.paddleMoving == this.LEFT && this.x > 0)
        {
            this.x -= this.paddleSpeed * delay;
        }

        if(this.paddleMoving == this.RIGHT && this.x + this.length < w)
        {
            this.x += this.paddleSpeed * delay;
        }

        this.rect.left = this.x;
        this.rect.right = this.x + this.length;
    }

    public void createPaddleDrawable(Context context)
    {
        bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                context.getResources(), R.drawable.paddle), (int) rect.width(), (int) rect.height(), false);
        bitmap.setConfig(Bitmap.Config.ARGB_8888);
    }

    public void draw(Canvas c)
    {
        c.drawBitmap(bitmap, rect.left, rect.top, new Paint());
    }

}
