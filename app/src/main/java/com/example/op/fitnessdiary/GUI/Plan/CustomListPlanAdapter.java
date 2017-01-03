package com.example.op.fitnessdiary.GUI.Plan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.op.fitnessdiary.R;

import java.util.ArrayList;

/**
 * Created by OP on 12/26/2016.
 */

public class CustomListPlanAdapter extends BaseAdapter {
    private ArrayList<DetailDay> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListPlanAdapter(Context aContext, ArrayList<DetailDay> listDay) {
        this.context = aContext;
        this.listData = listDay;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_plan_listitem_detailday, null);
            holder = new ViewHolder();
            holder.idDay = (TextView) convertView.findViewById(R.id.textView_create_plan_idday);
            //holder.buttonChoose = (Button) convertView.findViewById((R.id.button_createplan_chooseExercise));
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DetailDay day = this.listData.get(position);
        holder.idDay.setText(day.getDate());

        return convertView;
    }
    static class ViewHolder {
        TextView idDay;
        //Button buttonChoose;
    }
}
