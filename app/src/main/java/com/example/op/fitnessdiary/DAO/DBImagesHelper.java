package com.example.op.fitnessdiary.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.op.fitnessdiary.ClassObject.UserImage;

import java.util.ArrayList;

/**
 * Created by theriddle on 1/6/17.
 */

public class DBImagesHelper extends DBHelper{
    public DBImagesHelper(Context context) {
        super(context);
    }

    /*@Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE_IMAGES);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /**
            * get UserImage by sql command
    *
            * @param sql sql to get UserImage
    */
    public UserImage getUserImage(String sql) {
        UserImage UserImage = null;
        Cursor cursor = getAll(sql);
        if (cursor != null) {
            UserImage = cursorToUserImage(cursor);
            cursor.close();
        }
        return UserImage;
    }

    public int getCountImage(){
        return getCount(TABLE_IMAGES);
    }

    /**
     * @param sql get all UserImage with sql command
     * @return ArrayList of UserImage
     */
    public ArrayList<UserImage> getListUserImage(String sql) {
        ArrayList<UserImage> list = new ArrayList<>();
        Cursor cursor = getAll("SELECT * FROM " + TABLE_IMAGES);

        while (!cursor.isAfterLast()) {
            list.add(cursorToUserImage(cursor));
            cursor.moveToNext();
        }
        cursor.close();

        return list;
    }

    private UserImage cursorToUserImage(Cursor cursor) {
        String id = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_ID));
        String createAt = cursor.getString(cursor.getColumnIndex(COLUMN_CREATE_AT));
        String inPost = cursor.getString(cursor.getColumnIndex(COLUMN_IN_POST));
        String inAlbum = cursor.getString(cursor.getColumnIndex(COLUMN_IN_ALBUM));
        String inDetail = cursor.getString(cursor.getColumnIndex(COLUMN_IN_DETAIL));
        String name = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_NAME));
        String path = cursor.getString(cursor.getColumnIndex(COLUMN_PATH));
        UserImage UserImage = new UserImage(id, createAt, inAlbum, inPost, inDetail, name, null, path);
        return UserImage;
    }

    /**
     * insert acccount to table
     *
     * @param userImage account to insert
     * @return id of account
     */
    public long insertUserImage(UserImage userImage) {
        return this.insert(TABLE_IMAGES, accountToValues(userImage));
    }

    private ContentValues accountToValues(UserImage userImage) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_IMAGE_ID, userImage.getImageid());
        values.put(COLUMN_IN_ALBUM, userImage.getImageInAlbum());
        values.put(COLUMN_CREATE_AT, userImage.getImageCreate());
        values.put(COLUMN_IN_DETAIL, userImage.getImageInDetail());
        values.put(COLUMN_IN_POST, userImage.getImageInPost());
        values.put(COLUMN_IMAGE_NAME, userImage.getImageName());
        values.put(COLUMN_PATH, userImage.getImagePath());

        return values;
    }

    /**
     * @param  userImage to update
     * @return id of UserImage update
     */
    public boolean updateUserImage(UserImage userImage) {
        return update(TABLE_IMAGES, accountToValues(userImage), COLUMN_IMAGE_ID + " = " + userImage.getImageid());
    }

    /**
     * delete id row of table
     */
    public boolean deleteUserImage(String id) {
        return delete(TABLE_IMAGES, id);
    }
}
