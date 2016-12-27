package com.example.op.fitnessdiary.album;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.Manifest;
import android.widget.Toast;

import com.example.op.fitnessdiary.MainActivity;
import com.example.op.fitnessdiary.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by theriddle on 12/24/16.
 */

public class Custom_list_adapter extends BaseAdapter {

    private List<UserImage> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    static class ViewHolder {
        ImageView image;
        TextView info;
    }

    public Custom_list_adapter(Context aContext, List<UserImage> listData){
        this.context = aContext;
        this.listData = listData;
        this.layoutInflater = LayoutInflater.from(aContext);
    }

    public int getCount() {
        return listData.size();
    }

    public Object getItem(int position){
        return listData.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView (int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.album_list_item, null);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.imageView_userImage);
            holder.info = (TextView) convertView.findViewById(R.id.textView_info);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        UserImage userImage = this.listData.get(position);
        holder.info.setText(userImage.getImageInfo());

        holder.image.setImageBitmap(BitmapFactory.decodeFile(userImage.getImagePath() + userImage.getImageName()));
        return convertView;
    }
}
