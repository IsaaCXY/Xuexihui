package huishiji.xuexihui.View;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import huishiji.xuexihui.Module.User;
import huishiji.xuexihui.Presenter.UserLoginPresenter;
import huishiji.xuexihui.R;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {

    private EditText input_nick, input_pass;
    private Button btn_login, btn_reset, btn_regist;
    private TextInputLayout NameInputCheck, PassInputCheck;
    private ProgressBar mProgress;
    private UserLoginPresenter mLoginPresenter = new UserLoginPresenter(this);
    private RadioGroup radioGroup;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        InitView();

        toolbar.setTitle("账户登录");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserLoginActivity.this.finish();
            }
        });
        input_nick.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                //TODO 对账户名进行检验
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                btn_login.setClickable(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    btn_login.setClickable(false);
                    PassInputCheck.setErrorEnabled(true);
                    PassInputCheck.setError("密码不能为空！");
                } else {
                    btn_login.setClickable(true);
                    PassInputCheck.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
//登陆按钮
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
                mLoginPresenter.login();

            }
        });
        //注册按钮
        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLoginActivity.this, UserRegistActivity.class);
                startActivity(intent);
            }
        });
        //重置按钮
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.clear();
            }
        });

    }

    private void InitView() {

        input_nick = (EditText) findViewById(R.id.edit_name);
        input_pass = (EditText) findViewById(R.id.edit_pass);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_regist = (Button) findViewById(R.id.btn_regist);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        NameInputCheck = (TextInputLayout) findViewById(R.id.textNameCheck);
        PassInputCheck = (TextInputLayout) findViewById(R.id.textPassCheck);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        toolbar=(Toolbar)findViewById(R.id.toolb_login);
    }

    @Override
    public String getSex() {
        RadioButton radioButton=(RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());

        return radioButton.getText().toString();
    }

    @Override
    public String getUserName() {
        return input_nick.getText().toString();
    }

    @Override
    public String getPassword() {
        return input_pass.getText().toString();
    }

    @Override
    public void clearUserName() {
        input_nick.setText("");
    }

    @Override
    public void clearPassword() {
        input_pass.setText("");
    }

    @Override
    public void showLoading() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void CloseCurrentActivity(User user) {
        this.finish();
        Toast.makeText(this,
                user.getSex()+":"+user.getNickname()+"登陆成功！",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "登陆失败！", Toast.LENGTH_SHORT).show();
    }

}
