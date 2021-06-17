package com.qqnv.frametest.bean;

import com.qqnv.frametest.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @author: huangchao
 * @version: 1.0.0
 * @date: 5/10/21 7:20 PM
 * @description: 实体类
 */
public class Account extends BaseObservable {

    private String name;//用户名称
    private int level;//用户等级

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Bindable
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        notifyPropertyChanged(BR.level);
    }
}
