package com.example.op.fitnessdiary.Celebrate;

/**
 * Created by OP on 12/24/2016.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.op.fitnessdiary.R;

public class Celebrate_footer extends Fragment {
    private EditText editStatus;
    private TextView textviewStatus;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)
        View view= inflater.inflate(R.layout.acitivity_celebrate_footer, container, false);

        editStatus =  (EditText) view.findViewById(R.id.editText_celebrate_status);
        textviewStatus = (TextView) view.findViewById(R.id.textView_celcebrate_status);

        editStatus.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                    textviewStatus.setText(s);
            }
        });

        return view;
    }



}