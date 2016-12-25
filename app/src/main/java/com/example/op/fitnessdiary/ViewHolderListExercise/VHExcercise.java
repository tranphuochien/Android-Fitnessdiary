package com.example.op.fitnessdiary.ViewHolderListExercise;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.op.fitnessdiary.ListExercise.Exercise;

/**
 * Created by OP on 12/25/2016.
 */

public abstract class VHExcercise {
    protected ImageView avatar;
    protected TextView name;
    protected TextView duration;
    protected Exercise exercise;

    public ImageView getAvatar()
    {
        return avatar;
    }
    public void setAvatar(ImageView img)
    {
        avatar = img;
    }
    public TextView getName()
    {
        return name;
    }
    public void setName(TextView s)
    {
        name = s;
    }

    public TextView getDuration()
    {
        return duration;
    }

    public void setDuration(TextView d)
    {
        this.duration = d;
    }
    public abstract void fillObject(Exercise ex);

    public abstract View findViewById(LayoutInflater layoutInflater);

    public abstract void setData(Context context);

    public int getMipmapResIdByName(String resName, Context context)  {
        String pkgName = context.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
}
