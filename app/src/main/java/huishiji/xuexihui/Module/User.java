package huishiji.xuexihui.Module;

/**
 * Created by lenovo on 2015/8/27.
 */
public class User {
    private String name;
    private String nickname;
    private String password;
    private String sex;
    private int phoneNumber;
    private int QQnumber;
    private int age;
    private int gradeNumber;
    private int classNumber;
    private int role;


    public User(String sex) {
        this.sex = sex;
    }

    public int setRole(int role) {
        return this.role = role;
    }

    public int getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getQQnumber() {
        return QQnumber;
    }

    public void setQQnumber(int QQnumber) {
        this.QQnumber = QQnumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(int gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }
}
