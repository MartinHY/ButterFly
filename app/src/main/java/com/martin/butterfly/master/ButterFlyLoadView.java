package com.martin.butterfly.master;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.martin.butterfly.R;

/**
 * 作者：MartinBZDQSM on 2016/9/2 0002.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
public class ButterFlyLoadView extends ImageView {

    private ButterFlyDrawable flyDrawable;

    // 预览框矩形,蝴蝶矩形
    private Rect box, framBox, flyBox, textBox;

    private int height, width, framBoxW, framBoxH;

    private Paint framBoxPaint, flyBoxPaint, loadTextPaint;

    private String loadingStr = "Loading...";

    private int figureId;

    public ButterFlyLoadView(Context context) {
        this(context, null);
    }

    public ButterFlyLoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getSrcFromAttrs(context, attrs);
    }

    private Bitmap loadBitmap(int resId) {
        return BitmapFactory.decodeResource(getResources(), resId);
    }

    private void getSrcFromAttrs(Context context, AttributeSet attrs) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ButterFlyLoadView);
        try {
            if (a != null) {
                figureId = a.getResourceId(R.styleable.ButterFlyLoadView_figure, 0);
            }
        } finally {
            if (a != null) {
                a.recycle();
            }
            viewInit();
            invalidate();
        }
    }

    private void viewInit() {

        flyDrawable = new ButterFlyDrawable();
        if (figureId != 0)
            flyDrawable.setFigure(loadBitmap(figureId));

        height = Util.getScreenHeight(getContext()) - Util.getStatusBarHeight(getContext());// 去掉通知栏的高度
        width = Util.getScreenWidth(getContext());
        box = new Rect(0, 0, width, height);
        framBoxW = width * 3 / 5;
        framBoxH = framBoxW * 4 / 5;
        framBox = new Rect(box.centerX() - framBoxW / 2, box.centerY() - framBoxH / 2, box.centerX() + framBoxW / 2,
                box.centerY() + framBoxH / 2);

        flyBox = new Rect(framBox);
        flyBox.left += framBoxW / 5;
        flyBox.top += 0;
        flyBox.right = flyBox.left + framBoxW * 3 / 5;
        flyBox.bottom = flyBox.top + framBoxW * 3 / 5;
        flyDrawable.setBounds(flyBox);

        textBox = new Rect(framBox);
        textBox.top = flyBox.bottom;

        framBoxPaint = new Paint();
        framBoxPaint.setAntiAlias(true);
        framBoxPaint.setFilterBitmap(true);
        framBoxPaint.setDither(true);
        framBoxPaint.setColor(Color.WHITE);
        framBoxPaint.setAlpha(175);
        framBoxPaint.setStyle(Paint.Style.FILL);

        flyBoxPaint = new Paint();
        flyBoxPaint.setAntiAlias(true);
        flyBoxPaint.setFilterBitmap(true);
        flyBoxPaint.setDither(true);
        flyBoxPaint.setColor(Color.RED);
        flyBoxPaint.setAlpha(255);
        flyBoxPaint.setStyle(Paint.Style.FILL);

        loadTextPaint = new Paint();
        loadTextPaint.setAntiAlias(true);
        loadTextPaint.setColor(Color.WHITE);
        loadTextPaint.setTextSize(Util.dpToPx(getContext(), 15));
        loadTextPaint.setTextAlign(Paint.Align.CENTER);


        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator arg0) {
                flyDrawable.caculatMatrixs((Float) arg0.getAnimatedValue());
                invalidate();
            }
        });

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(new RectF(framBox), 30, 30, framBoxPaint);

        int sc = canvas.saveLayer(framBox.left, framBox.top, framBox.right, framBox.bottom, null,
                Canvas.MATRIX_SAVE_FLAG | Canvas.CLIP_SAVE_FLAG | Canvas.HAS_ALPHA_LAYER_SAVE_FLAG
                        | Canvas.FULL_COLOR_LAYER_SAVE_FLAG | Canvas.CLIP_TO_LAYER_SAVE_FLAG);
        flyDrawable.draw(canvas);
        canvas.drawText(loadingStr, textBox.centerX(), textBox.centerY(), loadTextPaint);
        canvas.restoreToCount(sc);

    }

    private ValueAnimator valueAnimator = ValueAnimator.ofFloat(-1f, 1f);

    private int flyActionTime = 400;

    // 开始飞舞动画
    public void startFly() {
        flyDrawable.setBounds(flyBox);
        valueAnimator.setDuration(flyActionTime);
        valueAnimator.setCurrentPlayTime(flyActionTime / 2);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
    }

    // 停止飞舞动画
    public void stopFly() {
        valueAnimator.cancel();
        flyDrawable.caculatMatrixs(0);
        invalidate();
    }

    interface OnFlyProcessListener {

    }

    /**
     * 加载
     */
    public void loadFinished() {

    }

    /**
     * 设置蝴蝶飞舞时间
     *
     * @param aCTION_TIME
     */
    public void setACTION_TIME(int aCTION_TIME) {
        if (aCTION_TIME >= 300) {// 300为极限速度,不再增加了
            float timeScale = aCTION_TIME / this.flyActionTime;
            flyActionTime = aCTION_TIME;
            valueAnimator.cancel();
            valueAnimator.setDuration(flyActionTime);
            valueAnimator.setCurrentPlayTime((long) (timeScale * valueAnimator.getCurrentPlayTime()));
            valueAnimator.setRepeatCount(-1);
            valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
            valueAnimator.start();
        }
    }

    public int getACTION_TIME() {
        return flyActionTime;
    }

    /**
     * 设置加载语句
     *
     * @param loadingStr
     */
    public void setLoadingStr(String loadingStr) {
        this.loadingStr = loadingStr;
        textBox = new Rect(framBox);
        textBox.top = flyBox.bottom;
    }


}
