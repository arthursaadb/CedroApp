package com.example.arthursaad.cedroapp.ui.registerUser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arthursaad.cedroapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.arthursaad.cedroapp.ui.registerUser.RegisterUserPresenter.*;

public class RegisterUserActivity extends AppCompatActivity {

    //Atributos
    @BindView(R.id.inputName)
    EditText txtNome;

    @BindView(R.id.inputEmail)
    EditText txtEmail;

    @BindView(R.id.inputPassword)
    EditText txtSenha;

    RegisterUserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        presenter = new RegisterUserPresenter();
        presenter.setView(this);

    }

    @OnClick({R.id.btnRegister, R.id.inputPassword, R.id.inputEmail, R.id.inputName})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.inputPassword:
                txtSenha.setError(null);
                break;
            case R.id.inputEmail:
                txtEmail.setError(null);
                break;
            case R.id.inputName:
                txtNome.setError(null);
                break;
            case R.id.btnRegister:
                String name = txtNome.getText().toString();
                String email = txtEmail.getText().toString();
                String password = txtSenha.getText().toString();

                if (presenter.validateBlankEmail(email) == RegisterUserPresenter.VALIDATEDATA.CORRECT &&
                        presenter.validateBlankName(name) == RegisterUserPresenter.VALIDATEDATA.CORRECT &&
                        presenter.validateBlankPassword(password) == RegisterUserPresenter.VALIDATEDATA.CORRECT) {
                    if (presenter.validatePassword(password) == VALIDATEDATA.CORRECT && presenter.validEmail(email) == true) {
                        presenter.registerUser(name, email, password);
                    } else {
                        if(presenter.validEmail(email)) {
                            txtSenha.setError(getString(R.string.passwordError));
                        }
                        else
                            txtEmail.setError(getString(R.string.errorEmail));
                    }
                } else {
                    if (presenter.validateBlankPassword(password) == RegisterUserPresenter.VALIDATEDATA.WRONG) {
                        txtSenha.setError(getString(R.string.blankPassword));
                    }
                    if (presenter.validateBlankName(name) == RegisterUserPresenter.VALIDATEDATA.WRONG) {
                        txtNome.setError(getString(R.string.blankName));
                    }
                    if (presenter.validateBlankEmail(email) == RegisterUserPresenter.VALIDATEDATA.WRONG) {
                        txtEmail.setError(getString(R.string.blankEmail));
                    }
                }
        }


    }
}
