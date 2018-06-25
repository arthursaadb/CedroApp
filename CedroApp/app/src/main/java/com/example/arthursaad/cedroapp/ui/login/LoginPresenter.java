package com.example.arthursaad.cedroapp.ui.login;

import android.content.Intent;

import com.example.arthursaad.cedroapp.R;
import com.example.arthursaad.cedroapp.helper.HelperSaveToken;
import com.example.arthursaad.cedroapp.model.Token;
import com.example.arthursaad.cedroapp.model.User;
import com.example.arthursaad.cedroapp.service.ResponseListener;
import com.example.arthursaad.cedroapp.service.Service;
import com.example.arthursaad.cedroapp.ui.dialog.CustomDialog;
import com.example.arthursaad.cedroapp.ui.recyclerSites.SitesActivity;

public class LoginPresenter {

    public enum VALIDATEDATA{
        CORRECT,
        WRONG
    }


    Service service = new Service();
    LoginActivity mView;

    public void doLogin(String email,
                        String senha) {
        User user = new User(null, email, senha);
        service.doLogin(user,mView, new ResponseListener<Token>() {
            @Override
            public void callbackSucessResponse(Token response) {
                HelperSaveToken.saveToken(response,mView);
                Intent intent = new Intent(mView, SitesActivity.class);
                mView.startActivity(intent);
            }

            @Override
            public void callbackFailureResponse(String error) {
                CustomDialog cdd = new CustomDialog(mView, mView.getString(R.string.loginError),null);
                cdd.show();
            }
        });
    }

    public void setView(LoginActivity view) {
        this.mView = view;
    }

    public VALIDATEDATA validateEmail(String email){
        return (email.matches(""))
                ? VALIDATEDATA.WRONG : VALIDATEDATA.CORRECT;
    }

    public VALIDATEDATA validatePassword(String password){
        return (password.matches(""))
                ? VALIDATEDATA.WRONG : VALIDATEDATA.CORRECT;
    }

}
