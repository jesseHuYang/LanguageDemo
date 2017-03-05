package examplecom.language.languagedemo.base;

import android.app.Application;

import examplecom.language.languagedemo.utils.LanguageUtils;

/**
 * Auther:JesseHu
 * Date 2017/3/1 0001
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LanguageUtils.resetDefaultLanguage(this);
    }
}
