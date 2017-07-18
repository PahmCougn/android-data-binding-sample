package com.smile.databindingsample.viewcontrollers;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.smile.databindingsample.R;
import com.smile.databindingsample.common.validation.Validator;
import com.smile.databindingsample.databinding.LayoutLoginActivityBinding;
import com.smile.databindingsample.viewmodels.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    Validator validator;
    LoginViewModel loginViewModel = new LoginViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutLoginActivityBinding loginActivityBinding = DataBindingUtil.setContentView(this, R.layout.layout_login_activity);
        loginActivityBinding.setLoginViewModel(this.loginViewModel);
        validator = new Validator(loginActivityBinding);
        loginActivityBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.validate();
            }
        });
    }
}
