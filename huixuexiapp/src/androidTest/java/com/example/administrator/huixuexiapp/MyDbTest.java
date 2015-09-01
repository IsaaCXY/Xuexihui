package com.example.administrator.huixuexiapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import android.util.Log;

import com.example.administrator.huixuexiapp.dao.DbHelper;
import com.example.administrator.huixuexiapp.entity.ChengZhangRecord;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/8/30.
 */
public class MyDbTest extends AndroidTestCase{
   // DbHelper db=DbHelper.newinstance(getContext());

    public void testCreateTable(){
        DbHelper db=DbHelper.newInstanse(getContext());
        db.onCreate(db.getReadableDatabase());
        Log.e("test","创建数据哭成共");
    }

    public  void testAdd(){
        DbHelper db=DbHelper.newInstanse(getContext());
        ChengZhangRecord czr=new ChengZhangRecord();
        czr.setCzh_content("shauhah");
        czr.setCzh_glory_photo("睡觉的睡觉了卡据了解");
        czr.setCzh_glory_content("上加大了快速的加拉数据库");
        czr.setCzh_glory_photo("速度就算了家里");
        czr.setCzh_little_secret("sd卡说了都没离开");
        czr.setCzh_create_time(new Date().toString());
        db.addChengZhangRecord(czr);
    }

    public void testFindAllChengZhangRecord(){
        DbHelper db=DbHelper.newInstanse(getContext());
       List<ChengZhangRecord> list=db.findAllCZR();
        Log.i("test",""+list.size());
        for (ChengZhangRecord czr:list
             ) {
            Log.i("test",czr.getCzh_content());
            Log.i("test",czr.getCzh_glory_content());
        }

    }

    public void testDropTable(){
        DbHelper db=DbHelper.newInstanse(getContext());
        db.dropTable();
    }
}
