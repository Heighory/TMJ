package com.tmj.myadapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2015/11/12.
 */
public class ListView_5 extends Activity {
    private ListView my_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_5);
        my_adapter = (ListView) this.findViewById(R.id.my_adapter);
        /**
         * 准备数据源
         * */
        List<HashMap<String, Object>> lists = new ArrayList<HashMap<String, Object>>();
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

        my_adapter.setAdapter(new MyBaseAdapter(this, lists));
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
            HashMap<String, Object> map = myList.get(position);
            //由于每一项的convertView会在滑动时就已经创建，所以需要重复创建converView对象。
            if(convertView == null){
                convertView = mInflater.inflate(R.layout.my_base_item, null);
            }
            ImageView headImage = (ImageView) convertView.findViewById(R.id.item_1);
            TextView tv = (TextView) convertView.findViewById(R.id.item_2);
            headImage.setImageResource((Integer) map.get("map"));
            tv.setText(map.get("name")+"");
            return convertView;
        }
    }
}
