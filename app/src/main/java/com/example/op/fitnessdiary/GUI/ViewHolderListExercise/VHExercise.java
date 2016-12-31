package com.example.op.fitnessdiary.GUI.ViewHolderListExercise;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.op.fitnessdiary.ClassObject.ListExercise.Exercise;
import com.example.op.fitnessdiary.ClassObject.ListExercise.NameHelper;

/**
 * Created by OP on 12/25/2016.
 */

public abstract class VHExercise {
    protected ImageView avatar;
    protected TextView name;
    protected TextView textViewDuration;
    protected EditText editTextDurarion;


    //----Set method
    public void setAvatar(ImageView img)
    {
        avatar = img;
    }

    public void setName(TextView s)
    {
        name = s;
    }

    public void setTextViewDuration(TextView d)
    {
        this.textViewDuration = d;
    }

    public void setEditTextDurarion(EditText e) { this.editTextDurarion = e;}

    //----Get method
    public ImageView getAvatar()
    {
        return avatar;
    }

    public TextView getName()
    {
        return name;
    }

    public TextView getTextViewDuration()
    {
        return textViewDuration;
    }

    public EditText getEditTextDurarion() { return this.editTextDurarion;}


    public abstract void fillObject(Exercise ex);

    //Method: List exercises
    public abstract View listEx_findViewById(LayoutInflater layoutInflater);

    public abstract void listEx_setData(Context context);

    public int getMipmapResIdByName(String resName, Context context)  {
        String pkgName = context.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    //Meythod: Set plan for a exercise
    public abstract View setPlan_findViewById(LayoutInflater layoutInflater);

    public abstract void setPlan_setData(Context context);

    public abstract Exercise setPlan_getExercise();


    //Method: prototype pattern
    public abstract String GetName();

    public abstract VHExercise Clone();

    public Boolean isOkByName(String strTypeName){
        return false;
    }

    protected  String NormalizeName(String strTypeName)
    {
        return strTypeName.toUpperCase();
    }

}
