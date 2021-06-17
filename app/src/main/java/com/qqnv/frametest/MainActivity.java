package com.qqnv.frametest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.qqnv.frametest.databinding.DataBindingActivity;
import com.qqnv.frametest.mvc.MvcActivity;
import com.qqnv.frametest.mvp.MvpActivity;
import com.qqnv.frametest.mvvm.MvvmActivity;
import com.qqnv.frametest.normal.NormalActivity;

/**
 * @author: huangchao
 * @version: 1.0.0
 * @date: 5/10/21 2:36 PM
 * @description:
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_click).setOnClickListener(v -> {
           startActivity(new Intent(this, MvvmActivity.class));
        });
    }
}