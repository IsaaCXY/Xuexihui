package huishiji.xuexihui.View;

import huishiji.xuexihui.Module.User;

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    String getSex();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void CloseCurrentActivity(User user);

    void showFailedError();

}
