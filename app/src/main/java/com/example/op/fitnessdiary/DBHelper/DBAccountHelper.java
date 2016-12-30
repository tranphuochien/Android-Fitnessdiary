package com.example.op.fitnessdiary.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.example.op.fitnessdiary.DAO.Account;

import java.util.ArrayList;

/**
 * Created by OP on 12/30/2016.
 */

public class DBAccountHelper extends DBHelper {

    public DBAccountHelper(Context context) {
        super(context);
    }

    /**
     * get Account by sql command
     *
     * @param sql sql to get account
     */
    public Account getAccount(String sql) {
       Account account = null;
        Cursor cursor = getAll(sql);
        if (cursor != null) {
            account = cursorToAccount(cursor);
            cursor.close();
        }
        return account;
    }

    /**
     * @param sql get all accounts with sql command
     * @return arraylist of account
     */
    public ArrayList<Account> getListAccount(String sql) {
        ArrayList<Account> list = new ArrayList<>();
        Cursor cursor = getAll(sql);

        while (!cursor.isAfterLast()) {
            list.add(cursorToAccount(cursor));
            cursor.moveToNext();
        }
        cursor.close();

        return list;
    }

    /**
     * insert acccount to table
     *
     * @param account account to insert
     * @return id of account
     */
    public long insertAccount(Account account) {
        return this.insert(TABLE_ACCOUNT, accountToValues(account));
    }

    /**
     * @param  account to update
     * @return id of account update
     */
    public boolean updateAccount(Account account) {
        return update(TABLE_ACCOUNT, accountToValues(account), COLUMN_ACCOUNT_ID + " = " + account.getId());
    }

    /**
     * delete id row of table
     */
    public boolean deleteAccount(String where) {
        return delete(TABLE_ACCOUNT, where);
    }

    /**
     * convert account to contentvalues
     * don't put id of account because
     * when insert id will auto create
     * when update we don't update id
     */
    private ContentValues accountToValues(Account account) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_ACCOUNT_ID, account.getId());
        values.put(COLUMN_ACCOUNT_NICKNAME, account.getNickname());
        values.put(COLUMN_ACCOUNT_EMAIL, account.getEmail());
        values.put(COLUMN_ACCOUNT_DOB, account.getDOB());
        values.put(COLUMN_ACCOUNT_AVATAR, account.getAvatar());
        values.put(COLUMN_ACCOUNT_RANK, account.getRank());
        values.put(COLUMN_ACCOUNT_GENDER, account.getGender());
        values.put(COLUMN_ACCOUNT_PASSWORD, account.getPassword());

        return values;
    }

    /**
     * convert cursor to account
     */
    private Account cursorToAccount(Cursor cursor) {
        String id = cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNT_ID));
        String nickname = cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNT_NICKNAME));
        String email = cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNT_EMAIL));
        String dob = cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNT_DOB));
        String avatar = cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNT_AVATAR));
        int rank = cursor.getInt(cursor.getColumnIndex(COLUMN_ACCOUNT_RANK));
        String gender = cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNT_GENDER));
        String password =cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNT_PASSWORD));

        Account account = new Account(id, nickname, email,dob, rank, gender,avatar, password);

        return account;
    }
}
