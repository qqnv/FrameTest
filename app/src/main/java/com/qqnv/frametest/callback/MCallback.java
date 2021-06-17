package com.qqnv.frametest.callback;

import com.qqnv.frametest.bean.Account;

/**
 * @author: huangchao
 * @version: 1.0.0
 * @date: 5/10/21 7:22 PM
 * @description: 成功或失败返回接口
 */
public interface MCallback {
    void onSuccess(Account account);
    void onFailed();
}
