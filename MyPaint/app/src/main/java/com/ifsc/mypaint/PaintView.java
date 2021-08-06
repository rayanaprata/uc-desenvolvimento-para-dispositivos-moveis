package com.ifsc.mypaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;

public class PaintView extends View {

    private Paint mPaint;
    private List<Point> mListPoints;
    private Path mPath;
    private HashMap<Integer, Path> control;

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint( );
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(20);
        mPath = new Path();
        control = new HashMap<Integer, Path>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        control.forEach((Integer color, Path path) -> {
            mPaint.setColor(color);
            canvas.drawPath(path, mPaint);
        });
        postInvalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();
        switch (event.getAction()) {
            case (MotionEvent.ACTION_DOWN):
                mPath.moveTo(pointX, pointY);
                break;
            case (MotionEvent.ACTION_MOVE):
                mPath.lineTo(pointX, pointY);
                break;
            default:
                return false;
        }
        postInvalidate();
        return true;
    }

}
