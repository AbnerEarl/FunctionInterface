package com.frank.ycj520.functioninterface.base;

import android.app.Activity;
import android.app.FragmentManager;

import com.frank.ycj520.functioninterface.BlankFragment;
import com.frank.ycj520.functioninterface.struct.FunctionNoParameterNoResult;
import com.frank.ycj520.functioninterface.struct.FunctionsManager;

public abstract class BaseActivity extends Activity {
    protected FragmentManager fragmentManager= getFragmentManager();
    protected FunctionsManager functionsManager=FunctionsManager.getInstance();

    public abstract void setFunctionsForFragment(int id);
}
