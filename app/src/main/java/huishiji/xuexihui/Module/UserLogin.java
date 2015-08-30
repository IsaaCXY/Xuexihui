package huishiji.xuexihui.Module;

import android.util.Log;

import huishiji.xuexihui.Imle.IUserLogin;
import huishiji.xuexihui.Imle.OnloginListener;


public class UserLogin implements IUserLogin {
    @Override
    public void login(final String nickname,
                      final String password,
                      final String sex,
                      final OnloginListener loginlistener) {
        //模拟耗时线程，比如网络连接
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.e("tag","发生在UserLogin中的错误！");
                }
                //登陆成功的检验,TODO 加入和数据库的检验
                if ("cxy".equals(nickname) && "123".equals(password))
                {
                    User user = new User(sex);
                    user.setNickname(nickname);
                    user.setPassword(password);
                    loginlistener.LoginSuccess(user);
                } else
                {
                    loginlistener.LoginFailed();
                }
            }
        }.start();
    }

}
