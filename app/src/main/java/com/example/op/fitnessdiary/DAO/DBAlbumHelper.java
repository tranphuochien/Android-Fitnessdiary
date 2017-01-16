package com.example.op.fitnessdiary.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.op.fitnessdiary.ClassObject.Album;

/**
 * Created by theriddle on 1/6/17.
 */

public class DBAlbumHelper extends DBHelper{
    public DBAlbumHelper(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE_ALBUM);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * get Album by sql command
     *
     * @param sql sql to get Album
     */
    public Album getAlbum(String sql) {
        Album album = null;
        Cursor cursor = getAll(sql);
        if (cursor != null) {
            album = cursorToAlbum(cursor);
            cursor.close();
        }
        return album;
    }

    private Album cursorToAlbum(Cursor cursor) {
        String id = cursor.getString(cursor.getColumnIndex(COLUMN_ALBUM_ID));
        Album album = new Album(id);
        return album;
    }

    /**
     * insert acccount to table
     *
     * @param album account to insert
     * @return id of account
     */
    public long insertAlbum(Album album) {
        return this.insert(TABLE_ALBUM, accountToValues(album));
    }

    private ContentValues accountToValues(Album album) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ALBUM_ID, album.getId());

        return values;
    }

    /**
     * @param  album to update
     * @return id of album update
     */
    public boolean updateAccount(Album album) {
        return update(TABLE_ALBUM, accountToValues(album), COLUMN_ALBUM_ID + " = " + album.getId());
    }

    /**
     * delete id row of table
     */
    public boolean deleteAlbum(String id) {
        return delete(TABLE_ALBUM, id);
    }
}
