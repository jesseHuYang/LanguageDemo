# LanguageDemo
switch language
### Android多语言切换功能
在做这个功能的时候我们首先有三步:
##### 1. 首先APP内部实现切换功能
##### 2.在重新启动应用的时候不被系统设置重置
##### 3.应用使用中去切换系统设置
#### 当然前提就是我们在res中建好了各种语言包
下面我们就一步步去实现:
###### 1.切换语言
 <pre> public static void switchLanguage (Context context, int statusCode) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        config.locale = getLocale(statusCode);
        resources.updateConfiguration(config, dm);
        saveLanguageStatus(context, statusCode);
    }
    </pre>
    切换之后我们就要考虑刷新设置重启mainActivity
    <pre>
    Intent intent = new Intent(this, MainActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(intent);
    </pre>
    当然你也可以直接杀死进程,再启动splash界面,但是我感觉这样交互不是特别好
###### 2.重新启动应用时将我们之前设置的属性设置重置,这个值我们可以保持到sp文件中或者DB中
在application文件中去恢复设置
<pre>
/**获取默认值
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
</pre>
###### 3.当我们应用处于启动状态,此时去设置系统属性,activity会重走oncreate()方法,我们可以在此方法中去改回我们设置的属性,为了避免在每个activity中去设置我们可以写个BaseActivtiy,在该方法中去配置
例如:<pre>
 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LanguageUtils.resetDefaultLanguage(this);
    }
</pre>


##### 此上几个步骤就基本完成了切换语言的功能,如有不对之处请提出指正,共同进步,当然还可能有其它更好的方法,也可以与我们分享!
 
