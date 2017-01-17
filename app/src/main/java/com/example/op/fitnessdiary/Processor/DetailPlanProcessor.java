package com.example.op.fitnessdiary.Processor;

import android.content.Context;

import com.example.op.fitnessdiary.ClassObject.DetailPlan;
import com.example.op.fitnessdiary.ClassObject.Plan;
import com.example.op.fitnessdiary.DAO.DBDetailPlanHelper;
import com.example.op.fitnessdiary.DAO.DBPlanHelper;

/**
 * Created by OP on 1/17/2017.
 */

public class DetailPlanProcessor {
    private static DetailPlanProcessor sInstance;

    private DetailPlanProcessor() {}

    public static synchronized DetailPlanProcessor getInstance() {
        if (sInstance == null) {
            sInstance = new DetailPlanProcessor();
        }
        return sInstance;
    }

    public boolean insertDetailPlan(DetailPlan detailPlan, Context context)
    {
        DBDetailPlanHelper db = new DBDetailPlanHelper(context);

        return db.insertDetailPlan(detailPlan) > 0;
    }
}
