package com.example.arthursaad.cedroapp.ui.createSites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.arthursaad.cedroapp.R;
import com.example.arthursaad.cedroapp.ui.dialog.CustomDialog;
import com.example.arthursaad.cedroapp.ui.recyclerSites.SitesActivity;

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterSitesActivity extends AppCompatActivity {

    @BindView(R.id.inputUrl)
    EditText txtUrl;

    @BindView(R.id.inputEmail)
    EditText txtLogin;

    @BindView(R.id.inputPassword)
    EditText txtPassword;

    RegisterSitesPresenter registersites;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_sites);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnRegister)
    public void onClick(View view){
        String url = txtUrl.getText().toString();
        String login = txtLogin.getText().toString();
        String password = txtPassword.getText().toString();

        registersites = new RegisterSitesPresenter();
        registersites.setView(this);
        try {
            if(registersites.isValidUrl(url)){
                registersites.addData(url,login,password);
                CustomDialog cdd = new CustomDialog(this, getString(R.string.sucessCreate),SitesActivity.class);
                cdd.show();
            }
            else
                txtUrl.setError(this.getString(R.string.urlIncorreta));
        } catch (SQLException e) {
            CustomDialog cdd = new CustomDialog(this, getString(R.string.errorCreate),null);
            cdd.show();
        }
    }
}
