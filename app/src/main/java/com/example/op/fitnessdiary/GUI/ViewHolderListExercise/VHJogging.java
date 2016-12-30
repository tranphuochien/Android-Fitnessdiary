package com.example.op.fitnessdiary.GUI.ViewHolderListExercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.op.fitnessdiary.ClassObject.ListExercise.Exercise;
import com.example.op.fitnessdiary.ClassObject.ListExercise.Jogging;
import com.example.op.fitnessdiary.R;

/**
 * Created by OP on 12/25/2016.
 */

public class VHJogging extends VHExcercise {
    private TextView nKilometers;
    private Jogging jogging = new Jogging();
    @Override
    public void fillObject(Exercise ex) {
        jogging = (Jogging)ex;
    }

    public TextView getnKilometers()
    {
        return nKilometers;
    }

    public void setnKilometers(TextView k)
    {
        nKilometers = k;
    }

    @Override
    public View findViewById(LayoutInflater layoutInflater) {
        View convertView;
        convertView = layoutInflater.inflate(R.layout.activity_plan_listitem_jogging, null);

        this.setAvatar((ImageView) convertView.findViewById(R.id.imageView_jogging_avatar));
        this.setName( (TextView) convertView.findViewById(R.id.textView_jogging_name));
        this.setnKilometers((TextView) convertView.findViewById(R.id.textView_jogging_nKilometers));
        this.setDuration((TextView) convertView.findViewById(R.id.textView_jogging_duration));
        convertView.setTag(this);
        return convertView;
    }

    @Override
    public void setData(Context context) {
        int imageId = this.getMipmapResIdByName(this.jogging.getAvatar(), context);
        this.getAvatar().setImageResource(imageId);
        
        this.getName().setText(this.jogging.GetName());
        String tmp = String.valueOf(this.jogging.getDuration());
        this.getDuration().setText(tmp);
        tmp = String.valueOf(this.jogging.getnKilometer());
        this.getnKilometers().setText(tmp);
    }

}
