package com.jalen.scrolldemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author Dragon
 * @date 2017/4/21. 11:24
 * @editor
 * @date
 * @describe
 */
public class LayoutView extends View {

    private int lastX, lastY;

    public LayoutView(Context context) {
        super(context);
    }

    public LayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //滑动的时候 getLeft getTop getRight getBottom 的值和初始值一样 不会改变
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                break;
            case MotionEvent.ACTION_UP:
                //手指抬起的时候 getLeft getTop getRight getBottom 的值改变
                break;

        }
        return true;
    }
}
