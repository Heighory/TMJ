package com.tmj.myadapter;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * ArrayAdapter只能实现纯文字的排列。
 * */
public class ListView_1 extends Activity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_1);
        listView = (ListView) this.findViewById(R.id.listView);
        Resources res = getResources();
        String[] strings = res.getStringArray(R.array.string_array_name);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, strings);
        listView.setAdapter(adapter);
    }
}
