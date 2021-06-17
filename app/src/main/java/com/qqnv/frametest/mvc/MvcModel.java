package com.qqnv.frametest.mvc;

import com.qqnv.frametest.bean.Account;
import com.qqnv.frametest.callback.MCallback;

import java.util.Random;

/**
 * @author: huangchao
 * @version: 1.0.0
 * @date: 5/10/21 10:04 PM
 * @description:
 */
public class MvcModel {
    /**
     * 获取账号数据
     */
    public void getAccount(String accountName, MCallback callback){
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
