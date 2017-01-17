package com.example.op.fitnessdiary.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.op.fitnessdiary.ClassObject.ListExercise.Jogging;

import java.util.ArrayList;

/**
 * Created by OP on 1/17/2017.
 */

public class DBJoggingHelper extends DBHelper{
    
    public DBJoggingHelper(Context context) {
        super(context);
    }

    /**
     * get Jogging by sql command
     *
     * @param sql sql to get Jogging
     */
    public Jogging getJogging(String sql) {
        Jogging jogging = null;
        Cursor cursor = getAll(sql);
        if (cursor != null) {
            jogging = cursorToPlan(cursor);
            cursor.close();
        }
        return jogging;
    }

    /**
     * @param sql get all plan with sql command
     * @return arraylist of jogging
     */
    public ArrayList<Jogging> getListJogging(String sql) {
        ArrayList<Jogging> list = new ArrayList<>();
        Cursor cursor = getAll(sql);

        while (!cursor.isAfterLast()) {
            list.add(cursorToPlan(cursor));
            cursor.moveToNext();
        }
        cursor.close();

        return list;
    }

    /**
     * insert Jogging to table
     *
     * @param  jogging to insert
     * @return id of Jogging
     */
    public long insertJogging(Jogging jogging) {
        return this.insert(TABLE_JOGGING, joggingToValues(jogging));
    }

    /**
     * @param  jogging to update
     * @return id of Jogging update
     */
    public boolean updateJogging(Jogging jogging) {
        return update(TABLE_JOGGING, joggingToValues(jogging), COLUMN_JOGGING_IDPLAN+ " = " + jogging.getIdPlan());
    }

    /**
     * delete id row of table
     */
    public boolean deleteJogging(String where) {
        return delete(TABLE_JOGGING, where);
    }

    /**
     * convert account to contentvalues
     * don't put id of account because
     * when insert id will auto create
     * when update we don't update id
     */
    private ContentValues joggingToValues(Jogging jogging) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_JOGGING_IDPLAN, jogging.getIdPlan());
        values.put(COLUMN_JOGGING_DATEPLAN, jogging.getDatePlan());
        values.put(COLUMN_JOGGING_DURATION, jogging.getDuration());
        values.put(COLUMN_JOGGING_NUMKM, jogging.getnKilometer());

        return values;
    }

    /**
     * convert cursor to account
     */
    private Jogging cursorToPlan(Cursor cursor) {
        String idPlan = cursor.getString(cursor.getColumnIndex(COLUMN_JOGGING_IDPLAN));
        String datePlan = cursor.getString(cursor.getColumnIndex(COLUMN_JOGGING_DATEPLAN));
        int duration = cursor.getInt(cursor.getColumnIndex(COLUMN_JOGGING_DURATION));
        float  numKm = cursor.getFloat(cursor.getColumnIndex(COLUMN_JOGGING_NUMKM));

        Jogging plan = new Jogging(idPlan, datePlan, duration, numKm);
        return plan;
    }
}
