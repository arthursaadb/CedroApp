package com.example.arthursaad.cedroapp.helper;

import com.example.arthursaad.cedroapp.ui.login.LoginPresenter;

public class inputsHelper {

    public enum VALIDATEDATA{
        CORRECT,
        WRONG
    }
    
    public inputsHelper.VALIDATEDATA validateEmail(String email){
        return (email.matches(""))
                ? inputsHelper.VALIDATEDATA.WRONG : inputsHelper.VALIDATEDATA.CORRECT;
    }

    public inputsHelper.VALIDATEDATA validatePassword(String password){
        return (password.matches(""))
                ? inputsHelper.VALIDATEDATA.WRONG : inputsHelper.VALIDATEDATA.CORRECT;
    }
}
