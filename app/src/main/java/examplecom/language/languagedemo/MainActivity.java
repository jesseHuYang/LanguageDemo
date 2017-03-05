package examplecom.language.languagedemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import examplecom.language.languagedemo.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private Button mSwitchLanguage;
    private TextView mName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwitchLanguage = (Button) findViewById(R.id.bt_switch_language);
        mName = (TextView) findViewById(R.id.tv_name);
        mSwitchLanguage.setOnClickListener(onClickListener);
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, SwitchLanguageActivity.class));
        }
    };
}
