package com.charles.myview.myview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.charles.myview.myview.activity.ProgressBarActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_progressbar = findViewById(R.id.btn_progressbar);

        btn_progressbar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_progressbar:
                startActivity(new Intent(this, ProgressBarActivity.class));
                break;
        }
    }
}
