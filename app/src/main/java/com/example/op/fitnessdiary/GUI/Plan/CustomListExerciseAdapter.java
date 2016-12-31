package com.example.op.fitnessdiary.GUI.Plan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.op.fitnessdiary.ClassObject.ListExercise.Exercise;
import com.example.op.fitnessdiary.GUI.ViewHolderListExercise.ListVHExercise;
import com.example.op.fitnessdiary.GUI.ViewHolderListExercise.VHDancing;
import com.example.op.fitnessdiary.GUI.ViewHolderListExercise.VHExercise;
import com.example.op.fitnessdiary.GUI.ViewHolderListExercise.VHJogging;
import com.example.op.fitnessdiary.GUI.ViewHolderListExercise.VHLifting;
import com.example.op.fitnessdiary.GUI.ViewHolderListExercise.VHPushup;

import java.util.ArrayList;

/**
 * Created by OP on 12/25/2016.
 */

public class CustomListExerciseAdapter extends BaseAdapter{
    private ArrayList<Exercise> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListExerciseAdapter(Context aContext, ArrayList<Exercise> listData) {
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
        VHExercise holder = null;

        ListVHExercise listVH = ListVHExercise.getInstance();
        holder = listVH.ChooseVHExercise(nameObject);

        if (holder != null)
        {
            holder.fillObject(exercise);

            if (convertView == null) {
                convertView = holder.listEx_findViewById(layoutInflater);
            } else holder = (VHExercise) convertView.getTag();

            holder.listEx_setData(this.context);
        }

        return convertView;
    }
}
