package com.hk.expandablelistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private List<Map<String,String>> parentMap;
    private List<Map<String,String>> childMap;
    private List<Map<String,String>> grandChildrenMap;

    public ExpandableListViewAdapter(List<Map<String,String>> parentMap, List<Map<String,String>> childMap, List<Map<String,String>> grandChildrenMap) {
        this.parentMap = parentMap;
        this.childMap = childMap;
        this.grandChildrenMap = grandChildrenMap;
    }

    @Override
    public int getGroupCount() {
        return parentMap.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childMap.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentMap.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childMap.get(childPosition);
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
        GroupViewHolder groupViewHolder ;
        if(convertView == null){
            convertView = LinearLayout.inflate(parent.getContext(),R.layout.parent_item,null);
        }
        return null;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

   static class GroupViewHolder{
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
   }
   static class ParentHolder{
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
   }

}
