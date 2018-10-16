package com.frank.ycj520.functioninterface;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frank.ycj520.functioninterface.base.BaseFragment;


public class BlankFragment extends BaseFragment {
    public static final String FUNCTION_NAME = BlankFragment.class.getName()+"FF";

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                functionsManager.invokeFunction(FUNCTION_NAME);
            }
        });
        return view;
    }

}
