package com.hk.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private ExpandableListViewAdapter expandAdapter;
    private List<Map<String, String>> parentMap;
    private List<Map<String, String>> childMap;
    private List<Map<String, String>> grandChildrenMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addData();
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.expand);
        expandAdapter = new ExpandableListViewAdapter(parentMap,childMap,grandChildrenMap);
        expandableListView.setAdapter(expandAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return true;
            }
        });

    }

    private void addData() {
        parentMap = new ArrayList<>();
        childMap = new ArrayList<>();
        grandChildrenMap = new  ArrayList<>();

        for(int i =0;i<5;i++){
            Map map = new HashMap();
            map.put("p1","父级1");
            map.put("p2","父级2");
            map.put("p3","父级3");
            map.put("p4","父级4");
            parentMap.add(map);

            Map map2 = new HashMap();
            map2.put("c1","子级1");
            map2.put("c2","子级2");
            map2.put("c3","子级3");
            map2.put("c4","子级4");
            childMap.add(map2);

            Map map3 = new HashMap();
            map3.put("p1","孙级1");
            map3.put("p2","孙级2");
            map3.put("p3","孙级3");
            map3.put("p4","孙级4");
            grandChildrenMap.add(map3);
        }

    }
}
