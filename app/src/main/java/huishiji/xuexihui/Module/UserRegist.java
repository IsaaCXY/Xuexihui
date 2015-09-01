package huishiji.xuexihui.Module;

import android.content.Context;
import android.util.Log;

import huishiji.xuexihui.DB.DAO;
import huishiji.xuexihui.Imle.IUserRegist;
import huishiji.xuexihui.Imle.OnRegistListener;


public class UserRegist implements IUserRegist {
    int roleInt, sexInt;

    @Override
    public void regist(String nick,
                       String name,
                       String sex,
                       int age,
                       String phonenumber,
                       String qq_number,
                       int gradeNum,
                       int classNum,
                       String password,
                       String role,
                       OnRegistListener onRegistListener,
                       Context context) {


        roleInt = TransRole(role);
        sexInt = TransSex(sex);

        DAO dao = new DAO(context);
        try {
            long l = dao.addData(nick, name, sexInt, age,
                    phonenumber, qq_number, gradeNum, classNum,
                    password, roleInt);
            if (l >= 0) {
                onRegistListener.RegistSuccessfully();
            } else {
                onRegistListener.RegistFailed();
            }
            System.out.println("现在有" + l + "条数据！");
        } catch (Exception e) {
            e.printStackTrace();
            Log.w("数据库", "UserRegist发生错误！");
        }

    }

//通过得到的字符串来生成身份的int值

    private int TransRole(String role) {

        if (role.equals("老师")) {
            return 1;
        }
        return 0;

    }

    //通过得到的字符串来生成检验性别的int值
    private int TransSex(String sex) {
        if (sex.equals("男")) {
            return 1;
        }

        return 0;
    }
}

