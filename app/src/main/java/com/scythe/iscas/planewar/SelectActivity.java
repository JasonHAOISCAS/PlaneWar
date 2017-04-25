package com.scythe.iscas.planewar;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.scythe.iscas.planewar.R;
import com.scythe.iscas.planewar.planewar.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by iscas on 2017/4/25.
 */

public class SelectActivity extends ListActivity {
    private String[] names = new String[]{"Game1","Game2","Game3"};
    private String[] descs = new String[]{"飞机大战","来日再战","来日再战"};
    private int[] imageIds = new int[]{R.drawable.red_boll,R.drawable.gray_boll,R.drawable.gray_boll};
    private Intent[] activities = null;
    @Override
    public void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for(int i = 0; i < names.length; i++)
        {
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("header",imageIds[i]);
            listItem.put("name",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }
        activities = new Intent[]{new Intent(getApplicationContext(),MainActivity.class),
                new Intent(getApplicationContext(), SorryActivity.class),
                new Intent(getApplicationContext(), SorryActivity.class)};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.select_item,
                new String[]{"header","name","desc"},
                new int[]{R.id.header,R.id.name,R.id.desc});
        this.setListAdapter(simpleAdapter);
    }
    @Override
    public void onListItemClick(ListView parent, View v, int position, long id)
    {
        startActivity(activities[position]);
    }
}
