package examplecom.language.languagedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import examplecom.language.languagedemo.base.BaseActivity;
import examplecom.language.languagedemo.utils.LanguageUtils;

/**
 * Auther:JesseHu
 * Date 2017/3/1 0001
 */
public class SwitchLanguageActivity extends BaseActivity implements View.OnClickListener{
    private RelativeLayout mSystem_rl;
    private RelativeLayout mChinese_rl;
    private RelativeLayout mEnglish_rl;
    private TextView mSystem_tv;
    private TextView mChinese_tv;
    private TextView mEnglish_tv;
    private ImageView mSystem_iv;
    private ImageView mChinese_iv;
    private ImageView mEnglish_iv;
    private Button switchLanguage;
    private int statusCode = LanguageUtils.DEFAULT;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        initRes();
        initData();
    }

    private void initData() {
        hideImage();
        statusCode =  LanguageUtils.getLanguageStatus(this);
        if (statusCode == LanguageUtils.CHINA) {
            mChinese_iv.setVisibility(View.VISIBLE);
        } else if (statusCode == LanguageUtils.ENGLISH) {
            mEnglish_iv.setVisibility(View.VISIBLE);
        } else {
            mSystem_iv.setVisibility(View.VISIBLE);
        }
    }

    private void initRes() {
        mSystem_rl = (RelativeLayout) findViewById(R.id.rl_system);
        mChinese_rl = (RelativeLayout) findViewById(R.id.rl_chinese);
        mEnglish_rl = (RelativeLayout) findViewById(R.id.rl_english);
        mSystem_tv = (TextView) findViewById(R.id.tv_system);
        mChinese_tv = (TextView) findViewById(R.id.tv_chinese);
        mEnglish_tv = (TextView) findViewById(R.id.tv_english);
        mSystem_iv = (ImageView) findViewById(R.id.iv_system);
        mChinese_iv = (ImageView) findViewById(R.id.iv_chinese);
        mEnglish_iv = (ImageView) findViewById(R.id.iv_english);
        switchLanguage = (Button) findViewById(R.id.bt_switch);
        switchLanguage.setOnClickListener(this);
        mSystem_rl.setOnClickListener(this);
        mChinese_rl.setOnClickListener(this);
        mEnglish_rl.setOnClickListener(this);
    }
    private void hideImage (){
        mSystem_iv.setVisibility(View.GONE);
        mChinese_iv.setVisibility(View.GONE);
        mEnglish_iv.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        hideImage();
        switch (view.getId()) {
            case R.id.rl_system:
                statusCode = LanguageUtils.DEFAULT;
                mSystem_iv.setVisibility(View.VISIBLE);
                break;
            case R.id.rl_chinese:
                statusCode = LanguageUtils.CHINA;
                mChinese_iv.setVisibility(View.VISIBLE);
                break;
            case R.id.rl_english:
                statusCode = LanguageUtils.ENGLISH;
                mEnglish_iv.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_switch:
                checkLanguage();
                break;
        }
    }

    /**
     * 切换语言
     */
    private void checkLanguage() {
    LanguageUtils.switchLanguage(this, statusCode);
    Intent intent = new Intent(this, MainActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(intent);
    }
}

