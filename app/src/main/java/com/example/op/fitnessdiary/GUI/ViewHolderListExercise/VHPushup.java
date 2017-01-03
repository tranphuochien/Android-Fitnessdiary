package com.example.op.fitnessdiary.GUI.ViewHolderListExercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.op.fitnessdiary.ClassObject.ListExercise.Exercise;
import com.example.op.fitnessdiary.ClassObject.ListExercise.PushUp;
import com.example.op.fitnessdiary.R;

/**
 * Created by OP on 12/25/2016.
 */
public class VHPushup extends VHExercise {
    TextView sections;
    TextView times;
    EditText editTextSections;
    EditText editTextTimes;
    PushUp pushUp= new PushUp();

    //Method: get
    public TextView getSections()
    {
        return sections;
    }

    public TextView getTimes()
    {
        return times;
    }

    public EditText getEditTextSections() { return editTextSections;}

    public EditText getEditTextTimes() { return  editTextTimes;}

    //Method: set
    public void setSections(TextView t)
    {
        sections = t;
    }

    public void setTimes(TextView t)
    {
        times = t;
    }

    public void setEditTextSections(EditText e) {this.editTextSections = e;}

    public void setEditTextTimes(EditText e) { this.editTextTimes = e;}
    @Override
    public void fillObject(Exercise ex) {
        pushUp = (PushUp) ex;
    }

    @Override
    public View listEx_findViewById(LayoutInflater layoutInflater) {
        View convertView;
        convertView = layoutInflater.inflate(R.layout.activity_plan_listitem_pushup, null);

        this.setAvatar((ImageView) convertView.findViewById(R.id.imageView_jogging_avatar));
        this.setName( (TextView) convertView.findViewById(R.id.textView_pushup_name));
        this.setSections((TextView) convertView.findViewById(R.id.textView_lifting_times));
        this.setTimes((TextView) convertView.findViewById(R.id.textView_pushup_nHitOnTime));
        this.setTextViewDuration((TextView) convertView.findViewById(R.id.textView_pushup_duration));
        convertView.setTag(this);

        return convertView;
    }

    @Override
    public void listEx_setData(Context context) {
        int imageId = this.getMipmapResIdByName(this.pushUp.getAvatar(), context);
        this.getAvatar().setImageResource(imageId);

        this.getName().setText(this.pushUp.GetName());
        String tmp = String.valueOf(this.pushUp.getDuration());
        this.getTextViewDuration().setText("Duration: " + tmp);
        tmp = String.valueOf(this.pushUp.getSections());
        this.getSections().setText("Times: " + tmp);
        tmp = String.valueOf(this.pushUp.getTimes());
        this.getTimes().setText("Num hits/time: " +tmp);
    }


    //Method: to set plan a exercise
    @Override
    public View setPlan_findViewById(LayoutInflater layoutInflater) {
        View alertLayout = layoutInflater.inflate(R.layout.plan_edit_pushup, null);
        this.name = (TextView) alertLayout.findViewById(R.id.textView_pushup_name);
        this.editTextDurarion = (EditText) alertLayout.findViewById(R.id.editText_plan_edit_pushup_duration);
        this.editTextSections = (EditText) alertLayout.findViewById(R.id.editText_plan_edit_pushup_sections);
        this.editTextTimes = (EditText)alertLayout.findViewById(R.id.editText_plan_edit_lifting_times);
        this.avatar = (ImageView) alertLayout.findViewById(R.id.imageView_pushup_avatar);
        return alertLayout;
    }

    @Override
    public void setPlan_setData(Context context) {
        //Set avatar
        int imageId = this.getMipmapResIdByName(this.pushUp.getAvatar(), context);
        this.getAvatar().setImageResource(imageId);

        //Set name
        this.name.setText(pushUp.GetName().toString());
    }


    @Override
    public Exercise setPlan_getExercise()
    {
        int duration = 10;
        int section = 1;
        int times = 20;
        try
        {
            duration = Integer.valueOf(editTextDurarion.getText().toString());
            section  = Integer.valueOf(editTextSections.getText().toString());
            times = Integer.valueOf(editTextTimes.getText().toString());
        }
        catch (NumberFormatException e)
        {}

        pushUp.setDuration(duration);
        pushUp.setSections(section);
        pushUp.setTimes(times);

        return pushUp;
    }

    //Method: prototype pattern
    @Override
    public String GetName() {
        return "PUSHUP";
    }

    public Boolean isOkByName(String strTypeName) {
        return NormalizeName(strTypeName) == GetName();
    }

    @Override
    public VHExercise Clone() {
        VHExercise obj = new VHPushup();
        return  obj;
    }

}

