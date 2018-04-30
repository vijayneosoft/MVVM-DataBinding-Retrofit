package com.example.webwerks.neoapplication.views.viewModel;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.widget.Toast;

import com.example.webwerks.neoapplication.BaseActivity;
import com.example.webwerks.neoapplication.R;
import com.example.webwerks.neoapplication.net.ApiClient;
import com.example.webwerks.neoapplication.net.ApiInterface;
import com.example.webwerks.neoapplication.net.ApiUtils;
import com.example.webwerks.neoapplication.utils.NetworkHelper;
import com.example.webwerks.neoapplication.views.model.LoginModel;

/**
 * Created by webwerks on 27/4/18.
 */

public class LoginViewModel extends ViewModel {

    public void checkLogin( final Context context, String username, String password){
      NetworkHelper.create(context).callWebService(ApiUtils.getApiService().doLogin(username, password), new NetworkHelper.NetworkCallback<LoginModel>() {

          @Override
          public void onSuccess(LoginModel data) {
              Toast.makeText(context, R.string.login_success, Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onFailure(LoginModel error) {
              Toast.makeText(context, R.string.login_unsuccessful, Toast.LENGTH_SHORT).show();
          }
      });

    }


}
