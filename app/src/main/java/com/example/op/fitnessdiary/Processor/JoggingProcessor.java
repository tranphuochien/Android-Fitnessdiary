package com.example.op.fitnessdiary.Processor;

import android.content.Context;

import com.example.op.fitnessdiary.ClassObject.DetailPlan;
import com.example.op.fitnessdiary.ClassObject.ListExercise.Jogging;
import com.example.op.fitnessdiary.DAO.DBDetailPlanHelper;
import com.example.op.fitnessdiary.DAO.DBJoggingHelper;

/**
 * Created by OP on 1/17/2017.
 */

public class JoggingProcessor extends ExerciseProcessor {
    private static JoggingProcessor sInstance;

    private JoggingProcessor() {}

    public static synchronized JoggingProcessor getInstance() {
        if (sInstance == null) {
            sInstance = new JoggingProcessor();
        }
        return sInstance;
    }

    public boolean insertJogging(Jogging jogging, Context context)
    {
        DBJoggingHelper db = new DBJoggingHelper(context);

        return db.insertJogging(jogging) > 0;
    }
}
