package com.example.op.fitnessdiary.Processor;

import android.content.Context;

import com.example.op.fitnessdiary.ClassObject.Account;
import com.example.op.fitnessdiary.DAO.DBAccountHelper;
import com.example.op.fitnessdiary.GUI.MainLogin.CreateAccount;

/**
 * Created by OP on 12/30/2016.
 */

public class AccountProcessor {
    private static AccountProcessor sInstance;

    private AccountProcessor() {}

    public static synchronized AccountProcessor getInstance() {
        if (sInstance == null) {
            sInstance = new AccountProcessor();
        }
        return sInstance;
    }

    public boolean insertAccount(Account acc, Context context)
    {
        DBAccountHelper db = new DBAccountHelper(context);

        if (acc.getNickname().isEmpty()||
                acc.getEmail().isEmpty() ||
                acc.getDOB().isEmpty() ||
                acc.getGender().isEmpty())
            return false;

        return db.insertAccount(acc) > 0;
    }
}
