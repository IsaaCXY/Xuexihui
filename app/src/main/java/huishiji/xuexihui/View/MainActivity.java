package huishiji.xuexihui.View;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import huishiji.xuexihui.Adapter.MyPagerAdapter;
import huishiji.xuexihui.R;

public class MainActivity extends FragmentActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    public ActionBarDrawerToggle mDrawerToggle;
    private TabLayout tabLayout;
    private ViewPager pager;
    private String[] tabTitle = {"测评汇", "学习汇", "成长汇", "社区汇"};
//    List<Fragment>fragmentList=new ArrayList<>();
//    f1 f1;
//    f2 f2;
//    f3 f3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        InitView();
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setSubtitleTextColor(Color.parseColor("#BBDEFB"));

        toolbar.setTitle("汇学习");
        toolbar.setSubtitle("测评汇");
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
            //TODO 加入一些滑动监听
        };

        mDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mDrawerToggle);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);//滑动模式

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),
                tabTitle);

        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);


//TAB选择监听器
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                toolbar.setSubtitle(tab.getText());
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//导航侧滑栏的监听器
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.login:
                        Intent intent = new Intent(MainActivity.this, UserLoginActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.out:
                        intent = new Intent(MainActivity.this, UserRegistActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.fullmoney:
                        intent=new Intent(MainActivity.this,HuiJiaMengActivity.class);
                        startActivity(intent);
                        break;
                }
                return false;
            }
        });
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    private void InitView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.left_navi);
        toolbar = (Toolbar) findViewById(R.id.toolB);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
    }
}
