package com.example.op.fitnessdiary.Plan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.op.fitnessdiary.ListExercise.Exercise;
import com.example.op.fitnessdiary.ViewHolderListExercise.VHDancing;
import com.example.op.fitnessdiary.ViewHolderListExercise.VHExcercise;
import com.example.op.fitnessdiary.ViewHolderListExercise.VHJogging;
import com.example.op.fitnessdiary.ViewHolderListExercise.VHLifting;
import com.example.op.fitnessdiary.ViewHolderListExercise.VHPushup;

import java.util.ArrayList;

/**
 * Created by OP on 12/25/2016.
 */

public class CustomListAdapter extends BaseAdapter{
    private ArrayList<Exercise> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext,  ArrayList<Exercise> listData) {
        this.context = aContext;
        this.listData = listData;
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
        String nameObject = this.listData.get(position).GetName();
        Exercise exercise = this.listData.get(position);
        VHExcercise holder = null;

        switch (nameObject) {
            case "jogging":
                holder = new VHJogging();
                break;

            case "dancing":
                holder = new VHDancing();
                break;
            case "lifting":
                holder = new VHLifting();
                break;
            case "pushup":
                holder = new VHPushup();
                break;

        }
        if (holder != null)
        {
            holder.fillObject(exercise);

            if (convertView == null) {
                convertView = holder.findViewById(layoutInflater);
            } else holder = (VHExcercise) convertView.getTag();

            holder.setData(this.context);
        }

        return convertView;
    }
}
