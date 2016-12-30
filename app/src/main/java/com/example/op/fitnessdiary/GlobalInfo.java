package com.example.op.fitnessdiary;

/**
 * Created by OP on 12/30/2016.
 */

public class GlobalInfo {
    private static GlobalInfo sInstance;
    public static String curNickname;

    public static synchronized GlobalInfo getInstance() {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new GlobalInfo();
        }
        return sInstance;
    }
}
