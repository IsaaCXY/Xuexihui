package huishiji.xuexihui.Imle;


public interface IUserLogin {
     void login(String nickname,
                String password,
                String sex,
                OnloginListener onloginListener);
}
