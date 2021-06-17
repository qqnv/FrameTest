package com.qqnv.frametest.mvvm;

import android.app.Application;
import android.view.View;

import com.qqnv.frametest.BR;
import com.qqnv.frametest.bean.Account;
import com.qqnv.frametest.callback.MCallback;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @author: huangchao
 * @version: 1.0.0
 * @date: 5/10/21 11:34 PM
 * @description:
 */
public class MvvmViewModel extends BaseObservable {

    private MvvmModel mvvmModel;
    private String userInput;
    private String result;

    /**
     * 一般传入Application对象，方便在ViewModel中使用application，比如SharePreference需要使用
     *
     * @param application
     */
    public MvvmViewModel(Application application) {
        mvvmModel = new MvvmModel();
    }

    public void getData(View v) {
        mvvmModel.getAccount(userInput, new MCallback() {
            @Override
            public void onSuccess(Account account) {
                String info = account.getName() + "｜" + account.getLevel();
                setResult(info);
            }

            @Override
            public void onFailed() {
                setResult("获取用户信息失败");
            }
        });
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    @Bindable
    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        notifyPropertyChanged(BR.userInput);
    }
}
