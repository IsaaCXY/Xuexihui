package huishiji.xuexihui.hxx.dao;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;

import com.example.administrator.hxx.R;
import com.example.administrator.hxx.entity.Point;
import com.example.administrator.hxx.entity.PointType;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.util.Log;

/**
 * Created by maggie on 15/8/18.
 */
public class DBHelper {

    private DbUtils db;
    private final int BUFFER_SIZE = 400000;
    private static final String DB_NAME="point2.db";
    public static final String PACKAGE_NAME = "com.example.administrator.hxx";
    public static final String DB_PATH = "/data"
            + Environment.getDataDirectory().getAbsolutePath() + "/"
            + PACKAGE_NAME;

    public DBHelper(Context context)
    {
//        try {
//            if (!(new File(DB_PATH+DB_NAME).exists())) {
//                //判断数据库文件是否存在，若不存在则执行导入，否则直接打开数据库
//                InputStream is = context.getResources().openRawResource(
//                        R.raw.point); //欲导入的数据库
//                FileOutputStream fos = new FileOutputStream(DB_PATH+DB_NAME);
//                byte[] buffer = new byte[BUFFER_SIZE];
//                int count = 0;
//                while ((count = is.read(buffer)) > 0) {
//                    fos.write(buffer, 0, count);
//                }
//                Log.i("Mytest","--------------11111111");
//                fos.close();
//                is.close();
//            }
//        }catch (FileNotFoundException e) {
//            //Log.e("Database", "File not found");
//            e.printStackTrace();
//        } catch (IOException e) {
//          //  Log.e("Database", "IO exception");
//            e.printStackTrace();
//        }

        db=DbUtils.create(context,DB_NAME);
    }

    public List<PointType> finfAllPointType(){
        List<PointType> list = null;
        try {

            list = db.findAll(PointType.class);
           // Log.i("Mytest","-------------------------");
        } catch (DbException e) {
            e.printStackTrace();
        }
        return list;
    }
    public PointType findPointTypeById(int id){
        PointType pointtype =null;
        try {
            pointtype = db.findById(PointType.class, id);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return pointtype;
    }

    public List<Point> findPointByTypeId(int id){
        return  findPointTypeById(id).getPointList();
    }


    public List<Point> findALLPoint(){
        List<Point> data=null;
        try {

            data = db.findAll(Point.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return data;
    }

}
