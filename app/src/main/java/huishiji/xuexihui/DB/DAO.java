package huishiji.xuexihui.DB;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/*数据库操作类*/
public class DAO {
SQLiteDatabase db;
//    Context context;
    public DAO(SQLiteDatabase db){
        this.db=db;
    }



//    SQLiteDatabase db=databaseHelper.getWritableDatabase();

    public long addData(String nick,String name,int sex,int age,String phonenumber,
                        String qq_number,int gradeNum,int classNum,String password,
                        int role){
        ContentValues values=new ContentValues();
        values.put("nickname",nick);
        values.put("name",name);
        values.put("sex",sex);
        values.put("age",age);
        values.put("phone_number",phonenumber);
        values.put("qq_number",qq_number);
        values.put("gradeNum",gradeNum);
        values.put("classNum",classNum);
        values.put("password",password);
        values.put("role", role);
        long l = db.insert("stu", null, values);//返回插入的行数
        db.close();
        return l;//据此判断是否插入成功
    }
    public void delData(){
//TODO
    }
    public void queryData(){
        //TODO
    }
    public void updData(){
        //TODO
    }
}
