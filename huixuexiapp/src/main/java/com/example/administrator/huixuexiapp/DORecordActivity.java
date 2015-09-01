package com.example.administrator.huixuexiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.huixuexiapp.dao.DbHelper;
import com.example.administrator.huixuexiapp.entity.ChengZhangRecord;

import java.util.Date;

public class DORecordActivity extends Activity {
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dorecord);
        txt1=(TextView)findViewById(R.id.fanhui1);
        txt2=(TextView)findViewById(R.id.title1);
        txt3=(TextView)findViewById(R.id.txt_baocun);
         txt4=(TextView)findViewById(R.id.secret_txt);

        Intent intent=getIntent();
        final String name= intent.getStringExtra("titleName");
        if(intent.getStringExtra("headerMessage").equals("")){

        }else {
            final String headerMessage = intent.getStringExtra("headerMessage");
            final String mainMseesage=intent.getStringExtra("mainMessage");
            final String gloryMessage=intent.getStringExtra("gloryMessage");
            txt2.setText(headerMessage);
            if(mainMseesage.equals("")){
                txt4.setText(gloryMessage);
            }else{

                txt4.setText(mainMseesage);
            }

        }

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DORecordActivity.this,ChengZhangHuiActivity.class);
                startActivity(intent);
            }
        });
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper=DbHelper.newInstanse(v.getContext());
                ChengZhangRecord czr=new ChengZhangRecord();
                if(name.equals("荣誉纪录")){
                    czr.setCzh_glory_content(txt4.getText().toString());
                    czr.setUser_id(1);
                    czr.setCzh_content("");
                    czr.setCzh_limit_status(1);
                    czr.setCzh_create_time(new Date().toString());
                }  else if(name.equals("文字随记")){
                    czr.setCzh_content(txt4.getText().toString());
                    czr.setUser_id(1);
                    czr.setCzh_glory_content("");
                    czr.setCzh_limit_status(1);
                    czr.setCzh_create_time(new Date().toString());
                }
                dbHelper.addChengZhangRecord(czr);

                Toast.makeText(DORecordActivity.this,"保存完毕，返回主页",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(DORecordActivity.this,ChengZhangHuiActivity.class);
                startActivity(intent);
            }
        });
    }
}
