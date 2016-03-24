package zy.efficientl_time;

import android.content.Context;
import android.support.percent.PercentRelativeLayout;
import android.util.DisplayMetrics;

import zy.efficientl_time.ui.Fragment2;
import zy.efficientl_time.ui.Fragment3;
import zy.efficientl_time.ui.MyImageView;
import zy.efficientl_time.ui.TimeCountdown;

/**
 * Created by zouyun on 16/3/21.
 */
public class StaticData {
    public Context mContext;

    public static int sHeight;

    public static int sWidth;

    public static long time = 70;

    public static long startTime;

    public static TimeCountdown tc;

    public static MyImageView sb;

    public static Fragment3 f3;

    public static PercentRelativeLayout f3_pl;

    public static MyImageView eb;

    public static boolean running = false;

    public StaticData(Context context) {
        mContext = context;
    }

}
