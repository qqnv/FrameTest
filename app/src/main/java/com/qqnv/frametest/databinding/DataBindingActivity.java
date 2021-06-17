package com.qqnv.frametest.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.qqnv.frametest.R;
import com.qqnv.frametest.bean.Account;

/**
 * @author: huangchao
 * @version: 1.0.0
 * @date: 5/10/21 10:36 PM
 * @description:
 */
public class DataBindingActivity extends AppCompatActivity {

    private Account account;
    private ActivityDatabindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        account = new Account();
        account.setName("Test");
        account.setLevel(100);
        binding.setAccount(account);
        binding.setActivity(this);
    }

    public void onClick(View v) {
        int level = account.getLevel();
        account.setLevel(level + 1);
//        binding.setAccount(account);
    }
}