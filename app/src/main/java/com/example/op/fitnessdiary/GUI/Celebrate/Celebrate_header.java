package com.example.op.fitnessdiary.GUI.Celebrate;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.op.fitnessdiary.R;

/**
 * Created by OP on 12/24/2016.
 */

public class Celebrate_header extends Fragment {
    private Celebrate_main mainCelebrate;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Đọc file xml tạo ra đối tượng View.

        // inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)

        View view= inflater.inflate(R.layout.activity_celebration_header, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Celebrate_main) {
            this.mainCelebrate = (Celebrate_main) context;
        }
    }

}