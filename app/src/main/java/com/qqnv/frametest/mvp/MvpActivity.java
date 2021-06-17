package com.qqnv.frametest.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qqnv.frametest.R;
import com.qqnv.frametest.bean.Account;
import com.qqnv.frametest.tool.Tool;

/**
 * @author: huangchao
 * @version: 1.0.0
 * @date: 5/10/21 3:36 PM
 * @description: 优点：解决了MVC中Controller与View过度耦合的缺点，职责划分明显，更加易于维护
 *              缺点：接口数量多，项目复杂度升高，随着项目复杂度的提升，Presenter层将会越来越臃肿
 */
public class MvpActivity extends AppCompatActivity implements View.OnClickListener, MvpView {

    private TextView mTvResult;
    private EditText mEtAccount;

    private MvpPresenter mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        initView();
        mvpPresenter = new MvpPresenter(this);
    }

    private void initView() {
        mEtAccount = findViewById(R.id.et_account);
        mTvResult = findViewById(R.id.tv_result);
        findViewById(R.id.btn_getAccount).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Tool.hideKeyboard(v);
        mvpPresenter.getData();
    }

    @Override
    public String getUserInput() {
        return mEtAccount.getText().toString();
    }

    @Override
    public void showSuccessPage(Account account) {
        mTvResult.setText("用户账号：" + account.getName() + "|" + "用户等级：" + account.getLevel());
    }

    @Override
    public void showFailedPage() {
        mTvResult.setText("用户信息获取失败");
    }
}