package com.fanxin.test;

import android.os.Environment;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.fanxin.liteorm.LiteOrmUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LiteOrmUtil.init(getApplication());
        LiteOrmUtil.setSdDbPath(Environment.getExternalStorageDirectory().getPath()+"/fanxin/db");
        LiteOrmUtil.get().save(new CMyData(22,"fanxin",true));
    }
}
