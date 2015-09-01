package huishiji.xuexihui.View;




import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.hxx.R;
import com.example.administrator.hxx.dao.DBHelper;
import com.example.administrator.hxx.entity.Point;
import com.example.administrator.hxx.entity.PointType;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by Administrator on 2015/8/26.
 */
public class Stu_index extends Fragment  {

    RadioGroup rg;
    ListView list;
    ImageView imgback;
    TextView xxZsdTxt;


    List<PointType> data;
    List<Point> pdata;
    private MypointAdapter mAdapter;
    DBHelper db;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.stu_frg_layout,container,false);


            rg = (RadioGroup)view.findViewById(R.id.rg);
            imgback = (ImageView)view.findViewById(R.id.imgback);
            xxZsdTxt = (TextView)view.findViewById(R.id.xxZsdTxt);
            list = (ListView)view.findViewById(R.id.zsdlist);


            db = new DBHelper(getActivity());
            data =  db.finfAllPointType();

        //获得科目
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override//选项变化时执行
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) view.findViewById(checkedId);
                String value = rb.getText().toString();
                xxZsdTxt.setText(value + "知识点总结");
                if (value.equals("语文")) {
                    MythreeAdapter tAdapter = new MythreeAdapter(getActivity());
                    list.setAdapter(tAdapter);
                } else if (value.equals("数学")) {
                    mAdapter = new MypointAdapter(getActivity());
                    list.setAdapter(mAdapter);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            pdata = db.findPointByTypeId(position + 1);
                            MytwoAdapter adapter2;
                            adapter2 = new MytwoAdapter(getActivity());
                            ListView listView = (ListView) view.findViewById(R.id.two_listview);
                            listView.setAdapter(adapter2);
                            mAdapter.changeImageVisable(view, position);
                        }
                    });
                } else {
                    MythreeAdapter tAdapter = new MythreeAdapter(getActivity());
                    list.setAdapter(tAdapter);
                }
            }
        });


        return view;
    }







    public class MypointAdapter extends BaseAdapter {
        private Context mContext;
        private View mLastView;
        private int mLastPosition;
        private int mLastVisibility;
        //MytwoAdapter adapter2;
        public MypointAdapter(Context context){
            this.mContext = context;
            mLastPosition = -1;
            // adapter2 = new MytwoAdapter(MainActivity.this);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Holder holder;
            if(convertView == null ) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(R.layout.list_item, null);
                holder =new Holder();
                holder.textView = (TextView)convertView.findViewById(R.id.textView);
                holder.listView = (ListView)convertView.findViewById(R.id.two_listview);
                holder.hint = convertView.findViewById(R.id.hint_image);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            if(mLastPosition == position){
                holder.hint.setVisibility(mLastVisibility);
            }else{
                holder.hint.setVisibility(View.GONE);
            }
            holder.textView.setText("第"+(position+1)+"章" +data.get(position).getTypeName() );
            return convertView;
        }

        class Holder {
            TextView textView;
            ListView listView;
            View hint;
        }
        public void changeImageVisable(View view,int position) {

            if(mLastView != null && mLastPosition != position ) {
                Holder holder = (Holder) mLastView.getTag();
                switch(holder.hint.getVisibility()) {
                    case View.VISIBLE:
                        holder.hint.setVisibility(View.GONE);
                        mLastVisibility = View.GONE;
                        break;
                    default :
                        break;
                }
            }
            mLastPosition = position;
            mLastView = view;
            Holder holder = (Holder) view.getTag();
            switch(holder.hint.getVisibility()) {
                case View.GONE:
                    holder.hint.setVisibility(View.VISIBLE);
                    mLastVisibility = View.VISIBLE;
                    break;
                case View.VISIBLE:
                    holder.hint.setVisibility(View.GONE);
                    mLastVisibility = View.GONE;
                    break;
            }
        }
    }
    //数学知识点
    public class MytwoAdapter extends BaseAdapter{
        LayoutInflater inflater;
        Context context;
        public MytwoAdapter(Context context){
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
            View  view = inflater.inflate(R.layout.list_item2,null);
            TextView txtview = (TextView)view.findViewById(R.id.two_textview);
            txtview.setText(pdata.get(position).getContent());
            return view;
        }
    }
    //语文
    public class MythreeAdapter extends BaseAdapter{
        LayoutInflater inflater;
        Context context;
        public MythreeAdapter(Context context){
            this.context = context;
            inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE );
        }
        @Override
        public int getCount() {
            return 1;
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
            View   view = inflater.inflate(R.layout.list_item1,null);
            return view;
        }
    }


}
