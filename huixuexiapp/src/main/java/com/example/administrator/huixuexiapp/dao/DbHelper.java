package com.example.administrator.huixuexiapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import com.example.administrator.huixuexiapp.entity.ChengZhangRecord;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/8/30.
 */
public class DbHelper extends SQLiteOpenHelper{
    //定义一些必要的属性
    private static  final  String DB_NAME="hxxapp.db";
    private  static final String TABLE_NAME="hxx_czh";
    private static final  int DB_VERSION=1;
    SQLiteDatabase db;

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
 /*   public static SQLiteDatabase openOrCreateDatabase(File file, CursorFactory factory) {
        return openOrCreateDatabase(file.getPath(), factory);
    }*/
    //定义一个静态方法，用于初始化
    public static DbHelper newInstanse(Context context){
       DbHelper dbHelper=new DbHelper(context,DB_NAME,null,DB_VERSION);

        return dbHelper;
    }
    public void onCreate(SQLiteDatabase db) {
       Log.i("test","zhe方法执行了吗");
       db.execSQL("create table " + TABLE_NAME + "(_Id  integer primary key autoincrement," +
               "user_id int , " +
               "czh_cotent varchar2(50) ," +
               "czh_photo varchar2(50)," +
               "czh_glory_content varchar2(50)," +
               "czh_glory_photo varchar2(50)," +
               "czh_little_secret varchar2(50)," +
               "czh_create_time varchar2(50)," +
               "czh_limit_status int)");
       Log.i("test", "数据库被创建hehehehheheheh");
   }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("test","这个onUpgrade方法在数据库更新的时候执行");
    }

  public void addChengZhangRecord(ChengZhangRecord czr){
      db=this.getReadableDatabase();
     Log.i("test", "数据库的 路径是：" + Environment.getDataDirectory().getAbsolutePath()) ;
      String sql="insert into hxx_czh(user_id,czh_cotent,czh_photo,czh_glory_content ,czh_glory_photo,czh_little_secret ,czh_create_time ,czh_limit_status) " +
              "values (1,?,?,?,?,?,?,1)";
      Log.i("test", "" + sql);
      SimpleDateFormat date=new SimpleDateFormat("MM月dd日");
      String currentDate=date.format(new Date()) ;
        db.execSQL(sql, new Object[]{czr.getCzh_content(),czr.getCzh_glory_photo(),czr.getCzh_glory_content(),czr.getCzh_glory_photo(),czr.getCzh_little_secret(),currentDate});

            Log.e("test","插入了一条数据");
    }


  public List<ChengZhangRecord> findAllCZR() {
      List<ChengZhangRecord> list=new ArrayList<ChengZhangRecord>();

      db = this.getWritableDatabase();
      Cursor cursor = db.rawQuery("select * from hxx_czh", null);
      while (cursor.moveToNext()) {
          Log.i("test", cursor.getInt(0) + "" + cursor.getInt(1) + cursor.getString(2) + cursor.getString(3) + cursor.getString(4) + "vvv" + cursor.getString(5) + cursor.getString(6) + cursor.getInt(8) + cursor.getString(7) + "不止一条表中信息");
          ChengZhangRecord czr = new ChengZhangRecord();

         czr.set_Id(cursor.getInt(0));
          czr.setUser_id(cursor.getInt(1));
          czr.setCzh_content(" " + cursor.getString(2));
          czr.setCzh_photo(" " + cursor.getString(3));
          czr.setCzh_glory_content(" "+cursor.getString(4));
          czr.setCzh_glory_photo(" "+cursor.getString(5));
          czr.setCzh_little_secret(" "+cursor.getString(6));
          czr.setCzh_create_time(" "+cursor.getString(7));
          czr.setCzh_limit_status(cursor.getInt(8));

        /*  czr.set_Id(1);
          czr.setUser_id(1);
          czr.setCzh_content("shax " );
          czr.setCzh_photo(" s沙xxx" );
          czr.setCzh_glory_content("沙b ");
          czr.setCzh_glory_photo("你苏迪曼 ");
          czr.setCzh_little_secret("你是看上你的 ");
          czr.setCzh_create_time(" 但是没看到");
          czr.setCzh_limit_status(1);*/


          list.add(czr);
      }
      cursor.close();
      return list;

  }

    public void dropTable(){
        db=this.getReadableDatabase();
        db.execSQL("drop table hxx_czh");
        Log.e("test","drop成功");
    }
}
