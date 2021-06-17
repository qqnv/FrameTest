package com.qqnv.frametest.mvp;

import com.qqnv.frametest.bean.Account;
import com.qqnv.frametest.callback.MCallback;

/**
 * @author: huangchao
 * @version: 1.0.0
 * @date: 5/10/21 10:37 PM
 * @description:
 */
public class MvpPresenter {
    private MvpView mvpView;
    private MvpModel mvpModel;

    public MvpPresenter(MvpView mvpView) {
        this.mvpView = mvpView;
        this.mvpModel = new MvpModel();
    }

    public void getData() {
        mvpModel.getAccount(mvpView.getUserInput(), new MCallback() {
            @Override
            public void onSuccess(Account account) {
                mvpView.showSuccessPage(account);
            }

            @Override
            public void onFailed() {
                mvpView.showFailedPage();
            }
        });
    }
}
