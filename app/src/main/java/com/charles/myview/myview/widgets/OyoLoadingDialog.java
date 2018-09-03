package com.charles.myview.myview.widgets;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.charles.myview.myview.R;


/**
 * 自定义加载dialog
 */
public class OyoLoadingDialog extends Dialog {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private static OyoLoadingDialog dialog;
    private Context context;
    private TextView loadingMessage;
    private ColorfulProgressBar progressBar;
    private LinearLayout loadingView;
    private OyoColorDrawable drawable;

    public OyoLoadingDialog(Context context) {
        super(context, R.style.loading_dialog);
        this.context = context;
        drawable = new OyoColorDrawable();
        setContentView(R.layout.xloading_dialog);
        loadingMessage = (TextView) findViewById(R.id.xframe_loading_message);
        progressBar = (ColorfulProgressBar) findViewById(R.id.xframe_loading_progressbar);
        loadingView = (LinearLayout) findViewById(R.id.xframe_loading_view);
        loadingMessage.setPadding(15, 0, 0, 0);
        drawable.setColor(Color.WHITE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            loadingView.setBackground(drawable);
        } else {
            loadingView.setBackgroundDrawable(drawable);
        }
    }

    public static synchronized OyoLoadingDialog with(Context context) {
        if (dialog == null) {
            dialog = new OyoLoadingDialog(context);
        }
        return dialog;
    }

    public OyoLoadingDialog setOrientation(int orientation) {
        loadingView.setOrientation(orientation);
        if (orientation == HORIZONTAL) {
            loadingMessage.setPadding(15, 0, 0, 0);
        } else {
            loadingMessage.setPadding(0, 15, 0, 0);
        }
        return dialog;
    }

    //背景颜色，就是那一小块的颜色，默认是白色FFF
    public OyoLoadingDialog setBackgroundColor(@ColorInt int color) {
        drawable.setColor(color);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            loadingView.setBackground(drawable);
        } else {
            loadingView.setBackgroundDrawable(drawable);
        }
        return dialog;
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (dialog != null)
            dialog = null;
    }

    public OyoLoadingDialog setCanceledOnTO(boolean cancel) {
        setCanceledOnTouchOutside(cancel);
        return dialog;
    }

    public OyoLoadingDialog setCanceled(boolean cancel) {
        setCanceledOnTouchOutside(cancel);
        setCancelable(cancel);
        return dialog;
    }

    public OyoLoadingDialog setMessage(String message) {
        if (!(message == null || message.trim().length() == 0)) {
            loadingMessage.setText(message);
        } else {
            loadingMessage.setVisibility(View.GONE);
        }
        return this;
    }

    public OyoLoadingDialog setMessageColor(@ColorInt int color) {
        loadingMessage.setTextColor(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public OyoLoadingDialog setProgressColor(@ColorInt int color) {
        progressBar.setTintColor(color);
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public OyoLoadingDialog setProgressDrawable(Drawable drawable) {
        progressBar.setIndeterminateDrawable(drawable);
        return this;
    }
}
