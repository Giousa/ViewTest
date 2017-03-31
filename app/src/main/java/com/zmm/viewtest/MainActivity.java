package com.zmm.viewtest;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
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
    private AlertDialog mAlertDialog;
    private boolean isCheckedOne = false;
    private boolean isCheckedTwo = false;
    private boolean isCheckedThree = false;


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

    @OnClick({R.id.iv_content_header_scale, R.id.iv_content_header_suggestion})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_content_header_scale:

                scaleView();

                break;
            case R.id.iv_content_header_suggestion:

                suggestion();

                break;
        }
    }


    private void suggestion() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        View viewDialog = View.inflate(this, R.layout.item_suggestion_dialog, null);
        TextView cancel = (TextView) viewDialog.findViewById(R.id.tv_content_dialog_cancel);
        TextView save = (TextView) viewDialog.findViewById(R.id.tv_content_dialog_save);
        EditText assess = (EditText) viewDialog.findViewById(R.id.et_content_dialog_assess);
        EditText suggestion = (EditText) viewDialog.findViewById(R.id.et_content_dialog_suggestion);
        final RadioButton radioButton01 = (RadioButton) viewDialog.findViewById(R.id.rb_content_dialog_01);
        final RadioButton radioButton02 = (RadioButton) viewDialog.findViewById(R.id.rb_content_dialog_02);
        final RadioButton radioButton03 = (RadioButton) viewDialog.findViewById(R.id.rb_content_dialog_03);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlertDialog.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlertDialog.dismiss();
            }
        });


        radioButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isCheckedOne){
                    radioButton01.setChecked(false);
                    isCheckedOne = false;
                }else {
                    radioButton01.setChecked(true);
                    isCheckedOne = true;
                }
            }
        });

        radioButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isCheckedTwo){
                    radioButton02.setChecked(false);
                    isCheckedTwo = false;
                }else {
                    radioButton02.setChecked(true);
                    isCheckedTwo = true;
                }
            }
        });

        radioButton03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isCheckedThree){
                    radioButton03.setChecked(false);
                    isCheckedOne = false;
                }else {
                    radioButton03.setChecked(true);
                    isCheckedThree = true;
                }
            }
        });


        builder.setView(viewDialog);
        mAlertDialog = builder.create();
        mAlertDialog.show();

    }

    private void scaleView() {
        if (isScale) {
            mLlContentControl.setVisibility(View.GONE);
            mTvContentHeaderTitle.setTextSize(40);
            isScale = false;
        } else {
            mLlContentControl.setVisibility(View.VISIBLE);
            mTvContentHeaderTitle.setTextSize(30);
            isScale = true;
        }
    }
}
