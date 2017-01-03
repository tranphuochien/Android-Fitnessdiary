package com.example.op.fitnessdiary.GUI.ViewHolderListExercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.op.fitnessdiary.ClassObject.ListExercise.Dancing;
import com.example.op.fitnessdiary.ClassObject.ListExercise.Exercise;
import com.example.op.fitnessdiary.R;

/**
 * Created by OP on 12/25/2016.
 */

public class VHDancing extends VHExercise {
    private Dancing dancing = new Dancing();

    @Override
    public void fillObject(Exercise ex) {
        dancing = (Dancing)ex;
    }

    //Method: to show list exercise
    @Override
    public View listEx_findViewById(LayoutInflater layoutInflater)
    {
        View convertView;
        convertView = layoutInflater.inflate(R.layout.activity_plan_listitem_dancing, null);

        this.setAvatar((ImageView) convertView.findViewById(R.id.imageView_jogging_avatar));
        this.setName( (TextView) convertView.findViewById(R.id.textView_dancing_name));
        this.setTextViewDuration((TextView) convertView.findViewById(R.id.textView_dancing_duration));
        convertView.setTag(this);
        return convertView;
    }

    @Override
    public void listEx_setData(Context context) {
        int imageId = this.getMipmapResIdByName(this.dancing.getAvatar(), context);
        this.getAvatar().setImageResource(imageId);

        this.getName().setText(this.dancing.GetName());
        String tmp = String.valueOf(this.dancing.getDuration());
        this.getTextViewDuration().setText("Duration: " + tmp);
    }


    //Method: to set plan a exercise
    @Override
    public View setPlan_findViewById(LayoutInflater layoutInflater) {
        View alertLayout = layoutInflater.inflate(R.layout.plan_edit_dancing, null);
        this.name = (TextView) alertLayout.findViewById(R.id.textView_dancing_name);
        this.editTextDurarion = (EditText) alertLayout.findViewById(R.id.editText_dancing_edit_duration);
        this.avatar = (ImageView) alertLayout.findViewById(R.id.imageView_dancing_avatar);
        return alertLayout;
    }

    @Override
    public void setPlan_setData(Context context) {
        //Set avatar
        int imageId = this.getMipmapResIdByName(this.dancing.getAvatar(), context);
        this.getAvatar().setImageResource(imageId);

        //Set name
        this.name.setText(dancing.GetName().toString());
    }


    @Override
    public Exercise setPlan_getExercise()
    {
        int duration = 10;
        try
        {
            duration = Integer.valueOf(editTextDurarion.getText().toString());
        }
        catch (NumberFormatException e)
        {

        }

        dancing.setDuration(duration);
        return dancing;
    }


    //Method: prototype pattern
    @Override
    public String GetName() {
        return "DANCING";
    }

    public Boolean isOkByName(String strTypeName) {
        return NormalizeName(strTypeName) == GetName();
    }

    @Override
    public VHExercise Clone() {
        VHExercise obj = new VHDancing();
        return  obj;
    }

}

