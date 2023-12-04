package com.example.pr27_glazirinng;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Draw2D extends View {

    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mBitmap;

    public Draw2D(Context context) {
        super(context);
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.planeoff);

        // Уменьшение размера фотографии
        int newWidth = 1000;
        int newHeight = 1000;
        mBitmap = Bitmap.createScaledBitmap(mBitmap, newWidth, newHeight, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        mPaint.setStyle(Paint.Style.FILL);

        mPaint.setColor(Color.BLACK);
        canvas.drawPaint(mPaint);

        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(width - 100, 100, 120, mPaint);
        //  canvas.drawCircle(width / 2, height / 2, 120, mPaint);

        mPaint.setColor(Color.parseColor("#006400"));
        canvas.drawRect(0, height - 100, width, height, mPaint);

        int bitmapX = (width - mBitmap.getWidth()) / 2;
        int bitmapY = (height - mBitmap.getHeight()) / 2;
        canvas.drawBitmap(mBitmap, bitmapX, bitmapY, mPaint);
      }
}