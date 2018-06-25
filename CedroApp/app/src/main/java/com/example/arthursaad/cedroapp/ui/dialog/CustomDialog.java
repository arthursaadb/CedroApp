package com.example.arthursaad.cedroapp.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.arthursaad.cedroapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDialog extends Dialog {

    public Activity c;
    public Class go;
    public Dialog d;
    public String message;

    public CustomDialog(Activity a, String message, Class go) {
        super(a);
        this.c = a;
        this.message = message;
        this.go = go;
    }

    @BindView(R.id.dialogTextMessage)
    TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        View v = View.inflate(c, R.layout.custom_dialog, null);
        setContentView(v);
        ButterKnife.bind(this, v);
        txtMessage.setText(message);
    }

    @OnClick({R.id.btnOk})
    public void onClick(View v) {
        if (go != null) {
            Intent intent = new Intent(c, go);
            c.startActivity(intent);
        } else {
            this.dismiss();
        }
    }
}
