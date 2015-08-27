package huishiji.xuexihui;

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
public class MainActivity extends FragmentActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle mDrawerToggle;
    TabLayout tabLayout;
    ViewPager pager;
    String[] tabTitle={"1","2","3"};
//    List<Fragment>fragmentList=new ArrayList<>();
//    f1 f1;
//    f2 f2;
//    f3 f3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fragmentList.add(0, f1);
//        fragmentList.add(1, f2);
//        fragmentList.add(2, f3);

        InitView();
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setSubtitleTextColor(Color.parseColor("#BBDEFB"));

        toolbar.setTitle("学习汇");
        toolbar.setSubtitle("测评汇");
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close){
        //TODO 加入一些滑动监听
        };

        mDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mDrawerToggle);
//添加tab
        tabLayout.addTab(tabLayout.newTab().setText("测评汇"));
        tabLayout.addTab(tabLayout.newTab().setText("学习汇"));
        tabLayout.addTab(tabLayout.newTab().setText("成长汇"));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);//滑动模式

        MyPagerAdapter adapter=new MyPagerAdapter(getSupportFragmentManager(),tabTitle);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
//        tabLayout.setTabsFromPagerAdapter(adapter);


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
                switch (menuItem.getItemId()){
                    case R.id.login:
                        drawerLayout.closeDrawer(navigationView);
                        break;
                    case R.id.out:
                        drawerLayout.closeDrawer(navigationView);
                        break;
                }
                return false;
            }
        });
//        tabLayout.setupWithViewPager(pager);
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
        tabLayout=(TabLayout)findViewById(R.id.tabs);
        pager=(ViewPager)findViewById(R.id.pager);
    }
}
