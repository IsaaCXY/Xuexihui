package com.example.administrator.huixuexiapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.huixuexiapp.dao.DbHelper;
import com.example.administrator.huixuexiapp.entity.ChengZhangRecord;

import java.util.List;
import java.util.zip.Inflater;

public class ChengZhangHuiActivity extends Activity {

    TextView  headerTxt1;
    TextView headerTxt2;
    ImageView  headerImg3;
    Button btnGlory;
    Button btnSecret;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheng_zhang_hui);
        listView=(ListView)findViewById(R.id.record_listView);
        headerTxt1=(TextView)findViewById(R.id.header_txt1);
        headerTxt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("android.intent.action.FANHUIMAIN");
                startActivity(intent);
            }
        });
        MyListAdapter adapter=new MyListAdapter(this);
        listView.setAdapter(adapter);
        headerImg3=(ImageView)findViewById(R.id.header_img3);

        headerImg3.setOnClickListener(new ImageView.OnClickListener(){
            public void onClick(View view){
                    Intent intent=new Intent(ChengZhangHuiActivity.this,SomeButtonActivity.class);
                    startActivity(intent);
            }

        });
    }
    //为listView指定的自定义适配器
    public class MyListAdapter extends BaseAdapter{
        List<ChengZhangRecord> list=null;
        LayoutInflater inflater;
        public MyListAdapter(Context context){
            inflater= LayoutInflater.from(context);
            list=loadData(context);
        }
        public List<ChengZhangRecord> loadData(Context context){
            DbHelper db= DbHelper.newInstanse(context);
            list=db.findAllCZR();

            return list;
        }
        @Override
        public Object getItem(int position) {
            return list.get(position) ;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        //定义一个类封装record，要显示的内容
         class RecordHolder{
            TextView linetxt1;
            TextView lineimg1;
            TextView txt1;
            ImageView img1;
            TextView txt2;
            ImageView img2;
         }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.i("test","进入chengzhangactivity的getView");
            if(convertView==null){
                convertView=inflater.inflate(R.layout.line_item,null);
                RecordHolder recordHolder=new RecordHolder();
                recordHolder.linetxt1=(TextView)convertView.findViewById(R.id.linetxt1);
                recordHolder.txt1=(TextView)convertView.findViewById(R.id.txt1);
                recordHolder.txt2=(TextView)convertView.findViewById(R.id.txt2);
                //recordHolder.lineimg1=(TextView)convertView.findViewById(R.id.linetxt2);
                recordHolder.img1=(ImageView)convertView.findViewById(R.id.img1);
                recordHolder.img2=(ImageView)convertView.findViewById(R.id.img2);

                convertView.setTag(recordHolder);
            }
            //往容器里面放值
            final ChengZhangRecord czr=(ChengZhangRecord)getItem(position);
            final  RecordHolder rh=(RecordHolder)convertView.getTag();
            //从数据库查询出的图片该怎么显示
            String xx=czr.getCzh_create_time();
            rh.linetxt1.setText(" "+xx);

            rh.txt1.setText(" " + czr.getCzh_content());
            rh.txt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChengZhangHuiActivity.this, DORecordActivity.class);
                    intent.putExtra("headerMessage", "用户名");
                    intent.putExtra("mainMessage", " "+czr.getCzh_content());
                    intent.putExtra("gloryMessage", " " );
                    startActivity(intent);
                }
            });
            rh.txt2.setText(" " + czr.getCzh_glory_content());
            rh.txt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChengZhangHuiActivity.this, DORecordActivity.class);
                    intent.putExtra("headerMessage", "用户名");
                    intent.putExtra("gloryMessage", " " + czr.getCzh_glory_content());
                    intent.putExtra("mainMessage", " ");
                    startActivity(intent);
                }
            });
           // rh.lineimg1=czr.
            return convertView;
        }
    }
}
