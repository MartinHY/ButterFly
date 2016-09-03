package com.martin.butterfly;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;

import com.martin.butterfly.master.ButterFlyLoadView;
import com.martin.butterfly.master.Util;

public class ButterFlyDialog extends Dialog {

    ButterFlyLoadView flyLoadView;

    public ButterFlyDialog(Context context) {
        super(context, R.style.ButterFlyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.butterfly_dialog);
        flyLoadView = (ButterFlyLoadView) this.findViewById(R.id.mbutterfly_view);
        setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
        getWindow().getAttributes().gravity = Gravity.CENTER;
        getWindow().getAttributes().width = Util.getScreenWidth(getContext());
        getWindow().getAttributes().height = Util.getScreenHeight(getContext());
    }

    public void setLoading(String title) {
        if (flyLoadView != null) {
            if (!TextUtils.isEmpty(title)) {
                flyLoadView.setLoadingStr(title);
            } else {
                flyLoadView.setLoadingStr("Loading...");
            }
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (flyLoadView != null)
            flyLoadView.stopFly();
    }

    @Override
    public void show() {
        super.show();
        if (flyLoadView != null)
            flyLoadView.startFly();
    }
}