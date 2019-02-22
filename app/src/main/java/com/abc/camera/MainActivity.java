package com.abc.camera;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt;
    Button btn2;
    Imageview iimg;
    Button btn3;
    EditText edt;
    private static final int request_code= 7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //       Button bt = (Button) findViewById(R.id.camera);
        //     ImageView iimg = (ImageView) findViewById(R.id.img);
        //    bt.setOnClickListener(new View.OnClickListener()
        //   {
        //     @Override
        //   public void onClick(View v)
        // {
        //     Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //   startActivityForResult(intent, 0);
        edt = findViewById(R.id.call);
        Button btn3 = (Button) findViewById(R.id.dial);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makephonecall();
            }

        });



        Button btn2 = (Button) findViewById(R.id.share_content);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                String sharebody = "  I am sharing this text using my own build app!!!!!";
                String shareSub = "subject here";
                intent1.putExtra(Intent.EXTRA_SUBJECT,sharebody);
                intent1.putExtra(Intent.EXTRA_TEXT,sharebody);
                startActivity(Intent.createChooser(intent1, "SHaRE USiNG"));
            }


        });
    }
     private void makephonecall(){
        String number = edt.getText().toString();
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},request_code);
            }

            else{
            String dial = "tel:"+number;
            startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));}

        }
        else{
            Toast.makeText(this,"Enter phn NO ",Toast.LENGTH_SHORT).show();
        }

    }
    //hello this for permission

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode== request_code){
            if (grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                makephonecall();
            }
            else{
                Toast.makeText(this,"Permission DENIED",Toast.LENGTH_SHORT);
            }
        }
    }
}





