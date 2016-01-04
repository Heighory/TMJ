package com.tmj.myadapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * Created by Administrator on 2015/11/10.
 */
public class ListView_3 extends Activity {
    private ListView my_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_3);
        my_adapter = (ListView) this.findViewById(R.id.my_adapter);
        my_adapter.setAdapter(new MyBaseAdapter(this));
    }

    class MyBaseAdapter extends BaseAdapter {
        private Context context;
        public MyBaseAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 10;
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
            TextView mTextView = new TextView(context);
            mTextView.setText("BaseAdapterDemo" + position);
            mTextView.setTextColor(Color.RED);
            return mTextView;
        }
    }
}
