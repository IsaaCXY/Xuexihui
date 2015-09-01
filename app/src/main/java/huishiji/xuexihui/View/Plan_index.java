package huishiji.xuexihui.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.hxx.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/26.
 */
public class Plan_index extends Fragment{

    List xqlst1;
    ListView xqlst;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plan_frg_layout,container,false);

        //  dayplanlst1=(ListView)findViewById(R.id.dayplantlst);

        initday();
        xqlst=(ListView)view.findViewById(R.id.xqlst);
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,xqlst1);
        xqlst.setAdapter(adapter);
        xqlst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


        return view;
    }

    public void initday(){
        xqlst1=new ArrayList();
        xqlst1.add("星期一");
        xqlst1.add("星期二");
        xqlst1.add("星期三");
        xqlst1.add("星期四");
        xqlst1.add("星期五");


    }



}
