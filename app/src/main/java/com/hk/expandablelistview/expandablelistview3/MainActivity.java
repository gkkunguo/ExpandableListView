package com.hk.expandablelistview.expandablelistview3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.hk.expandablelistview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<GrandpaViewEntity> grandpaViewEntitys;
    private List<SonViewEntity> sonViewEntitys;
    private List<GrandSonViewEntity> grandSonViewEntitys;
    private GrandpaViewEntity grandpaViewEntity;
    private SonViewEntity sonViewEntity;
    private GrandSonViewEntity grandSonViewEntity;
    private ExpandableListView expandableListView;
    private GrandpaExpandableListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        expandableListView = findViewById(R.id.expand);
        adapter = new GrandpaExpandableListViewAdapter(grandpaViewEntitys,this);
        expandableListView.setAdapter(adapter);

    }

    private void initData() {
        grandpaViewEntitys = new ArrayList<>();
        sonViewEntitys = new ArrayList<>();
        grandSonViewEntitys = new ArrayList<>();
        for(int i = 0;i<4;i++){
            grandpaViewEntity = new GrandpaViewEntity();
            grandpaViewEntity.viewStr1 = "爷"+(i+1);
            grandpaViewEntity.viewStr2 = "爷"+(i+1);
            grandpaViewEntity.viewStr3 = "爷"+(i+1);
            grandpaViewEntity.viewStr4 = "爷"+(i+1);
            for (int j = 0;j<4;j++){
                sonViewEntity = new SonViewEntity();
                sonViewEntity.viewStr1 = "子"+(j+1);
                sonViewEntity.viewStr2 = "子"+(j+1);
                sonViewEntity.viewStr3 = "子"+(j+1);
                sonViewEntity.viewStr4 = "子"+(j+1);
                for(int z = 0;z<4;z++){
                    grandSonViewEntity = new GrandSonViewEntity();
                    grandSonViewEntity.viewStr1 = "孙"+(z+1);
                    grandSonViewEntity.viewStr2 = "孙"+(z+1);
                    grandSonViewEntity.viewStr3 = "孙"+(z+1);
                    grandSonViewEntity.viewStr4 = "孙"+(z+1);
                    grandSonViewEntitys.add(grandSonViewEntity);
                }
                sonViewEntity.grandSonViewEntities = grandSonViewEntitys;
                sonViewEntitys.add(sonViewEntity);
            }
            grandpaViewEntity.sonViewEntities = sonViewEntitys;
            grandpaViewEntitys.add(grandpaViewEntity);
        }

    }

}
