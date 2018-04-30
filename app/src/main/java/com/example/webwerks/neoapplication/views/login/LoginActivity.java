package com.example.webwerks.neoapplication.views.login;

import android.arch.lifecycle.ViewModelProviders;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.webwerks.neoapplication.BaseActivity;
import com.example.webwerks.neoapplication.R;
import com.example.webwerks.neoapplication.databinding.ActivityLoginBinding;
import com.example.webwerks.neoapplication.views.viewModel.LoginViewModel;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    LoginViewModel loginViewModel;

    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void onWindowCreated() {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        mBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(mBinding.edtUsername.getText().toString()) && !TextUtils.isEmpty(mBinding.edtPassword.getText().toString())) {
                    loginViewModel.checkLogin(LoginActivity.this,
                            mBinding.edtUsername.getText().toString(),
                            mBinding.edtPassword.getText().toString());
                }else {
                    Toast.makeText(LoginActivity.this, R.string.error_input, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void initView() {

    }

}
