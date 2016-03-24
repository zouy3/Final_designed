package zy.efficientl_time.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

import zy.efficientl_time.StaticData;

/**
 * Created by zouyun on 16/3/21.
 */
public class TimeCountdown extends View {

    private int cx;

    private int cy;

    private float radius;

    private long totalTime;

    private long passTime;

    private float width;

    private float angel;

    private int totalColor;

    private int progressColor;

    private Paint totalPaint;

    private Paint progress;

    private Paint time;

    private Rect rect;


    public TimeCountdown(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void init() {

        radius = StaticData.sWidth / 3;
        width = StaticData.sWidth / 50;
        totalTime = StaticData.time;
        passTime = 0;
        progressColor = Color.argb(250, 224, 238, 224);
        totalColor = Color.argb(150, 224, 238, 224);


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

        time = new Paint();
        time.setTextSize(200);
        time.setTypeface(Typeface.DEFAULT);
        time.setColor(Color.WHITE);
        time.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public void onDraw(Canvas canvas) {
        cx = getWidth() / 2;
        cy = getHeight() / 3;
        rect = new Rect(cx - StaticData.sWidth / 4 , cy - StaticData.sWidth / 8, cx + StaticData.sWidth / 4, cy + StaticData.sWidth / 8);
        Paint.FontMetrics fm = time.getFontMetrics();
        float baseLight = (rect.bottom + rect.top - fm.top - fm.bottom) / 2;
        canvas.drawCircle(cx, cy, radius, totalPaint);
        passTime = (Calendar.getInstance().getTimeInMillis() - StaticData.startTime) / 1000;
        if (passTime > totalTime) passTime = totalTime;
        int min = (int)(totalTime - passTime) / 60;
        int sec = (int)(totalTime - passTime) % 60;
        String t = "";
        if (min < 10) t += "0";
        t = t + min + " : ";
        if (sec < 10) t += "0";
        t += sec;
        canvas.drawText(t, rect.centerX(), baseLight, time);

        if (passTime <= totalTime) {
            Log.i("passTime", ""+passTime);
            angel = (float)(passTime * 1.0 / totalTime * 360);
            RectF oval = new RectF();
            oval.left = cx - radius;
            oval.top = cy - radius;
            oval.right = cx + radius;
            oval.bottom = cy + radius;
            canvas.drawArc(oval, -90 + angel, 360 - angel, false, progress);
        } else
            canvas.drawCircle(cx, cy, radius, progress);
        passTime = 0;
    }


}
