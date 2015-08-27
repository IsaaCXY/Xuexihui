package huishiji.xuexihui.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import huishiji.xuexihui.View.f1;
import huishiji.xuexihui.View.f2;
import huishiji.xuexihui.View.f3;


public class MyPagerAdapter extends FragmentPagerAdapter {
private String[] title;
    public MyPagerAdapter(FragmentManager fm,String[] title) {
        super(fm);
        this.title=title;
    }

    @Override
    public Fragment getItem(int position) {
//        Fragment fragment=fragmentList.get(position);
        switch (position){
            case 0:
                f1 f1=new f1();
                return f1;
            case 1:
                f2 f2=new f2();
                return f2;
            case 2:
                f3 f3=new f3();
                return f3;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
