package com.example.op.fitnessdiary.GUI.ViewHolderListExercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.op.fitnessdiary.ClassObject.ListExercise.Exercise;
import com.example.op.fitnessdiary.ClassObject.ListExercise.Jogging;
import com.example.op.fitnessdiary.R;

/**
 * Created by OP on 12/25/2016.
 */

public class VHJogging extends VHExercise {
    private TextView nKilometers;
    private EditText editTextNKms;
    private Jogging jogging = new Jogging();

    @Override
    public void fillObject(Exercise ex) {
        jogging = (Jogging)ex;
    }

    //Method: Get and set
    public TextView getnKilometers()
    {
        return nKilometers;
    }

    public void setnKilometers(TextView k)
    {
        nKilometers = k;
    }


    //Method: to show list exercise
    @Override
    public View listEx_findViewById(LayoutInflater layoutInflater) {
        View convertView;
        convertView = layoutInflater.inflate(R.layout.activity_plan_listitem_jogging, null);

        this.setAvatar((ImageView) convertView.findViewById(R.id.imageView_jogging_avatar));
        this.setName( (TextView) convertView.findViewById(R.id.textView_jogging_name));
        this.setnKilometers((TextView) convertView.findViewById(R.id.textView_jogging_nKilometers));
        this.setTextViewDuration((TextView) convertView.findViewById(R.id.textView_jogging_duration));
        convertView.setTag(this);
        return convertView;
    }

    @Override
    public void listEx_setData(Context context) {
        //Set avatar
        int imageId = this.getMipmapResIdByName(this.jogging.getAvatar(), context);
        this.getAvatar().setImageResource(imageId);

        //Set name
        this.getName().setText(this.jogging.GetName());

        //Set duration tag
        String tmp = String.valueOf(this.jogging.getDuration());
        this.getTextViewDuration().setText("Duration: " + tmp);

        //Set Num.Kms tag
        tmp = String.valueOf(this.jogging.getnKilometer());
        this.getnKilometers().setText("Num.Kms: " + tmp);
    }


    //Method: to set plan a exercise
    @Override
    public View setPlan_findViewById(LayoutInflater layoutInflater) {
        View alertLayout = layoutInflater.inflate(R.layout.plan_edit_jogging, null);
        this.name = (TextView) alertLayout.findViewById(R.id.textView_plan_edit_jogging_name);
        this.editTextDurarion = (EditText) alertLayout.findViewById(R.id.editText_plan_edit_jogging_duration);
        this.editTextNKms = (EditText) alertLayout.findViewById(R.id.editText__plan_edit_jogging_nkms);
        this.avatar = (ImageView) alertLayout.findViewById(R.id.imageView_jogging_avatar);
        return alertLayout;
    }

    @Override
    public void setPlan_setData(Context context) {
        //Set avatar
        int imageId = this.getMipmapResIdByName(this.jogging.getAvatar(), context);
        this.getAvatar().setImageResource(imageId);

        //Set name
        this.name.setText(jogging.GetName().toString());
    }


    @Override
    public Exercise setPlan_getExercise()
    {
        int duration;
        int nKms;
        try
        {
            duration = Integer.valueOf(editTextDurarion.getText().toString());
            nKms =Integer.valueOf(editTextNKms.getText().toString());
        }
        catch (NumberFormatException e)
        {
            duration = 10;
            nKms = 1;
        }

        jogging.setDuration(duration);
        jogging.setnKilometer(nKms);
        return jogging;
    }


    //Method: prototype pattern
    @Override
    public String GetName() {
        return "JOGGING";
    }

    public Boolean isOkByName(String strTypeName) {
        return NormalizeName(strTypeName) == GetName();
    }

    @Override
    public VHExercise Clone() {
        VHExercise obj = new VHJogging();
        return  obj;
    }

}
