package com.zmm.viewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tv_content_header_name)
    TextView mTvContentHeaderName;

    private String name = "不笑猫";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initView();
    }

    private void initView() {
        mTvContentHeaderName.setText("姓名:"+name);
    }
}
