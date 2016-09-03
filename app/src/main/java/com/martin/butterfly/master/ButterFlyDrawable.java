package com.martin.butterfly.master;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;


/**
 * 作者：MartinBZDQSM on 2016/9/2 0002.
 * 博客：http://www.jianshu.com/users/78f0e5f4a403/latest_articles
 * github：https://github.com/MartinBZDQSM
 */
public class ButterFlyDrawable extends Drawable {

    private ButterFly butterFly;

    private Path path;
    // 矩阵对象管理
    private final static int MATRIXS_NUMBER = 3;

    private Matrix[] Matrixs = new Matrix[MATRIXS_NUMBER];// 3个矩阵

    private RectF[] RectFs = new RectF[MATRIXS_NUMBER];

    private final static int POINTS_NUMBER = 8;// 顶点坐标数量(顶点数double倍)

    private float[] srcPoly, dstPoly;

    private Paint paint;
    private RectF lRect, cRect, rRect;

    private Rect fRect, bounds;

    private float scaleL, scaleC, cMaxScale, cRScale;// 基本坐标比例

    private float wingX, wingY, bodyX, bodyY;// 基础移动距离

    private ValueAnimator valueAnimator = ValueAnimator.ofFloat(-1f, 1f);

    private int ACTION_TIME = 200;

    private int width = 0;

    private Bitmap figure;

    public ButterFlyDrawable() {
        butterFly=new ButterFly();
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(Color.BLACK);
        paint.setAlpha(255);
        paint.setStyle(Paint.Style.FILL);

        lRect = new RectF();
        cRect = new RectF();
        rRect = new RectF();

        // 基本坐标比例计算
        scaleL = 6 * 1.0f / 12.8f;
        scaleC = 0.9f * 1.0f / 12.8f;

        for (int i = 0; i < MATRIXS_NUMBER; i++) {
            Matrixs[i] = new Matrix();
            RectFs[i] = new RectF();
        }
        srcPoly = new float[POINTS_NUMBER];
        dstPoly = new float[POINTS_NUMBER];
    }

    // 设置花纹图片
    public void setFigure(Bitmap bitmap) {
        figure = GraphicsUtil.getPathBitmap(bitmap, butterFly);
    }

    // public void set

    @Override
    public void draw(Canvas canvas) {
        if (bounds != null) {

            fRect = new Rect(getBounds());
            fRect.top += wingY;
            fRect.left += wingY;
            fRect.bottom -= wingY;
            fRect.right -= wingY;
            canvas.translate(wingY * cRScale / 5, wingY * cRScale / 3);
            for (int i = 0; i < MATRIXS_NUMBER; i++) {
                canvas.save();
                // 控制显示的大小
                canvas.clipRect(RectFs[i]);
                canvas.concat(Matrixs[i]);
                if (figure != null) {
                    canvas.drawBitmap(figure, null, fRect, paint);
                } else {
                    canvas.drawPath(path, paint);
                }
                canvas.restore();
            }

            // canvas.restore();
        }
    }

    // 矩形绘制区域计算,以及折叠速率
    private void caculatRect() {

        if (width == 0 || width != getBounds().width()) {// 非必要不需要重新计算3块矩形

            width = getBounds().width();// 总宽度

            lRect.set(0, 0, scaleL * width, width);

            cRect.set(scaleL * width, 0, (scaleL + scaleC) * width, width);

            rRect.set((scaleL + scaleC) * width, 0, width, width);

            lRect.set(0, 0, scaleL * width, width);
            lRect.offset(bounds.left, bounds.top);

            cRect.set(scaleL * width, 0, (scaleL + scaleC) * width, width);
            cRect.offset(bounds.left, bounds.top);

            rRect.set((scaleL + scaleC) * width, 0, width, width);
            rRect.offset(bounds.left, bounds.top);
            Log.i("hyn", "width宽度是多少caculatRect" + width);

            // 由45'度角过度
            wingX = scaleL * width / 2;
            wingY = wingX / 2;

            bodyX = scaleC * width / 2;
            bodyY = bodyX / 2;

            cMaxScale = 1 - ((width - bodyX * 3) / (width - bodyX));
            butterFly.butterFlyPathInit(bounds);
            path = butterFly.p;

        }
    }

    protected void caculatMatrixs(float value) {

        float wingSpeedX;
        float wingSpeedY;
        wingSpeedX = wingX * Math.abs(value);
        wingSpeedY = wingY * Math.abs(value);
        cRScale = 1 + cMaxScale * value;
        float bodySpeedX = bodyX * value * 0;
        float bodySpeedY = bodyY * value * 0;

        // 左翅膀
        srcPoly[0] = lRect.left;
        srcPoly[1] = lRect.top;

        srcPoly[2] = lRect.right;
        srcPoly[3] = lRect.top;

        srcPoly[4] = lRect.right;
        srcPoly[5] = lRect.bottom;

        srcPoly[6] = lRect.left;
        srcPoly[7] = lRect.bottom;

        dstPoly[0] = srcPoly[0] + wingSpeedX;
        dstPoly[1] = srcPoly[1] - wingSpeedY;

        dstPoly[2] = srcPoly[2] - bodySpeedX;
        dstPoly[3] = srcPoly[3] - bodySpeedY;

        dstPoly[4] = srcPoly[4] - bodySpeedX;
        dstPoly[5] = srcPoly[5] + bodySpeedY;

        dstPoly[6] = srcPoly[6] + wingSpeedX;
        dstPoly[7] = srcPoly[7] + wingSpeedY;

        RectFs[0] = new RectF(dstPoly[0] - wingX, -wingY, dstPoly[4], width + wingY);
        RectFs[0].offset(0, bounds.top);
        Matrixs[0].reset();
        Matrixs[0].setPolyToPoly(srcPoly, 0, dstPoly, 0, POINTS_NUMBER / 2);

        // 右翅膀
        srcPoly[0] = rRect.left;
        srcPoly[1] = rRect.top;

        srcPoly[2] = rRect.right;
        srcPoly[3] = rRect.top;

        srcPoly[4] = rRect.right;
        srcPoly[5] = rRect.bottom;

        srcPoly[6] = rRect.left;
        srcPoly[7] = rRect.bottom;

        dstPoly[0] = srcPoly[0] + bodySpeedX;
        dstPoly[1] = srcPoly[1] - bodySpeedY;

        dstPoly[2] = srcPoly[2] - wingSpeedX;
        dstPoly[3] = srcPoly[3] - wingSpeedY;

        dstPoly[4] = srcPoly[4] - wingSpeedX;
        dstPoly[5] = srcPoly[5] + wingSpeedY;

        dstPoly[6] = srcPoly[6] + bodySpeedX;
        dstPoly[7] = srcPoly[7] + bodySpeedY;

        RectFs[1] = new RectF(dstPoly[0], -wingY, dstPoly[4], width + wingY);
        RectFs[1].offset(0, bounds.top);
        Matrixs[1].reset();
        Matrixs[1].setPolyToPoly(srcPoly, 0, dstPoly, 0, POINTS_NUMBER / 2);

        // 中间
        srcPoly[0] = cRect.left;
        srcPoly[1] = cRect.top;

        srcPoly[2] = cRect.right;
        srcPoly[3] = cRect.top;

        srcPoly[4] = cRect.right;
        srcPoly[5] = cRect.bottom;

        srcPoly[6] = cRect.left;
        srcPoly[7] = cRect.bottom;

        dstPoly[0] = srcPoly[0] - bodySpeedX;
        dstPoly[1] = srcPoly[1] - bodySpeedY;

        dstPoly[2] = srcPoly[2] + bodySpeedX;
        dstPoly[3] = srcPoly[3] - bodySpeedY;

        dstPoly[4] = srcPoly[4] + bodySpeedX;
        dstPoly[5] = srcPoly[5] + bodySpeedY;

        dstPoly[6] = srcPoly[6] - bodySpeedX;
        dstPoly[7] = srcPoly[7] + bodySpeedY;

        RectFs[2] = new RectF(dstPoly[0], dstPoly[1], dstPoly[4], dstPoly[5]);
        // RectFs[2].offset(0, bounds.top);
        Matrixs[2].reset();
        Matrixs[2].setRectToRect(cRect, RectFs[2], ScaleToFit.FILL);

        invalidateSelf();

    }

    // 开始飞舞动画
    public void startFly() {
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator arg0) {

                caculatMatrixs((Float) arg0.getAnimatedValue());

            }
        });
        valueAnimator.setDuration(ACTION_TIME);
        valueAnimator.setCurrentPlayTime(ACTION_TIME / 2);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
    }

    // 停止飞舞动画
    public void stopFly() {
        valueAnimator.cancel();
        caculatMatrixs(0);
    }

    @Override
    public void setBounds(Rect bounds) {
        this.bounds = bounds;
        super.setBounds(bounds);

    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        caculatRect();
        caculatMatrixs(0);
    }

    public void setColor(int color) {
        paint.setColor(color);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }

    @Override
    public int getMinimumHeight() {
        return 10;
    }

    @Override
    public int getMinimumWidth() {
        return 10;
    }
}
