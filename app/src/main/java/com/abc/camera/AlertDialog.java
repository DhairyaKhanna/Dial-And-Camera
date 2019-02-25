package com.abc.camera;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class AlertDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        android.support.v7.app.AlertDialog.Builder builder ;

    //    builder.setCancelable(false);
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP )
        {
            builder = new android.support.v7.app.AlertDialog.Builder(AlertDialog.this, android.R.style.Widget);
        }
        else
            {
                builder = new android.support.v7.app.AlertDialog.Builder(AlertDialog.this);
            }
        builder.setTitle("karna aa delete?")
                .setPositiveButton("g han g", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("CHAL GAYA","ON POSITIVE:"+which);
                    }
                });
                builder.setNegativeButton("na g na", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("negative button","on click negative"+which);
                    }
                })
                .show();


        }
    }


