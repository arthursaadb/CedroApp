package com.example.arthursaad.cedroapp.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.arthursaad.cedroapp.R;
import com.example.arthursaad.cedroapp.ui.registerUser.RegisterUserActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.inputEmail)
    EditText txtEmail;

    @BindView(R.id.inputPassword)
    EditText txtPassword;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new LoginPresenter();
        presenter.setView(this);
    }

    @OnClick({R.id.inputEmail, R.id.inputPassword, R.id.btnLogin, R.id.idCreate})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idCreate:
                Intent intent = new Intent(this, RegisterUserActivity.class);
                startActivity(intent);
                break;
            case R.id.inputEmail:
                txtEmail.setError(null);
                break;
            case R.id.inputPassword:
                txtPassword.setError(null);
                break;
            case R.id.btnLogin:
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                if (presenter.validateEmail(email) == LoginPresenter.VALIDATEDATA.CORRECT && presenter.validatePassword(password) == LoginPresenter.VALIDATEDATA.CORRECT) {
                    presenter.doLogin(email, password);
                } else {
                    if (presenter.validateEmail(email) == LoginPresenter.VALIDATEDATA.WRONG) {
                        txtEmail.setError(getString(R.string.blankEmail));
                    }
                    if (presenter.validatePassword(password) == LoginPresenter.VALIDATEDATA.WRONG) {
                        txtPassword.setError(getString(R.string.blankPassword));
                    }
                }
                break;
        }
    }
}
