package zy.efficientl_time.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Calendar;

import zy.efficientl_time.R;
import zy.efficientl_time.StaticData;

/**
 * Created by zouyun on 16/3/22.
 */

public class MyImageView extends ImageButton {

    private TimeCountdown tc;

    public MyImageView(final Context context) {
        super(context);
        setBackgroundResource(R.drawable.video);
        tc = (TimeCountdown)StaticData.f3.getActivity().findViewById(R.id.CountDown);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                StaticData.startTime = Calendar.getInstance().getTimeInMillis();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (Calendar.getInstance().getTimeInMillis() - StaticData.startTime < StaticData.time * 3000) {
                            tc.postInvalidate();
                            try {
                                Thread.sleep(100);
                            } catch (Exception e) {

                            }
                        }
                    }
                }).start();
            }
        });
    }

    public MyImageView(Context context, AttributeSet attr) {
        super(context, attr);
        setBackgroundResource(R.drawable.video);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                StaticData.startTime = Calendar.getInstance().getTimeInMillis();
                StaticData.tc = (TimeCountdown)StaticData.f3.getActivity().findViewById(R.id.CountDown);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while ((Calendar.getInstance().getTimeInMillis() - StaticData.startTime)/1000 <= StaticData.time) {
                            Log.i("refresh", "timecount");
                            StaticData.tc.postInvalidate();
                            try {
                                Thread.sleep(100);
                            } catch (Exception e) {

                            }
                        }
                    }
                }).start();
            }
        });
    }




}
