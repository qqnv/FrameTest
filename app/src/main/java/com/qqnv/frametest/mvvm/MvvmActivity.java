package com.qqnv.frametest.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.qqnv.frametest.R;
import com.qqnv.frametest.databinding.ActivityMvvmBinding;

/**
 * @author: huangchao
 * @version: 1.0.0
 * @date: 5/10/21 11:32 PM
 * @description: 优点：实现了数据与视图的双向绑定，极大的简化代码
 *              缺点：bug难以调试
 *              改进：建议使用liveData+viewModel实现，可以更好的解决mvvm之间的通信问题，
 *              并且可以感知组件的生命周期，能够有效的避免内存泄漏
 */
public class MvvmActivity extends AppCompatActivity {

    private ActivityMvvmBinding binding;
    private MvvmViewModel mvvmViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm);
        mvvmViewModel = new MvvmViewModel(getApplication());
        binding.setViewModel(mvvmViewModel);
    }
}