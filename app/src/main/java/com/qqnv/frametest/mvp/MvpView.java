package com.qqnv.frametest.mvp;

import com.qqnv.frametest.bean.Account;

/**
 * @author: huangchao
 * @version: 1.0.0
 * @date: 5/10/21 10:33 PM
 * @description:
 */
public interface MvpView {

    String getUserInput();
    void showSuccessPage(Account account);
    void showFailedPage();

}
