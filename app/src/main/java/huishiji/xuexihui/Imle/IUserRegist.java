package huishiji.xuexihui.Imle;


public interface IUserRegist {
    void regist(String nick, String name, String sex, int age, String phonenumber,
                String qq_number, int gradeNum, int classNum, String password,
                String role,OnRegistListener onRegistListener);
}
