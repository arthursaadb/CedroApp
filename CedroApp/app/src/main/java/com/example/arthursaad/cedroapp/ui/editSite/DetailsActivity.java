package com.example.arthursaad.cedroapp.ui.editSite;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.arthursaad.cedroapp.R;
import com.example.arthursaad.cedroapp.helper.GliderHelper;
import com.example.arthursaad.cedroapp.helper.HelperSaveToken;
import com.example.arthursaad.cedroapp.helper.SiteDbHelper;
import com.example.arthursaad.cedroapp.model.Site;
import com.example.arthursaad.cedroapp.ui.recyclerSites.SitesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.imageIcon)
    ImageView imageView;

    @BindView(R.id.inputUrl)
    EditText txtUrl;

    @BindView(R.id.inputEmail)
    EditText txtUser;

    @BindView(R.id.inputPassword)
    EditText txtPassword;

    private DetailsPresenter detailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_site);
        ButterKnife.bind(this);
        detailsPresenter = new DetailsPresenter(this);
        detailsPresenter.loadDetail();
    }


    @OnClick({R.id.btnDetail, R.id.btnDelete, R.id.inputPassword,R.id.inputUrl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDetail:
                    if(detailsPresenter.isValidUrl(txtUrl.getText().toString())){
                        detailsPresenter.editSite();
                    }
                    else
                        txtUrl.setError(getString(R.string.urlIncorreta));

                break;
            case R.id.btnDelete:
                detailsPresenter.deleteSite();
                break;
            case R.id.inputUrl:
                txtUrl.setError(null);
                break;
            case R.id.inputPassword:
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Texto copiado", txtPassword.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(this, R.string.coyTransfer, Toast.LENGTH_SHORT).show();
        }
    }
}
