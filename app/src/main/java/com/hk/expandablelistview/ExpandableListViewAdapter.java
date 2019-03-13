package com.hk.expandablelistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private List<Map<String,String>> grandpaMap;
    private List<Map<String,String>> sonMap;
    private List<Map<String,String>> grandsonMap;

    public ExpandableListViewAdapter(List<Map<String,String>> grandpaMap, List<Map<String,String>> sonMap, List<Map<String,String>> grandsonMap) {
        this.grandpaMap = grandpaMap;
        this.sonMap = sonMap;
        this.grandsonMap = grandsonMap;
    }

    @Override
    public int getGroupCount() {
        return grandpaMap.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return sonMap.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return grandpaMap.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return sonMap.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GrandpaViewHolder grandpaViewHolder;
        if(convertView == null){
            convertView = LinearLayout.inflate(parent.getContext(),R.layout.grandpa_item,null);
            grandpaViewHolder = new GrandpaViewHolder();
            grandpaViewHolder.textView1 = convertView.findViewById(R.id.tv1);
            grandpaViewHolder.textView2 = convertView.findViewById(R.id.tv2);
            grandpaViewHolder.textView3 = convertView.findViewById(R.id.tv3);
            grandpaViewHolder.textView4 = convertView.findViewById(R.id.tv4);
            convertView.setTag(grandpaViewHolder);
        }else {
            grandpaViewHolder = (GrandpaViewHolder) convertView.getTag();
        }
        grandpaViewHolder.textView1.setText(grandpaMap.get(groupPosition).get("p1"));
        grandpaViewHolder.textView2.setText(grandpaMap.get(groupPosition).get("p2"));
        grandpaViewHolder.textView3.setText(grandpaMap.get(groupPosition).get("p3"));
        grandpaViewHolder.textView4.setText(grandpaMap.get(groupPosition).get("p4"));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SonViewHolder sonViewHolder;
        if(convertView == null){
            convertView = LinearLayout.inflate(parent.getContext(),R.layout.son_item,null);
            sonViewHolder = new SonViewHolder();
            sonViewHolder.textView1 = convertView.findViewById(R.id.tv1);
            sonViewHolder.textView2 = convertView.findViewById(R.id.tv2);
            sonViewHolder.textView3 = convertView.findViewById(R.id.tv3);
            sonViewHolder.textView4 = convertView.findViewById(R.id.tv4);
            convertView.setTag(sonViewHolder);
        }else {
            sonViewHolder = (SonViewHolder) convertView.getTag();
        }
        sonViewHolder.textView1.setText(sonMap.get(groupPosition).get("c1"));
        sonViewHolder.textView2.setText(sonMap.get(groupPosition).get("c2"));
        sonViewHolder.textView3.setText(sonMap.get(groupPosition).get("c3"));
        sonViewHolder.textView4.setText(sonMap.get(groupPosition).get("c4"));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    //祖
   static class GrandpaViewHolder{
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
   }
   //儿
   static class SonViewHolder{
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
   }
   //孙
   static class ParentViewHolder{
       TextView textView1;
       TextView textView2;
       TextView textView3;
       TextView textView4;
   }
}
