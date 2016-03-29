package com.example.jay.mobliesafe;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends Activity {

    private TextView tv_version;
    /**
     * 1.显示logo--设计的Logo要容易记忆、接受
     * 2.判断是否有网络
     * 3.判断是否版本升级
     * 4.判断合法性
     * 5.校验是否有SDcard
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //设置版本名称
        tv_version= (TextView) findViewById(R.id.tv_splash_version);
        tv_version.setText("版本号："+getVersionName());

    }

    private String getVersionName() {
        try {
            PackageManager pm=getPackageManager();
            //1-包名 2-附加条件
            PackageInfo packageInfo=pm.getPackageInfo(getPackageName(),0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return  "";
        }
    }


}
