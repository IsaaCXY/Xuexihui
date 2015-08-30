package huishiji.xuexihui.Presenter;


import android.os.Handler;

import huishiji.xuexihui.Imle.IUserLogin;
import huishiji.xuexihui.Imle.OnloginListener;
import huishiji.xuexihui.Module.UserLogin;
import huishiji.xuexihui.Module.User;
import huishiji.xuexihui.View.IUserLoginView;


public class UserLoginPresenter {
    private IUserLogin userLogin;//MODEL
    private IUserLoginView loginView;//VIEW
    private android.os.Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView loginView) {
        this.loginView = loginView;
        this.userLogin = new UserLogin();
    }

    public void login() {
        userLogin.login(loginView.getUserName(), loginView.getPassword(),
                loginView.getSex(),
                new OnloginListener() {
                    @Override
                    public void LoginSuccess(final User user) {
                        //在UI线程中执行
                        mHandler.post(new Runnable() {

                            @Override
                            public void run() {
                                loginView.hideLoading();
                                loginView.CloseCurrentActivity(user);
                            }
                        });
                    }

                    @Override
                    public void LoginFailed() {

                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                loginView.showFailedError();
                                loginView.hideLoading();
                            }
                        });
                    }
                });
    }

    public void clear() {
        loginView.clearPassword();
        loginView.clearUserName();
    }
}
