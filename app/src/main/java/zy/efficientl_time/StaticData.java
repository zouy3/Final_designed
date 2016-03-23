package zy.efficientl_time;

import android.content.Context;
import android.util.DisplayMetrics;

import zy.efficientl_time.ui.Fragment2;
import zy.efficientl_time.ui.Fragment3;
import zy.efficientl_time.ui.TimeCountdown;

/**
 * Created by zouyun on 16/3/21.
 */
public class StaticData {
    public Context mContext;

    public static int sHeight;

    public static int sWidth;

    public static float time = 70;

    public static long startTime;

    public static TimeCountdown tc;

    public static Fragment3 f3;

    public void getScreenData() {
        DisplayMetrics metrics = new DisplayMetrics();

    }

    public StaticData(Context context) {
        mContext = context;
    }

}
