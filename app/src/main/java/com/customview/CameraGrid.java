package com.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 照相机井字线
 * Created by sky on 2015/7/7.
 */
public class CameraGrid extends View {

    private int topBannerWidth = 0;
    private Paint mPaint;

    public CameraGrid(Context context) {
        this(context,null);
    }

    public CameraGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setAlpha(120);
        mPaint.setStrokeWidth(1f);
    }


    //画一个井字,上下画两条灰边，中间为正方形
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = this.getWidth();
        int height = this.getHeight();
        if (width < height) {
            topBannerWidth = height - width;
        }
        if (showGrid) {
            //画竖线
            canvas.drawLine(width / 3, 0, width / 3, height, mPaint);
            canvas.drawLine(width / 3 * 2, 0, width / 3 * 2, height, mPaint);

            //画横线，方格
            canvas.drawLine(0, width / 3, width, width / 3, mPaint);
            canvas.drawLine(0, width / 3 * 2, width, width / 3 * 2, mPaint);
            canvas.drawLine(0, width, width, width, mPaint);
            canvas.drawLine(0, width / 3 * 4, width, width / 3 * 4, mPaint);
            canvas.drawLine(0, width / 3 * 5, width, width / 3 * 5, mPaint);
            canvas.drawLine(0, width / 3 * 6, width, width / 3 * 6, mPaint);
        }
    }

    private boolean showGrid = true;

    public boolean isShowGrid() {
        return showGrid;
    }

    public void setShowGrid(boolean showGrid) {
        this.showGrid = showGrid;
    }

    public int getTopWidth() {
        return topBannerWidth;
    }
}
