package com.qqnv.frametest.normal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qqnv.frametest.R;
import com.qqnv.frametest.bean.Account;
import com.qqnv.frametest.callback.MCallback;
import com.qqnv.frametest.tool.Tool;

import java.util.Random;

/**
 * @author: huangchao
 * @version: 1.0.0
 * @date: 5/10/21 10:36 PM
 * @description:
 */
public class NormalActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvResult;
    private EditText mEtAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
    }

    private void initView() {
        mEtAccount = findViewById(R.id.et_account);
        mTvResult = findViewById(R.id.tv_result);
        findViewById(R.id.btn_getAccount).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String userInput = getUserInput();
        Tool.hideKeyboard(v);
        getAccount(userInput, new MCallback() {
            @Override
            public void onSuccess(Account account) {
                showSuccessPage(account);
            }

            @Override
            public void onFailed() {
                showFailedPage();
            }
        });
    }

    /**
     * 获取用户输入信息
     *
     * @return
     */
    private String getUserInput() {
        return mEtAccount.getText().toString();
    }

    /**
     * 展示获取用户信息成功的界面
     */
    private void showSuccessPage(Account account) {
        mTvResult.setText("用户账号：" + account.getName() + "|" + "用户等级：" + account.getLevel());
    }


    /**
     * 展示获取用户信息失败的界面
     */
    private void showFailedPage() {
        mTvResult.setText("用户信息获取失败");
    }

    /**
     * 获取账号数据
     */
    private void getAccount(String accountName, MCallback callback){
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess){
            Account account = new Account();
            account.setName(accountName);
            account.setLevel(100);
            callback.onSuccess(account);
        }else {
            callback.onFailed();
        }
    }
}