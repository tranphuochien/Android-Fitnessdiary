package com.example.op.fitnessdiary.GUI.ViewHolderListExercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.op.fitnessdiary.ClassObject.ListExercise.Exercise;
import com.example.op.fitnessdiary.ClassObject.ListExercise.Lifting;
import com.example.op.fitnessdiary.R;

/**
 * Created by OP on 12/25/2016.
 */
public class VHLifting extends VHExercise {
    TextView sections;
    TextView times;
    EditText editTextSections;
    EditText editTextTimes;
    Lifting lifting = new Lifting();

    public TextView getSections()
    {
        return sections;
    }

    public TextView getTimes()
    {
        return times;
    }

    public void setSections(TextView t)
    {
        sections = t;
    }

    public void setTimes(TextView t)
    {
        times = t;
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
        this.setSections((TextView) convertView.findViewById(R.id.textView_lifting_times));
        this.setTimes((TextView) convertView.findViewById(R.id.textView_lifting_nHitOnTime));
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
        this.getSections().setText("Times: " +tmp);
        tmp = String.valueOf(this.lifting.getTimes());
        this.getTimes().setText("Num hits/time: " + tmp);
    }

    //Method: to set plan a exercise
    @Override
    public View setPlan_findViewById(LayoutInflater layoutInflater) {
        View alertLayout = layoutInflater.inflate(R.layout.plan_edit_lifting, null);
        this.name = (TextView) alertLayout.findViewById(R.id.textView_lifting_name);
        this.editTextDurarion = (EditText) alertLayout.findViewById(R.id.editText_plan_edit_lifting_duration);
        this.editTextSections = (EditText) alertLayout.findViewById(R.id.editText_plan_edit_lifting_sections);
        this.editTextTimes = (EditText)alertLayout.findViewById(R.id.editText_plan_edit_lifting_times);
        this.avatar = (ImageView) alertLayout.findViewById(R.id.imageView_lifting_avatar);
        return alertLayout;
    }

    @Override
    public void setPlan_setData(Context context) {
        //Set avatar
        int imageId = this.getMipmapResIdByName(this.lifting.getAvatar(), context);
        this.getAvatar().setImageResource(imageId);

        //Set name
        this.name.setText(lifting.GetName().toString());
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

        lifting.setDuration(duration);
        lifting.setSections(section);
        lifting.setTimes(times);

        return lifting;
    }


    //Method: prototype pattern
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
