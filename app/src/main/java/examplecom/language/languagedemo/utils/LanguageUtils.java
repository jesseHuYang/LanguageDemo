package examplecom.language.languagedemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Auther:JesseHu
 * Date 2017/3/1 0001
 */

public class LanguageUtils {
    public static final int DEFAULT = 0;
    public static final int CHINA = 1;
    public static final int ENGLISH = 2;
    private static String MY_PERS = "language";

    /**
     * 切换语言
     * @param context
     * @param statusCode
     */
    public static void switchLanguage (Context context, int statusCode) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        config.locale = getLocale(statusCode);
        resources.updateConfiguration(config, dm);
        saveLanguageStatus(context, statusCode);
    }

    /**
     * 获取设置语言格式
     * @param statusCode
     * @return
     */
    private static Locale getLocale(int statusCode) {
        if (statusCode == DEFAULT) {
            return Locale.getDefault();
        } else if (statusCode == CHINA) {
            return Locale.SIMPLIFIED_CHINESE;
        }else if (statusCode == ENGLISH){
            return Locale.ENGLISH;
        }
        return Locale.getDefault();
    }

    /**
     * 本地持久化状态
     * @param context
     * @param status
     */
    public static void saveLanguageStatus(Context context, int status) {
        SharedPreferences sp = context.getSharedPreferences(MY_PERS, Activity.MODE_PRIVATE);
        sp.edit().putInt("type", status).commit();
    }

    /**
     * 获取值
     * @param context
     * @return
     */
    public static int getLanguageStatus(Context context){
        SharedPreferences sp = context.getSharedPreferences(MY_PERS,Activity.MODE_PRIVATE);
        return sp.getInt("type", DEFAULT);
    }

    /**
     * 恢复应用默认值
     * @param context
     */
    public static void resetDefaultLanguage (Context context){
        int type = getLanguageStatus(context);
        switchLanguage(context, type);
    }
}

