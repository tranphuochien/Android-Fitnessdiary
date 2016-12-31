package com.example.op.fitnessdiary.GUI.ViewHolderListExercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.op.fitnessdiary.ClassObject.ListExercise.Exercise;
import com.example.op.fitnessdiary.ClassObject.ListExercise.Lifting;
import com.example.op.fitnessdiary.R;

/**
 * Created by OP on 12/25/2016.
 */
public class VHLifting extends VHExercise {
    TextView nTimes;
    TextView nHitOnTime;
    Lifting lifting = new Lifting();

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
        lifting = (Lifting) ex;
    }

    @Override
    public View listEx_findViewById(LayoutInflater layoutInflater) {
        View convertView;
        convertView = layoutInflater.inflate(R.layout.activity_plan_listitem_lifting, null);

        this.setAvatar((ImageView) convertView.findViewById(R.id.imageView_lifting_avatar));
        this.setName( (TextView) convertView.findViewById(R.id.textView_lifting_name));
        this.setnTimes((TextView) convertView.findViewById(R.id.textView_lifting_times));
        this.setnHitOnTime((TextView) convertView.findViewById(R.id.textView_lifting_nHitOnTime));
        this.setTextViewDuration((TextView) convertView.findViewById(R.id.textView_lifting_duration));
        convertView.setTag(this);

        return convertView;
    }

    @Override
    public void listEx_setData(Context context) {
        int imageId = this.getMipmapResIdByName(this.lifting.getAvatar(), context);
        this.getAvatar().setImageResource(imageId);

        this.getName().setText(this.lifting.GetName());
        String tmp = String.valueOf(this.lifting.getDuration());
        this.getTextViewDuration().setText("Duration: " +tmp);
        tmp = String.valueOf(this.lifting.getSections());
        this.getnTimes().setText("Times: " +tmp);
        tmp = String.valueOf(this.lifting.getTimes());
        this.getnHitOnTime().setText("Num hits/time: " + tmp);
    }

    @Override
    public View setPlan_findViewById(LayoutInflater layoutInflater) {
        return null;
    }


    @Override
    public void setPlan_setData(Context context) {

    }

    @Override
    public Exercise setPlan_getExercise() {
        return null;
    }


    @Override
    public String GetName() {
        return "LIFTING";
    }

    public Boolean isOkByName(String strTypeName) {
        return NormalizeName(strTypeName) == GetName();
    }

    @Override
    public VHExercise Clone() {
        VHExercise obj = new VHLifting();
        return  obj;
    }

}
