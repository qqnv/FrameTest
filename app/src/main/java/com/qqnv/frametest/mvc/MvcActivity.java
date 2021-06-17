package com.qqnv.frametest.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qqnv.frametest.R;
import com.qqnv.frametest.bean.Account;
import com.qqnv.frametest.callback.MCallback;
import com.qqnv.frametest.tool.Tool;

/**
 * @author: huangchao
 * @version: 1.0.0
 * @date: 5/10/21 3:36 PM
 * @description: 优点：一定程度上实现了Model与View的分离，降低了代码的耦合性
 *              缺点：Controller与View难以完全解耦，并且随着项目复杂度的提升，Controller会越来越臃肿
 */
public class MvcActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvResult;
    private EditText mEtAccount;

    private MvcModel mvcModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        initView();
        mvcModel = new MvcModel();
    }

    private void initView() {
        mEtAccount = findViewById(R.id.et_account);
        mTvResult = findViewById(R.id.tv_result);
        findViewById(R.id.btn_getAccount).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Tool.hideKeyboard(v);
        mvcModel.getAccount(getUserInput(), new MCallback() {
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
}