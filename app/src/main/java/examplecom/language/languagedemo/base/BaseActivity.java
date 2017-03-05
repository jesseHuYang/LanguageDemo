package examplecom.language.languagedemo.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import examplecom.language.languagedemo.utils.LanguageUtils;

/**
 * Auther:JesseHu
 * Date 2017/3/1 0001
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LanguageUtils.resetDefaultLanguage(this);
    }
}
