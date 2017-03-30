package com.zmm.viewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tv_content_header_name)
    TextView mTvContentHeaderName;
    @InjectView(R.id.ll_content_control)
    LinearLayout mLlContentControl;
    @InjectView(R.id.tv_content_header_title)
    TextView mTvContentHeaderTitle;

    private String name = "不笑猫";
    private boolean isScale = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initView();
    }

    private void initView() {
        mTvContentHeaderName.setText("姓名:" + name);
    }

    @OnClick(R.id.iv_content_header_scale)
    public void onClick() {
        if(isScale){
            mLlContentControl.setVisibility(View.GONE);
            mTvContentHeaderTitle.setTextSize(40);
            isScale = false;
        }else {
            mLlContentControl.setVisibility(View.VISIBLE);
            mTvContentHeaderTitle.setTextSize(30);
            isScale = true;
        }
    }
}
