package com.example.arthursaad.cedroapp.ui.registerUser;

import android.content.Intent;

import com.example.arthursaad.cedroapp.R;
import com.example.arthursaad.cedroapp.model.Token;
import com.example.arthursaad.cedroapp.model.User;
import com.example.arthursaad.cedroapp.helper.HelperSaveToken;
import com.example.arthursaad.cedroapp.service.ResponseListener;
import com.example.arthursaad.cedroapp.service.Service;
import com.example.arthursaad.cedroapp.ui.dialog.CustomDialog;
import com.example.arthursaad.cedroapp.ui.login.LoginActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterUserPresenter {

    public enum VALIDATEDATA{
        CORRECT,
        WRONG
    }


    Service service = new Service();
    RegisterUserActivity mView;

    public void registerUser(String nome,
                             String email,
                             String senha) {
            User user = new User(nome, email, senha);
            service.doRegister(user,mView, new ResponseListener<Token>() {
                @Override
                public void callbackSucessResponse(Token response) {
                    HelperSaveToken.saveToken(response,mView.getApplicationContext());
                    CustomDialog cdd = new CustomDialog(mView, mView.getString(R.string.registerSucess), LoginActivity.class);
                    cdd.show();
                }

                @Override
                public void callbackFailureResponse(String error) {
                    CustomDialog cdd = new CustomDialog(mView, mView.getString(R.string.registerError),null);
                    cdd.show();
                }
            });
    }

    public RegisterUserPresenter.VALIDATEDATA validatePassword(String password){
        return (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}"))
                ? VALIDATEDATA.CORRECT : VALIDATEDATA.WRONG;
    }

    public RegisterUserPresenter.VALIDATEDATA validateBlankEmail(String email){
        return (email.matches(""))
                ? VALIDATEDATA.WRONG : VALIDATEDATA.CORRECT;
    }

    public RegisterUserPresenter.VALIDATEDATA validateBlankPassword(String password){
        return (password.matches(""))
                ? VALIDATEDATA.WRONG : VALIDATEDATA.CORRECT;
    }

    public RegisterUserPresenter.VALIDATEDATA validateBlankName(String name){
        return (name.matches(""))
                ? VALIDATEDATA.WRONG : VALIDATEDATA.CORRECT;
    }

    public boolean validEmail(String email){
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }






    public void setView(RegisterUserActivity view) {
        this.mView = view;
    }


}
