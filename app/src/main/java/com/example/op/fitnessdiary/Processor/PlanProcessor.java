package com.example.op.fitnessdiary.Processor;

import android.content.Context;

import com.example.op.fitnessdiary.ClassObject.Account;
import com.example.op.fitnessdiary.ClassObject.Plan;
import com.example.op.fitnessdiary.DAO.DBAccountHelper;
import com.example.op.fitnessdiary.DAO.DBPlanHelper;

/**
 * Created by OP on 1/17/2017.
 */

public class PlanProcessor {
    private static PlanProcessor sInstance;

    private PlanProcessor() {}

    public static synchronized PlanProcessor getInstance() {
        if (sInstance == null) {
            sInstance = new PlanProcessor();
        }
        return sInstance;
    }

    public boolean insertPlan(Plan plan, Context context)
    {
        DBPlanHelper db = new DBPlanHelper(context);

        return db.insertPlan(plan) > 0;
    }
}
