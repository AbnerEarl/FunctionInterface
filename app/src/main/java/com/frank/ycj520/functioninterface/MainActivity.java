package com.frank.ycj520.functioninterface;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.frank.ycj520.functioninterface.base.BaseActivity;
import com.frank.ycj520.functioninterface.base.BaseFragment;
import com.frank.ycj520.functioninterface.struct.FunctionNoParameterNoResult;


public class MainActivity extends BaseActivity {

    private BlankFragment blankFragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(blankFragment==null){
            blankFragment = new BlankFragment();
        }
        //创建FragmentManager对象
        FragmentManager manager = getFragmentManager();
        //创建FragmentTransaction事务对象
        FragmentTransaction fragmentTransaction =manager.beginTransaction();
        //使用replace（将要替换位置的i的，替换的页面）方法实现页面的替换
        fragmentTransaction.replace(R.id.fragment_container, blankFragment);
        //提交事务
        fragmentTransaction.commit();

    }

    @Override
    public void setFunctionsForFragment(int id) {
        BaseFragment baseFragment=(BaseFragment)fragmentManager.findFragmentById(id);
        baseFragment.setFunctionsManager(functionsManager.addFunction(new FunctionNoParameterNoResult(BlankFragment.FUNCTION_NAME) {
            @Override
            public void function() {
                Toast.makeText(MainActivity.this,"test method",Toast.LENGTH_LONG).show();
            }
        }));
    }


//    public void setFunctionsForFragment(int id){
//        FragmentManager fragmentManager=getSupportFragmentManager();
////        BaseFragment baseFragment=(BaseFragment)fragmentManager.findFragmentByTag(tag);
//        BaseFragment baseFragment=(BaseFragment)fragmentManager.findFragmentById(id);
//        if (baseFragment==null){
//            return;
//        }
//        FunctionsManager functionsManager=FunctionsManager.getInstance();
//        baseFragment.setFunctionsManager(functionsManager.addFunction(new FunctionNoParameterNoResult(BlankFragment.FUNCTION_NAME) {
//            @Override
//            public void function() {
//                Toast.makeText(MainActivity.this,"ddd",Toast.LENGTH_LONG).show();
//            }
//        }));
//
//    }
}
