package huishiji.xuexihui.View;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import huishiji.xuexihui.Presenter.UserRegistPresenter;
import huishiji.xuexihui.R;

public class UserRegistActivity extends AppCompatActivity
        implements IUserRegisView {
    Toolbar toolbar;
    private Button btn_sub, btn_cancel;
    private UserRegistPresenter userRegistPresenter = new UserRegistPresenter(this);
    private RadioGroup radioSex, radioRole;
    private TextInputLayout regName, regNick,
            regAge, regGrade, regClass, regPhone,
            regQQ, regPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_regist);

        InitView();

        toolbar.setTitle("信息注册");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nick = regNick.getEditText().getText().length(),
                        name = regName.getEditText().getText().length(),
                        age = regAge.getEditText().getText().length(),
                        grade = regGrade.getEditText().getText().length(),
                        clas = regClass.getEditText().getText().length(),
                        phone = regPhone.getEditText().getText().length(),
                        qq = regQQ.getEditText().getText().length(),
                        pass = regPass.getEditText().getText().length();

                if (nick == 0 || name == 0 || age == 0
                        || grade == 0 || clas == 0 ||
                        phone == 0 || qq == 0 || pass == 0) {
                    Toast.makeText(UserRegistActivity.this, "每一个项目都要填满！",
                            Toast.LENGTH_SHORT).show();
                } else {
                    userRegistPresenter.regist();
                }

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    //初始化控件
    private void InitView() {
        btn_sub = (Button) findViewById(R.id.regist_btn_sub);
        btn_cancel = (Button) findViewById(R.id.regist_btn_cancel);
        regNick = (TextInputLayout) findViewById(R.id.reg_nick);
        regName = (TextInputLayout) findViewById(R.id.reg_name);
        regAge = (TextInputLayout) findViewById(R.id.reg_age);
        regGrade = (TextInputLayout) findViewById(R.id.reg_grade);
        regClass = (TextInputLayout) findViewById(R.id.reg_clas);
        regPhone = (TextInputLayout) findViewById(R.id.reg_phone);
        regQQ = (TextInputLayout) findViewById(R.id.reg_qq);
        regPass = (TextInputLayout) findViewById(R.id.reg_pass);
        radioRole = (RadioGroup) findViewById(R.id.reg_role);
        radioSex = (RadioGroup) findViewById(R.id.reg_sex);
        toolbar = (Toolbar) findViewById(R.id.toolb_regist);
    }

    @Override
    public void cancel() {
        this.finish();
    }

    @Override
    public void showSuccessfull() {
        this.finish();
        Toast.makeText(this, "成功注册！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "注册失败！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getName() {
        return regName.getEditText().getText().toString();
    }

    @Override
    public String getRole() {
        RadioButton radioButton
                = (RadioButton) findViewById(radioRole.getCheckedRadioButtonId());
        return radioButton.getText().toString();
    }

    @Override
    public String getNickname() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getSex() {
        RadioButton radioButton
                = (RadioButton) findViewById(radioSex.getCheckedRadioButtonId());
        return radioButton.getText().toString();
    }

    @Override
    public String getPhoneNumber() {
        return regPhone.getEditText().getText().toString();
    }

    @Override
    public String getQQnumber() {
        return regQQ.getEditText().getText().toString();
    }

    @Override
    public int getClassNumber() {
        return Integer.parseInt(regClass.getEditText().getText().toString());
    }

    @Override
    public int getGradeNumber() {
        return Integer.parseInt(regGrade.getEditText().getText().toString());
    }

    @Override
    public int getAge() {
        return Integer.parseInt(regAge.getEditText().getText().toString());
    }

}
