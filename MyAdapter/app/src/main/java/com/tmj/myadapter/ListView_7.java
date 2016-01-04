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
public class ListView_7 extends Activity {
    private ListView my_adapter;
    private TextView addItem, delItem, updateItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_7);
        my_adapter = (ListView) this.findViewById(R.id.my_adapter);
        addItem = (TextView) this.findViewById(R.id.addItem);
        delItem = (TextView) this.findViewById(R.id.delItem);
        updateItem = (TextView) this.findViewById(R.id.updateItem);
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
        final MyBaseAdapter adapter = new MyBaseAdapter(this, lists);
        my_adapter.setAdapter(adapter);

        //动态添加数据
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("map", R.drawable.lkq);
                map.put("name", "李克强");
                adapter.addItem(map);
                adapter.notifyDataSetChanged(); //更新列表
            }
        });

        //动态删除数据
        delItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.delItem(0);
                adapter.notifyDataSetChanged(); //更新列表
            }
        });

        //动态更新数据
        updateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("map", R.drawable.lkq);
                map.put("name", "李克强");
                adapter.updateItem(0, map);
                adapter.notifyDataSetChanged(); //更新列表
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

        /**
         * 添加数据项
         * */
        public void addItem(HashMap<String, Object> map){
            myList.add(map);
        }

        /**
         * 删除数据项
         * */
        public void delItem(int positon){
            myList.remove(positon);
        }

        /**
         * 更新数据项
         * */
        public void updateItem(int postion, HashMap<String, Object> map){
            myList.remove(postion);
            myList.add(postion, map);
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

