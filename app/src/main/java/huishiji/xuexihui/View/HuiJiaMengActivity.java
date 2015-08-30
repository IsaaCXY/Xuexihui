package huishiji.xuexihui.View;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import huishiji.xuexihui.R;

public class HuiJiaMengActivity extends AppCompatActivity {

    int ids[] = {R.drawable.one, R.drawable.two, R.drawable.three};
    Button join;
    PopupWindow pop;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hui_jia_meng);
        toolbar=(Toolbar)findViewById(R.id.toolb_jiameng);
        toolbar.setTitle("项目详情");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        initImage();
        initPopupWindow();
        initBtnAttribute();
    }
    private void initBtnAttribute() {
        join= (Button) findViewById(R.id.btn_join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pop.isShowing()) {
                    pop.dismiss();
                    return;
                } else {
                    pop.showAsDropDown(v, 0, -400);
                }
            }
        });
    }

    private void initImage() {
        LinearLayout content = (LinearLayout) findViewById(R.id.content);
        for (int i : ids) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(i);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            content.addView(imageView);
        }
    }

    private void initPopupWindow() {
        View content = getLayoutInflater().inflate(R.layout.popup_window, null);
        pop = new PopupWindow(content, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setOutsideTouchable(true);
        pop.setBackgroundDrawable(new BitmapDrawable());
    }

    @Override
    public void onBackPressed() {
        if(pop.isShowing()) {
            pop.dismiss();
            return;
        }
        super.onBackPressed();
    }
}
