package com.example.jiangzehui.waterview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by jiangzehui on 17/7/13.
 */

public class WaterView extends View {

    private ArrayList<String> width_list;
    private ArrayList<String> alpha_list;
    private Paint paint;
    private boolean isStart = false;

    public WaterView(Context context) {
        super(context);
        init();
    }

    public WaterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    void init() {
        width_list = new ArrayList<>();
        alpha_list = new ArrayList<>();
        width_list.add("0");
        alpha_list.add("255");
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        paint.setColor(Color.RED);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isStart) {
            setBackgroundColor(Color.TRANSPARENT);
            for (int i = 0; i < width_list.size(); i++) {

                int width = Integer.parseInt(width_list.get(i));
                int alpha = Integer.parseInt(alpha_list.get(i));
                paint.setAlpha(alpha);//先设置透明度，在画圆
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, width, paint);

                if (alpha > 0 && width < getWidth()) {
                    width_list.set(i, width + 1 + "");
                    alpha_list.set(i, alpha - 1 + "");
                }
            }
            if (Integer.parseInt(width_list.get(width_list.size() - 1)) > getWidth() / 10) {//如果大于自定义的5分之一宽度，则添加一个同心圆
                width_list.add("0");
                alpha_list.add("255");
            }

            if (width_list.size() > 8) {
                width_list.remove(0);
                alpha_list.remove(0);
            }
            invalidate();
        }

    }

    public boolean isStart() {
        return isStart;
    }

    public void start() {
        if (!isStart) {
            isStart = true;
            invalidate();
        }
    }

    public void stop() {
        if (isStart) {
            isStart = false;
        }

    }
}
