package huishiji.xuexihui.DB;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String dbname = "xxhdb";
    private static final int version = 1;

    public DatabaseHelper(Context context) {
        super(context, dbname, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT " +
                "EXISTS  stu(" +
                "personid interger primary key," +
                "nickname varchar(20)," +
                "name varchar(20)," +
                "sex int," +
                "age int," +
                "phone_number varchar(20)," +
                "qq_number varchar(20)," +
                "gradeNum int," +
                "classNum int," +
                "password varchar (50)," +
                "role int" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO
    }
}
