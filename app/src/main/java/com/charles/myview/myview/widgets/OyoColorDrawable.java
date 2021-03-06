package com.charles.myview.myview.widgets;


import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;

public class OyoColorDrawable extends Drawable {
    private Paint mPaint;
    private int color;
    private RectF rectF;

    public OyoColorDrawable() {
        mPaint = new Paint();
        // 是否抗锯齿
        mPaint.setAntiAlias(true);
    }

    public OyoColorDrawable(int color) {
        this.color = color;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public void setColor(@ColorInt int color) {
        this.color = color;
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        rectF = new RectF(left, top, right, bottom);
    }

    @Override
    public void draw(Canvas canvas) {
        mPaint.setColor(color);
        canvas.drawRoundRect(rectF, 10, 10, mPaint); // 改变2，3的值会导致背景的圆角改变
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
