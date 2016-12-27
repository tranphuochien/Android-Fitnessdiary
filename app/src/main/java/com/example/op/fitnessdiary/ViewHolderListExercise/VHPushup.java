package com.example.op.fitnessdiary.ViewHolderListExercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.op.fitnessdiary.ListExercise.Exercise;
import com.example.op.fitnessdiary.ListExercise.PushUp;
import com.example.op.fitnessdiary.R;

/**
 * Created by OP on 12/25/2016.
 */
public class VHPushup extends VHExcercise {
    TextView nTimes;
    TextView nHitOnTime;
    PushUp pushUp= new PushUp();
    public TextView getnTimes()
    {
        return nTimes;
    }

    public TextView getnHitOnTime()
    {
        return nHitOnTime;
    }

    public void setnTimes(TextView t)
    {
        nTimes = t;
    }

    public void setnHitOnTime(TextView t)
    {
        nHitOnTime = t;
    }

    @Override
    public void fillObject(Exercise ex) {
        pushUp = (PushUp) ex;
    }

    @Override
    public View findViewById(LayoutInflater layoutInflater) {
        View convertView;
        convertView = layoutInflater.inflate(R.layout.activity_plan_listitem_pushup, null);

        this.setAvatar((ImageView) convertView.findViewById(R.id.imageView_pushup_avatar));
        this.setName( (TextView) convertView.findViewById(R.id.textView_pushup_name));
        this.setnTimes((TextView) convertView.findViewById(R.id.textView_lifting_times));
        this.setnHitOnTime((TextView) convertView.findViewById(R.id.textView_pushup_nHitOnTime));
        this.setDuration((TextView) convertView.findViewById(R.id.textView_pushup_duration));
        convertView.setTag(this);

        return convertView;
    }

    @Override
    public void setData(Context context) {
        int imageId = this.getMipmapResIdByName(this.pushUp.getAvatar(), context);
        this.getAvatar().setImageResource(imageId);

        this.getName().setText(this.pushUp.GetName());
        String tmp = String.valueOf(this.pushUp.getDuration());
        this.getDuration().setText(tmp);
        tmp = String.valueOf(this.pushUp.getTimes());
        this.getnTimes().setText(tmp);
        tmp = String.valueOf(this.pushUp.getnHitOnTime());
        this.getnHitOnTime().setText(tmp);
    }
}
