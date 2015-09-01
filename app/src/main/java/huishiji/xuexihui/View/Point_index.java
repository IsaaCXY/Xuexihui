package huishiji.xuexihui.View;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.administrator.hxx.R;
import com.example.administrator.hxx.dao.DBHelper;
import com.example.administrator.hxx.entity.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/26.
 */
public class Point_index extends Fragment{

    private Spinner spinner;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;
    TextView txtview;
    ListView listv;
    TextView point_textview;
    List<Point> pdata;
    DBHelper db;
    MyAdapterpoint adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.point_frg_layout,container,false);
        db = new DBHelper(getActivity());

        pdata = db.findPointByTypeId(1);
        if (pdata==null){

        }
        spinner = (Spinner) view.findViewById(R.id.Spinner);
        txtview =(TextView) view.findViewById(R.id.txt);
        listv = (ListView) view.findViewById(R.id.point_listview);


        //数据
        data_list = new ArrayList<String>();
        data_list.add("上周已学知识点");
        data_list.add("上周已掌握知识点");
        data_list.add("上周未掌握知识点");

        //适配器
        arr_adapter= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);

        //添加事件Spinner事件监听
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());

        return view;
    }

    //使用数组形式操作
    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView arg0, View arg1, int arg2,
                                   long arg3) {
            txtview.setText("你选择的是："+data_list.get(arg2));
            if (data_list.get(arg2).equals("上周已学知识点")){
                adapter =new  MyAdapterpoint(getActivity());
                listv.setAdapter(adapter);
            }else if (data_list.get(arg2).equals("上周已掌握知识点")){
                MyAdapterpoint2 adapter2 = new MyAdapterpoint2(getActivity());
                listv.setAdapter(adapter2);
            }else {
                MyAdapterpoint3 adapter3 = new MyAdapterpoint3(getActivity());
                listv.setAdapter(adapter3);
            }
        }
        public void onNothingSelected(AdapterView arg0) {
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public class MyAdapterpoint extends BaseAdapter{
        LayoutInflater inflater;
        Context context;
        public MyAdapterpoint(Context context){
            this.context = context;
            inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE );
        }

        @Override
        public int getCount() {
            return pdata.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View   view = inflater.inflate(R.layout.list_item_point,null);

            point_textview = (TextView)view.findViewById(R.id.point_textview);
            point_textview.setText(pdata.get(position).getContent());
            return view;
        }
    }

    public class MyAdapterpoint2 extends BaseAdapter{
        LayoutInflater inflater;
        Context context;
        public MyAdapterpoint2(Context context){
            this.context = context;
            inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE );
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View   view = inflater.inflate(R.layout.list_item_point,null);

            point_textview = (TextView)view.findViewById(R.id.point_textview);
            point_textview.setText(pdata.get(position).getContent());

            return view;
        }
    }

    public class MyAdapterpoint3 extends BaseAdapter{
        LayoutInflater inflater;
        Context context;
        public MyAdapterpoint3(Context context){
            this.context = context;
            inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE );
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View   view = inflater.inflate(R.layout.list_item_point,null);

            point_textview = (TextView)view.findViewById(R.id.point_textview);

                point_textview.setText(pdata.get(position+3).getContent());

            return view;
        }
    }

}
