package com.scythe.iscas.planewar.planewar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.scythe.iscas.planewar.R;

/**
 * Created by iscas on 2017/4/19.
 */

public class MainActivity extends Activity {
    private int speed = 10;
    private RelativeLayout gameFrame;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.backgroup);
        LinearLayout backgroup = (LinearLayout)findViewById(R.id.background);
        gameFrame = new RelativeLayout(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        backgroup.addView(gameFrame,params);
        //添加view
        final PlaneView planeView = new PlaneView(this);
        planeView.setBackgroundColor(Color.BLUE);
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        planeView.currentX = metrics.widthPixels / 2;
        planeView.currentY = metrics.heightPixels - 40;
        RelativeLayout.LayoutParams paramsPlaneView = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        //paramsPlaneView.addRule(RelativeLayout.BELOW);
        gameFrame.addView(planeView,paramsPlaneView);

        //添加button
        Button left = new Button(this);
        left.setText("左边");
        RelativeLayout.LayoutParams paramsLeft = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramsLeft.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        paramsLeft.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        gameFrame.addView(left,paramsLeft);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                planeView.currentX = planeView.currentX - speed;
                planeView.invalidate();
            }
        });

        //添加button
        Button right = new Button(this);
        right.setText("右边");
        RelativeLayout.LayoutParams paramsRight = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramsRight.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        paramsRight.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        gameFrame.addView(right,paramsRight);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                planeView.currentX = planeView.currentX + speed;
                planeView.invalidate();
            }
        });
    }
}
