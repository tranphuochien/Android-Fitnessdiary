package com.example.op.fitnessdiary.GUI.album;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.op.fitnessdiary.ClassObject.UserImage;
import com.example.op.fitnessdiary.DAO.DBImagesHelper;
import com.example.op.fitnessdiary.MainActivity;
import com.example.op.fitnessdiary.R;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.util.List;

//import com.google.android.gms.drive.DriveFile;
//import com.google.android.gms.drive.DriveId;

public class  Album_main extends AppCompatActivity /*implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener*/ {

    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 99;
    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private static final int REQUEST_ID_VIDEO_CAPTURE = 101;
    private static final int REQUEST_ID_READ_PERMISSION = 102;

    private ListView images;
    private Button addBtn;
    private String storePath;



    private static final String TAG = "Google Drive Activity";
    private static final int REQUEST_CODE_RESOLUTION = 1;
    private static final  int REQUEST_CODE_OPENER = 2;
    public GoogleApiClient mGoogleApiClient;
    private boolean fileOperation = false;
    //private DriveId mFileId;
    //public DriveFile file;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_main);

        this.images = (ListView) this.findViewById(R.id.Album_listImages);
        this.addBtn = (Button) this.findViewById(R.id.Album_addNew);

        this.storePath = askPermissionAndGetPath();

        //imagesHelper.onCreate();

        this.addBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(Album_main.this, "Da add anh thanh cong", Toast.LENGTH_SHORT).show();

                /*fileOperation = false;

                // create new contents resource
                Drive.DriveApi.newDriveContents(mGoogleApiClient)
                        .setResultCallback(driveContentsCallback);fileOperation = false;

                // create new contents resource
                Drive.DriveApi.newDriveContents(mGoogleApiClient)
                        .setResultCallback(driveContentsCallback);*/


                // xu ly add o day
                captureImage();
                //askPermissionAndCaptureImage();
            }
        });


        List<UserImage> image_details = getListData();
        images.setAdapter(new Custom_list_adapter(this, image_details));

        images.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                //Object o = images.getItemAtPosition(position);
                //UserImage userImage = (UserImage) o;
                //Toast.makeText(Album_main.this, "Selected :" + " " + userImage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void askPermissionAndCaptureImage(){
        if (android.os.Build.VERSION.SDK_INT >= 23) {

            // Kiểm tra quyền đọc/ghi dữ liệu vào thiết bị lưu trữ ngoài.
            int readPermission = ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE);
            int writePermission = ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (writePermission != PackageManager.PERMISSION_GRANTED ||
                    readPermission != PackageManager.PERMISSION_GRANTED) {

                // Nếu không có quyền, cần nhắc người dùng cho phép.
                this.requestPermissions(
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_ID_READ_WRITE_PERMISSION
                );
                return;
            }
        }
    }


    private void captureImage() {
        // Tạo một Intent không tường minh,
        // để yêu cầu hệ thống mở Camera chuẩn bị chụp hình.
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File dir = Environment.getExternalStorageDirectory();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        DBImagesHelper imagesHelper = new DBImagesHelper(this);
        int COUNT = imagesHelper.getCountImage();

        // file:///storage/emulated/0/myvideo.mp4
        String savePath = dir.getAbsolutePath() + "/Pictures" + "/anh" + COUNT + "" + ".png";
        File Image = new File(savePath);
        Uri imageUri = Uri.fromFile(Image);



        UserImage newImage = new UserImage(COUNT + "", null, null, null, null, "anh" + COUNT + "" + ".png", null, savePath);
        imagesHelper.insertUserImage(newImage);
        // Chỉ định vị trí lưu file video khi quay.
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

        // Start Activity chụp hình, và chờ đợi kết quả trả về.
        this.startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ID_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                //Bitmap bp = (Bitmap) data.getExtras().get("data");
                List<UserImage> image_details = getListData();
                images.setAdapter(new Custom_list_adapter(this, image_details));
                Toast.makeText(this, "Action successfully", Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Action canceled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();
            }
        }
    }

    /*@Override
    protected void onResume() {
        super.onResume();
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addApi(Drive.API)
                    .addScope(Drive.SCOPE_FILE)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .build();
        }

        //mGoogleApiClient.connect();
    } */

    /* @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient != null) {

            // disconnect Google Android Drive API connection.
            mGoogleApiClient.disconnect();
        }
        super.onPause();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {

        // Called whenever the API client fails to connect.
        Log.i(TAG, "GoogleApiClient connection failed:" + result.toString());

        if (!result.hasResolution()) {

            // show the localized error dialog.
            GoogleApiAvailability.getInstance().getErrorDialog(this, result.getErrorCode(), 0).show();
            return;
        }


        try {

            result.startResolutionForResult(this, REQUEST_CODE_RESOLUTION);

        } catch (IntentSender.SendIntentException e) {

            Log.e(TAG, "Exception while starting resolution activity", e);
        }
    }*/

    /*@Override
    public void onConnected(Bundle connectionHint) {

        Toast.makeText(getApplicationContext(), "Connected", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int cause) {

        Log.i(TAG, "GoogleApiClient connection suspended");
    }

    final ResultCallback<DriveApi.DriveContentsResult> driveContentsCallback =
            new ResultCallback<DriveApi.DriveContentsResult>() {
        @Override
        public void onResult(DriveApi.DriveContentsResult result) {

            if (result.getStatus().isSuccess()) {

                if (fileOperation == true) {

                    CreateFileOnGoogleDrive(result);

                } else {

                    OpenFileFromGoogleDrive();

                }
            }
        }
    };

    public void OpenFileFromGoogleDrive(){

        IntentSender intentSender = Drive.DriveApi
                .newOpenFileActivityBuilder()
                .setMimeType(new String[] {"text/plain", "text/html"})
        .build(mGoogleApiClient);
        try {

            startIntentSenderForResult(

                    intentSender, REQUEST_CODE_OPENER, null, 0, 0, 0);

        } catch (IntentSender.SendIntentException e) {

            Log.w(TAG, "Unable to send intent", e);
        }

    }

    @Override
    protected void onActivityResult(final int requestCode,
                                    final int resultCode, final Intent data) {
        switch (requestCode) {

            case REQUEST_CODE_OPENER:

                if (resultCode == RESULT_OK) {

                    mFileId = (DriveId) data.getParcelableExtra(
                            OpenFileActivityBuilder.EXTRA_RESPONSE_DRIVE_ID);

                    Log.e("file id", mFileId.getResourceId() + "");

                    String url = "https://drive.google.com/open?id"+ mFileId.getResourceId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }

                break;

            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }

    public void CreateFileOnGoogleDrive(DriveApi.DriveContentsResult result){

        final DriveContents driveContents = result.getDriveContents();

        // Perform I/O off the UI thread.
        new Thread() {
            @Override
            public void run() {
                // write content to DriveContents
                OutputStream outputStream = driveContents.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream);
                try {
                    writer.write("Hello abhay");
                    writer.close();
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }

                MetadataChangeSet changeSet = new MetadataChangeSet.Builder()
                        .setTitle("abhaytest2")
                .setMimeType("text/plain")
                .setStarred(true).build();

                // create a file in root folder
                Drive.DriveApi.getRootFolder(mGoogleApiClient)
                        .createFile(mGoogleApiClient, changeSet, driveContents)
                        .setResultCallback(fileCallback);
            }
        }.start();
    }

    final private ResultCallback<DriveFolder.DriveFileResult> fileCallback = new
    ResultCallback<DriveFolder.DriveFileResult>() {
        @Override
        public void onResult(DriveFolder.DriveFileResult result) {
            if (result.getStatus().isSuccess()) {

                Toast.makeText(getApplicationContext(), "file created: "+ " "+
                        result.getDriveFile().getDriveId(), Toast.LENGTH_LONG).show();

            }

            return;

        }
    };*/







    private List<UserImage> getListData() {
        //List<UserImage> list = new ArrayList<UserImage>();
        /*File f = new File(this.storePath);
        f.mkdirs();
        File[] files = f.listFiles();
        if (files.length == 0)
            return null;
        else{
            for (int i = 0; i < files.length; i++){
                UserImage temp = new UserImage(files[i].getName(),"anh" + i + 1 + "",storePath);
                list.add(temp);
            }
        }*/
        DBImagesHelper imagesHelper = new DBImagesHelper(this);
        List<UserImage> list = imagesHelper.getListUserImage(null);
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
                case REQUEST_ID_READ_WRITE_PERMISSION: {

                    // Chú ý: Nếu yêu cầu bị hủy, mảng kết quả trả về là rỗng.
                    // Người dùng đã cấp quyền (đọc/ghi).
                    if (grantResults.length > 1
                            && grantResults[0] == PackageManager.PERMISSION_GRANTED
                            && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                        Toast.makeText(this, "Permission granted!", Toast.LENGTH_LONG).show();

                        this.captureImage();

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
