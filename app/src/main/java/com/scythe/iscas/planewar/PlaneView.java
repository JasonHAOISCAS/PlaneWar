package com.scythe.iscas.planewar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by iscas on 2017/4/19.
 */

public class PlaneView extends View {
    public float currentX;
    public float currentY;
    Paint p = new Paint();
    public PlaneView(Context context)
    {
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        p.setColor(Color.RED);
        canvas.drawCircle(currentX,currentY,15,p);
    }
}
