package com.example.op.fitnessdiary.GUI.ViewHolderListExercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.op.fitnessdiary.ClassObject.ListExercise.Dancing;
import com.example.op.fitnessdiary.ClassObject.ListExercise.Exercise;
import com.example.op.fitnessdiary.R;

/**
 * Created by OP on 12/25/2016.
 */

public class VHDancing extends VHExcercise {
    private Dancing dancing = new Dancing();

    @Override
    public void fillObject(Exercise ex) {
        dancing = (Dancing)ex;
    }

    @Override
    public View findViewById(LayoutInflater layoutInflater)
    {
        View convertView;
        convertView = layoutInflater.inflate(R.layout.activity_plan_listitem_dancing, null);

        this.setAvatar((ImageView) convertView.findViewById(R.id.imageView_dancing_avatar));
        this.setName( (TextView) convertView.findViewById(R.id.textView_dancing_name));
        this.setDuration((TextView) convertView.findViewById(R.id.textView_dancing_duration));
        convertView.setTag(this);
        return convertView;
    }

    @Override
    public void setData(Context context) {
        int imageId = this.getMipmapResIdByName(this.dancing.getAvatar(), context);
        this.getAvatar().setImageResource(imageId);

        this.getName().setText(this.dancing.GetName());
        String tmp = String.valueOf(this.dancing.getDuration());
        this.getDuration().setText(tmp);
    }
}
