package huishiji.xuexihui.Presenter;

import android.content.Context;

import huishiji.xuexihui.Imle.IUserRegist;
import huishiji.xuexihui.Imle.OnRegistListener;
import huishiji.xuexihui.Module.UserRegist;
import huishiji.xuexihui.View.IUserRegisView;


public class UserRegistPresenter {
    IUserRegist userRegist;
    IUserRegisView userRegisView;

    public UserRegistPresenter(IUserRegisView userRegisView) {
        this.userRegisView = userRegisView;
        userRegist = new UserRegist();
    }

    public void regist(Context context) {

        userRegist.regist(userRegisView.getNickname(), userRegisView.getName(),
                userRegisView.getSex(), userRegisView.getAge(), userRegisView.getPhoneNumber(),
                userRegisView.getQQnumber(), userRegisView.getGradeNumber(), userRegisView.getClassNumber(),
                userRegisView.getPassword(), userRegisView.getRole(), new OnRegistListener() {
                    @Override
                    public void RegistSuccessfully() {
                        userRegisView.showSuccessfull();
                    }

                    @Override
                    public void RegistFailed() {

                        userRegisView.showFailedError();
                    }
                },context);
    }
}
