package com.example.administrator.huixuexiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class SomeButtonActivity extends Activity {
    TextView btn1;
    TextView btn2;
    TextView btn3;
    TextView btn4;
    TextView btn5;
    TextView btn6;
    ImageView btn_tuichu1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_some_button);
         btn1=(TextView)findViewById(R.id.btn1);
         btn2=(TextView)findViewById(R.id.btn2);
         btn3=(TextView)findViewById(R.id.btn3);
         btn4=(TextView)findViewById(R.id.btn4);
         btn5=(TextView)findViewById(R.id.btn5);
         btn6=(TextView)findViewById(R.id.btn6);
        btn_tuichu1=(ImageView)findViewById(R.id.button_tuichu1);
        btn_tuichu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_CAMERA_BUTTON,null);

                //intent.setAction(intent.ACTION_CAMERA_BUTTON);
                //startActivity(intent);
                SomeButtonActivity.this.sendBroadcast(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);

                startActivity(intent);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            //记录荣誉的
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SomeButtonActivity.this,DORecordActivity.class);
                intent.putExtra("titleName","荣誉纪录");
                intent.putExtra("headerMessage","");
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setType("images/*");
                intent.setAction(intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,11);

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            //记录荣誉的
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SomeButtonActivity.this,DORecordActivity.class);
                intent.putExtra("titleName","文字随记");
                intent.putExtra("headerMessage","");
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SomeButtonActivity.this,DORecordActivity.class);
                intent.putExtra("headerMessage","");
                intent.putExtra("titleName","小秘密");
                startActivity(intent);
            }
        });
    }

  /*  public void clickBtn(View view){
        Log.i("test","进入点击方法");
        int id=view.getId();
        if(id==R.id.btn1){
            Intent intent=new Intent();
            intent.setAction(intent.ACTION_CAMERA_BUTTON);
            startActivity(intent);
        }else if(id==R.id.btn2){
            //录音机
            Intent intent=new Intent();
            intent.setAction(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            startActivity(intent);
        }
        else if(id==R.id.btn3){
            //荣誉纪录
            Intent intent=new Intent();
            intent.setAction(intent.ACTION_CAMERA_BUTTON);
            startActivity(intent);
        }
        else if(id==R.id.btn4){
            //从相册里导入相片
            Intent intent=new Intent();
            intent.setType("images*//*");
            intent.setAction(intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, 11);
        }
        else if(id==R.id.btn5){
            //文字随记
            Intent intent=new Intent();
            intent.setAction(intent.ACTION_CAMERA_BUTTON);
            startActivity(intent);
        }
        else if(id==R.id.btn6){
            //悄悄话
            Intent intent=new Intent();
            intent.setAction(intent.ACTION_CAMERA_BUTTON);
            startActivity(intent);
        }

    }
*/
}
