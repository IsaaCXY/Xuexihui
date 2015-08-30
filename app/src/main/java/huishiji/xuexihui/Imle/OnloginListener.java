package huishiji.xuexihui.Imle;

import huishiji.xuexihui.Module.User;


public interface OnloginListener {
    void LoginSuccess(User user);
    void LoginFailed();
}
