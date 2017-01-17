package com.example.op.fitnessdiary.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.op.fitnessdiary.ClassObject.Account;
import com.example.op.fitnessdiary.ClassObject.Plan;

import java.util.ArrayList;

/**
 * Created by OP on 1/17/2017.
 */

public class DBPlanHelper extends DBHelper {

    public DBPlanHelper(Context context) {
        super(context);
    }

    /**
     * get Plan by sql command
     *
     * @param sql sql to get Plan
     */
    public Plan getPlan(String sql) {
        Plan plan = null;
        Cursor cursor = getAll(sql);
        if (cursor != null) {
            plan = cursorToPlan(cursor);
            cursor.close();
        }
        return plan;
    }

    /**
     * @param sql get all plan with sql command
     * @return arraylist of plan
     */
    public ArrayList<Plan> getListPlan(String sql) {
        ArrayList<Plan> list = new ArrayList<>();
        Cursor cursor = getAll(sql);

        while (!cursor.isAfterLast()) {
            list.add(cursorToPlan(cursor));
            cursor.moveToNext();
        }
        cursor.close();

        return list;
    }

    /**
     * insert Plan to table
     *
     * @param  plan to insert
     * @return id of Plan
     */
    public long insertPlan(Plan plan) {
        return this.insert(TABLE_PLAN, planToValues(plan));
    }

    /**
     * @param  plan to update
     * @return id of Plan update
     */
    public boolean updatePlan(Plan plan) {
        return update(TABLE_PLAN, planToValues(plan), COLUMN_PLAN_ID+ " = " + plan.getId());
    }

    /**
     * delete id row of table
     */
    public boolean deletePlan(String where) {
        return delete(TABLE_PLAN, where);
    }

    /**
     * convert account to contentvalues
     * don't put id of account because
     * when insert id will auto create
     * when update we don't update id
     */
    private ContentValues planToValues(Plan plan) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_PLAN_ID, plan.getId());
        values.put(COLUMN_PLAN_NUMDAYS, plan.getNumdays());
        values.put(COLUMN_PLAN_STATUS, plan.getStatus());

        return values;
    }

    /**
     * convert cursor to account
     */
    private Plan cursorToPlan(Cursor cursor) {
        String id = cursor.getString(cursor.getColumnIndex(COLUMN_PLAN_ID));
        int numdays = cursor.getInt(cursor.getColumnIndex(COLUMN_PLAN_NUMDAYS));
        int  status = cursor.getInt(cursor.getColumnIndex(COLUMN_PLAN_STATUS));
        Plan plan = new Plan(id, numdays, status);
        return plan;
    }
}
