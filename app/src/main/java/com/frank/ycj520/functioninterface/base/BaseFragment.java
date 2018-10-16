package com.frank.ycj520.functioninterface.base;

import android.app.Fragment;
import android.content.Context;
//import android.support.v4.app.Fragment;


import com.frank.ycj520.functioninterface.MainActivity;
import com.frank.ycj520.functioninterface.struct.FunctionsManager;

public class BaseFragment extends Fragment {
    protected FunctionsManager functionsManager;
    private MainActivity mBaseActivity;

    public void setFunctionsManager(FunctionsManager functionsManager) {
        this.functionsManager = functionsManager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            mBaseActivity=(MainActivity)context;
            //mBaseActivity.setFunctionsForFragment(getTag());
            mBaseActivity.setFunctionsForFragment(getId());

        }
    }
}
