package zy.myapplication;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by zouyun on 16/3/21.
 */
public class StaticData {
    public Context mContext;

    public static float sHeight;

    public static float sWidth;

    public void getScreenData() {
        DisplayMetrics metrics = new DisplayMetrics();

    }

    public StaticData(Context context) {
        mContext = context;
    }

}
