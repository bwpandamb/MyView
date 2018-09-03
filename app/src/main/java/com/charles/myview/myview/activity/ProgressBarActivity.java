package com.charles.myview.myview.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.charles.myview.myview.R;
import com.charles.myview.myview.widgets.ColorfulProgressBar;
import com.charles.myview.myview.widgets.OyoLoadingDialog;

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        setTitle("圆形进度条");

        Button btn_normal = findViewById(R.id.btn_normal);
        Button btn_change_color = findViewById(R.id.btn_change_color);
        Button btn_through_drawable = findViewById(R.id.btn_through_drawable);
        Button btn_others = findViewById(R.id.btn_others);

        btn_normal.setOnClickListener(this);
        btn_change_color.setOnClickListener(this);
        btn_through_drawable.setOnClickListener(this);
        btn_others.setOnClickListener(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        OyoLoadingDialog oyoLoadingDialog = OyoLoadingDialog.with(this)
                .setMessage("正在加载")
                .setCanceledOnTO(false);

        switch (v.getId()) {
            case R.id.btn_normal:
                oyoLoadingDialog.show();
                break;

            case R.id.btn_change_color:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    OyoLoadingDialog.with(this).setProgressColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                oyoLoadingDialog.show();

                break;
            case R.id.btn_through_drawable:
                oyoLoadingDialog.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_cycle_color));
                oyoLoadingDialog.show();
                break;
            case R.id.btn_others:

                break;
        }
    }
}
