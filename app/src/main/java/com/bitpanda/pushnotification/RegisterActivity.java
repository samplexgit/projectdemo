package com.bitpanda.pushnotification;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.os.Handler;

public class RegisterActivity extends AppCompatActivity {

    private Button dialogBtn;
    private AlertDialog.Builder popupBuilder;
    private AlertDialog popupDialog;

    Drawable drawable;

    private AnalogClock analogClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
    }

    private void init() {
        dialogBtn = (Button) findViewById(R.id.button);
        dialogBtn.setOnClickListener(btnClickListener);

        drawable = new ColorDrawable(Color.BLACK);
        drawable.setAlpha(1);

        analogClock = new AnalogClock(this);
    }

    private void showPopupScreen() {
        popupBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View popupView = inflater.inflate(R.layout.home_popup, null);
        popupBuilder.setView(popupView);

        popupDialog = popupBuilder.create();
        popupDialog.setCancelable(true);
        popupDialog.show();
        popupDialog.getWindow().setBackgroundDrawable(drawable);

        ImageView btnClose = (ImageView) popupDialog.findViewById(R.id.iv_close);
        btnClose.setOnClickListener(onCloseClickListener);
    }

    View.OnClickListener btnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            showPopupScreen();
        }
    };

    View.OnClickListener onCloseClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            popupDialog.hide();
        }
    };
}
