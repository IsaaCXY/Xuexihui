package huishiji.xuexihui.View;

/**
 * Created by lenovo on 2015/8/29.
 */
public interface IUserRegisView {
    void cancel();

    void showSuccessfull();

    void showFailedError();

    String getRole();

    String getName();

    String getNickname();

    String getPassword();

    String getSex();

    String getPhoneNumber();

    String getQQnumber();

    int getAge();

    int getGradeNumber();

    int getClassNumber();
}

