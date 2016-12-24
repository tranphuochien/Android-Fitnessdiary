package com.example.op.fitnessdiary.album;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;

import com.example.op.fitnessdiary.MainActivity;
import com.example.op.fitnessdiary.R;

import java.util.ArrayList;
import java.util.List;

public class Album_main extends AppCompatActivity {


    private ListView images;
    private Button addBtn;
    private Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_main);

        this.images = (ListView) this.findViewById(R.id.Album_listImages);
        this.addBtn = (Button) this.findViewById(R.id.Album_addNew);
        this.cancelBtn = (Button) this.findViewById(R.id.Album_cancel);

        this.addBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Album_main.this, "Da add anh thanh cong", Toast.LENGTH_SHORT).show();
                // xu ly add o day
            }
        });

        List<UserImage> image_details = getListData();
        images.setAdapter(new Custom_list_adapter(this, image_details));

        images.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = images.getItemAtPosition(position);
                UserImage userImage = (UserImage) o;
                Toast.makeText(Album_main.this, "Selected :" + " " + userImage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<UserImage> getListData() {
        List<UserImage> list = new ArrayList<UserImage>();
        UserImage anh1 = new UserImage("test_image", "anh1");
        UserImage anh2 = new UserImage("test_image", "anh2");
        UserImage anh3 = new UserImage("test_image", "anh3");


        list.add(anh1);
        list.add(anh2);
        list.add(anh3);

        return list;
    }

    public void onClickCancel(View v){
        Intent myIntent = new Intent(this, MainActivity.class);
        this.startActivity(myIntent);
        finish();
    }
}
