package com.example.op.fitnessdiary.album;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.Manifest;

import com.example.op.fitnessdiary.MainActivity;
import com.example.op.fitnessdiary.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Album_main extends AppCompatActivity {

    private static final int REQUEST_ID_READ_PERMISSION = 100;
    private ListView images;
    private Button addBtn;
    private String storePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_main);

        this.images = (ListView) this.findViewById(R.id.Album_listImages);
        this.addBtn = (Button) this.findViewById(R.id.Album_addNew);

        this.storePath = askPermissionAndGetPath();

        this.addBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
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
        UserImage anh1 = new UserImage("test_image.png", "anh1", storePath);
        UserImage anh2 = new UserImage("test_image.png", "anh2", storePath);
        UserImage anh3 = new UserImage("test_image.png", "anh3", storePath);

        list.add(anh1);
        list.add(anh2);
        list.add(anh3);

        return list;
    }

    public void onClickCancel(View v) {
        Intent myIntent = new Intent(this, MainActivity.class);
        this.startActivity(myIntent);
        finish();
    }

    private String askPermissionAndGetPath() {
        boolean canRead = this.askPermission(REQUEST_ID_READ_PERMISSION,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        //
        if (canRead) {
            return this.readFile();
        }
        return null;
    }

    private boolean askPermission(int requestId, String permissionName) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {

            // Kiểm tra quyền
            int permission = ActivityCompat.checkSelfPermission(this, permissionName);


            if (permission != PackageManager.PERMISSION_GRANTED) {

                // Nếu không có quyền, cần nhắc người dùng cho phép.
                this.requestPermissions(
                        new String[]{permissionName},
                        requestId
                );
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //

        // Chú ý: Nếu yêu cầu bị hủy, mảng kết quả trả về là rỗng.
        if (grantResults.length > 0) {
            switch (requestCode) {
                case REQUEST_ID_READ_PERMISSION: {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        readFile();
                    }
                }
            }
        } else {
            Toast.makeText(this.getApplicationContext(), "Permission Cancelled!", Toast.LENGTH_SHORT).show();
        }
    }

    private String readFile() {
        // Thư mục gốc của SD Card.
        File extStore = Environment.getExternalStorageDirectory();
        // ==> /storage/emulated/0/note.txt
        String path = extStore.getAbsolutePath() + "/" + "Pictures" + "/";
        Log.v("Album_main", path);
        return path;
    }
}
