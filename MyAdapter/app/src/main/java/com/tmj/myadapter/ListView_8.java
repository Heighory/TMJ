package com.tmj.myadapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2015/11/12.
 */
public class ListView_8 extends Activity {
    private ListView my_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_8);
        my_adapter = (ListView) this.findViewById(R.id.my_adapter);
        /**
         * 准备数据源
         * */
        final List<HashMap<String, Object>> lists = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map_1 = new HashMap<String, Object>();
        map_1.put("map", R.drawable.jzm);
        map_1.put("name", "江泽民");

        HashMap<String, Object> map_2 = new HashMap<String, Object>();
        map_2.put("map", R.drawable.zrj);
        map_2.put("name", "朱镕基");

        HashMap<String, Object> map_3 = new HashMap<String, Object>();
        map_3.put("map", R.drawable.wjb);
        map_3.put("name", "温加宝");

        lists.add(map_1);
        lists.add(map_2);
        lists.add(map_3);
        final MyBaseAdapter adapter = new MyBaseAdapter(this, lists);
        my_adapter.setAdapter(adapter);

        my_adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) lists.get(position).get("name");
                Toast.makeText(ListView_8.this, name, Toast.LENGTH_LONG).show();
            }
        });

        my_adapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) lists.get(position).get("name");
                Toast.makeText(ListView_8.this, name + "=====", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    class MyBaseAdapter extends BaseAdapter {
        LayoutInflater mInflater;  //得到一个LayoutInfalter对象用来导入布局
        List<HashMap<String, Object>> myList;
        public MyBaseAdapter(Context context, List<HashMap<String, Object>> lists) {
            //this.mInflater = LayoutInflater.from(context);
            this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.myList = lists;
        }

        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Object getItem(int position) {
            return myList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            HashMap<String, Object> map = myList.get(position);
            if(convertView == null){
                viewHolder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.my_base_item, null);
                viewHolder.headImage = (ImageView) convertView.findViewById(R.id.item_1);
                viewHolder.tv = (TextView) convertView.findViewById(R.id.item_2);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            if(map != null){
                viewHolder.headImage.setImageResource((Integer) map.get("map"));
                viewHolder.tv.setText(map.get("name")+"");
            }
            return convertView;
        }

        class ViewHolder{
            ImageView headImage;
            TextView tv;
        }
    }
}

