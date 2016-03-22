package zy.efficientl_time.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

import zy.efficientl_time.StaticData;

/**
 * Created by zouyun on 16/3/21.
 */
public class TimeCountdown extends View {

    private float cx;

    private float cy;

    private float radius;

    private float totalTime;

    private float passTime;

    private float width;

    private float angel;

    private long startTime;

    private int totalColor;

    private int progressColor;

    private Paint totalPaint;

    private Paint progress;

    private Paint time;


    public TimeCountdown(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void init() {

        radius = StaticData.sWidth / 3;
        width = StaticData.sWidth / 50;
        totalTime = StaticData.time;
        startTime = Calendar.getInstance().getTimeInMillis();
        passTime = 0;
        progressColor = Color.argb(250, 230, 145, 56);
        totalColor = Color.argb(250, 224, 238, 224);


        totalPaint = new Paint();
        totalPaint.setAntiAlias(true);
        totalPaint.setColor(totalColor);
        totalPaint.setStrokeWidth(width);
        totalPaint.setStyle(Paint.Style.STROKE);

        progress = new Paint();
        progress.setAntiAlias(true);
        progress.setColor(progressColor);
        progress.setStrokeWidth(width);
        progress.setStyle(Paint.Style.STROKE);
     //   progress.setStrokeWidth(width);
    }

    @Override
    public void onDraw(Canvas canvas) {
        cx = getWidth() / 2;
        cy = getHeight() / 3;
        canvas.drawCircle(cx, cy, radius, totalPaint);

        passTime = (Calendar.getInstance().getTimeInMillis() - startTime) / 1000;

        if (passTime < totalTime) {
            angel = passTime / totalTime * 360;
            RectF oval = new RectF();
            oval.left = cx - radius;
            oval.top = cy - radius;
            oval.right = cx + radius;
            oval.bottom = cy + radius;
            canvas.drawArc(oval, -90, angel, false, progress);
            passTime = (int) ((Calendar.getInstance().getTimeInMillis() - startTime) / 1000);
        }
    }

}
