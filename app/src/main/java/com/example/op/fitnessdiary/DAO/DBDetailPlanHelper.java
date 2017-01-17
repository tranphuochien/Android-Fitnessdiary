package com.example.op.fitnessdiary.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.op.fitnessdiary.ClassObject.DetailPlan;
import com.example.op.fitnessdiary.ClassObject.Plan;

import java.util.ArrayList;

/**
 * Created by OP on 1/17/2017.
 */

public class DBDetailPlanHelper extends DBHelper {
    public DBDetailPlanHelper(Context context) {
        super(context);
    }

    public DetailPlan getDetailPlan(String sql) {
        DetailPlan plan = null;
        Cursor cursor = getAll(sql);
        if (cursor != null) {
            plan = cursorToDetailPlan(cursor);
            cursor.close();
        }
        return plan;
    }

    /**
     * @param sql get all plan with sql command
     * @return arraylist of plan
     */
    public ArrayList<DetailPlan> getListDetailPlan(String sql) {
        ArrayList<DetailPlan> list = new ArrayList<>();
        Cursor cursor = getAll(sql);

        while (!cursor.isAfterLast()) {
            list.add(cursorToDetailPlan(cursor));
            cursor.moveToNext();
        }
        cursor.close();

        return list;
    }

    /**
     * insert DetailPlan to table
     *
     * @param  detailPlan to insert
     * @return id of DetailPlan
     */
    public long insertDetailPlan(DetailPlan detailPlan) {
        return this.insert(TABLE_DETAILPLAN, detailPlanToValues(detailPlan));
    }

    /**
     * @param  detailPlan to update
     * @return id of DetailPlan update
     */
    public boolean updateDetailPlan(DetailPlan detailPlan) {
        return update(TABLE_DETAILPLAN, detailPlanToValues(detailPlan), COLUMN_DETAILPLAN_ID+ " = " + detailPlan.getId());
    }

    /**
     * delete id row of table
     */
    public boolean deleteDetailPlan(String where) {
        return delete(TABLE_DETAILPLAN, where);
    }

    /**
     * convert account to contentvalues
     * don't put id of account because
     * when insert id will auto create
     * when update we don't update id
     */
    private ContentValues detailPlanToValues(DetailPlan plan) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_DETAILPLAN_ID, plan.getId());
        values.put(COLUMN_DETAILPLAN_IDPLAN, plan.getIdPlan());
        values.put(COLUMN_DETAILPLAN_DATEPLAN, plan.getDatePlan());
        values.put(COLUMN_DETAILPLAN_IDTRAINNINGMETHOD, plan.getIdMethod());
        values.put(COLUMN_DETAILPLAN_STATUS, plan.getStatus());

        return values;
    }

    /**
     * convert cursor to account
     */
    private DetailPlan cursorToDetailPlan(Cursor cursor) {
        String id = cursor.getString(cursor.getColumnIndex(COLUMN_DETAILPLAN_ID));
        String idPlan = cursor.getString(cursor.getColumnIndex(COLUMN_DETAILPLAN_IDPLAN));
        String datePlan = cursor.getString(cursor.getColumnIndex(COLUMN_DETAILPLAN_DATEPLAN));
        int idMethod = cursor.getInt(cursor.getColumnIndex(COLUMN_DETAILPLAN_IDTRAINNINGMETHOD));
        int  status = cursor.getInt(cursor.getColumnIndex(COLUMN_DETAILPLAN_STATUS));

        DetailPlan plan = new DetailPlan(id,idPlan, datePlan, idMethod, status);
        return plan;
    }
}
