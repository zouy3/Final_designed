package zy.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

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

    private Paint totalPaint;

    private Paint progress;

    private Paint time;


    public TimeCountdown(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init() {
        
    }

    @Override
    public void onDraw(Canvas canvas) {

    }

}
