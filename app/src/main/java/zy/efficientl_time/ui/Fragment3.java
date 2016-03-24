package zy.efficientl_time.ui;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.percent.PercentRelativeLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

import zy.efficientl_time.R;
import zy.efficientl_time.StaticData;

/**
 * Created by zouyun on 16/3/21.
 */
public class Fragment3 extends Fragment {

    private View view;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                    Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_main2, container, false);
        StaticData.sb = (MyImageView)view.findViewById(R.id.startButton);
        StaticData.tc = (TimeCountdown)view.findViewById(R.id.CountDown);
        StaticData.f3_pl = (PercentRelativeLayout)view.findViewById(R.id.f3_pl);
        StaticData.eb = (MyImageView)view.findViewById(R.id.endButton);
        StaticData.sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StaticData.running = true;
                StaticData.startTime = Calendar.getInstance().getTimeInMillis();
                StaticData.f3_pl.setBackgroundColor(Color.RED);
                StaticData.tc.setVisibility(View.VISIBLE);
                StaticData.eb.setVisibility(View.VISIBLE);
                StaticData.sb.setVisibility(View.INVISIBLE);
                //           StaticData.tc = (TimeCountdown)StaticData.f3.getActivity().findViewById(R.id.CountDown);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while ((Calendar.getInstance().getTimeInMillis() - StaticData.startTime)/1000 <= StaticData.time && StaticData.running) {
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
        StaticData.eb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StaticData.running = false;
                StaticData.eb.setVisibility(View.INVISIBLE);
                StaticData.tc.setVisibility(View.INVISIBLE);
                StaticData.sb.setVisibility(View.VISIBLE);
                StaticData.f3_pl.setBackgroundColor(Color.BLUE);
            }
        });
        return view;
    }
}
