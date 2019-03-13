package com.hk.expandablelistview.expandablelistview3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hk.expandablelistview.R;

import java.util.List;
import java.util.Map;

public class SonExpandableListViewAdapter extends BaseExpandableListAdapter {
    private List<SonViewEntity> sonViewEntities;

    public SonExpandableListViewAdapter(List<SonViewEntity> sonViewEntities, Context context) {
        this.sonViewEntities = sonViewEntities;
    }

    @Override
    public int getGroupCount() {
        return sonViewEntities.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return sonViewEntities.get(groupPosition).grandSonViewEntities.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return sonViewEntities.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return sonViewEntities.get(groupPosition).grandSonViewEntities.get(childPosition);
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
        grandpaViewHolder.textView1.setText(sonViewEntities.get(groupPosition).viewStr1);
        grandpaViewHolder.textView1.setText(sonViewEntities.get(groupPosition).viewStr2);
        grandpaViewHolder.textView1.setText(sonViewEntities.get(groupPosition).viewStr3);
        grandpaViewHolder.textView1.setText(sonViewEntities.get(groupPosition).viewStr4);
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
        sonViewHolder.textView1.setText(sonViewEntities.get(groupPosition).grandSonViewEntities.get(childPosition).viewStr1);
        sonViewHolder.textView1.setText(sonViewEntities.get(groupPosition).grandSonViewEntities.get(childPosition).viewStr2);
        sonViewHolder.textView1.setText(sonViewEntities.get(groupPosition).grandSonViewEntities.get(childPosition).viewStr3);
        sonViewHolder.textView1.setText(sonViewEntities.get(groupPosition).grandSonViewEntities.get(childPosition).viewStr4);
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
