package zy.efficientl_time.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

import zy.efficientl_time.R;

/**
 * Created by zouyun on 16/3/22.
 */
public class MyImageView extends ImageButton {

    public MyImageView(Context context) {
        super(context);
        setBackgroundResource(R.drawable.video);
    }

    public MyImageView(Context context, AttributeSet attr) {
        super(context, attr);
    }


}
