package com.example.webwerks.neoapplication;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by webwerks on 27/4/18.
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    protected T mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,getContentView());
        onWindowCreated();
        initView();
    }

    public abstract int getContentView();
    public abstract void onWindowCreated();
    public abstract void initView();

}
