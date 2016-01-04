package com.tmj.myadapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/11/9.
 * 图文混排的SimpleAdapter
 */
public class ListView_2 extends Activity {
    private ListView list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_2);
        list_view = (ListView) this.findViewById(R.id.list_view);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> obj_1 = new HashMap<String, Object>();
        obj_1.put("name", "江泽民");
        obj_1.put("position", "国家主席");
        obj_1.put("head", R.drawable.jzm);

        Map<String, Object> obj_2 = new HashMap<String, Object>();
        obj_2.put("name", "朱镕基");
        obj_2.put("position", "国务总理");
        obj_2.put("head", R.drawable.zrj);

        Map<String, Object> obj_3 = new HashMap<String, Object>();
        obj_3.put("name", "温加宝");
        obj_3.put("position", "国务总理");
        obj_3.put("head", R.drawable.wjb);

        list.add(obj_1);
        list.add(obj_2);
        list.add(obj_3);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                list, R.layout.perison_item,
                new String[]{"name","position","head"},
                new int[]{R.id.name, R.id.position, R.id.head});

        list_view.setAdapter(simpleAdapter);
    }
}
