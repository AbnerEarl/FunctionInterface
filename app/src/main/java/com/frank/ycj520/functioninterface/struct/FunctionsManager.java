package com.frank.ycj520.functioninterface.struct;

import android.text.TextUtils;

import java.util.HashMap;

public class FunctionsManager {
    private static FunctionsManager instance;
    private FunctionsManager(){
        mFunctionNoParameterNoResult=new HashMap<>();
        mFunctionNoParameterWithResult=new HashMap<>();
        mFunctionWithParameterNoResult=new HashMap<>();
        mFunctionWithParameterWithResult=new HashMap<>();
    }

    public static FunctionsManager getInstance(){
        if (instance==null){
            instance=new FunctionsManager();
        }
        return instance;
    }

    private HashMap<String,FunctionNoParameterNoResult> mFunctionNoParameterNoResult;
    private HashMap<String,FunctionNoParameterWithResult> mFunctionNoParameterWithResult;
    private HashMap<String,FunctionWithParameterNoResult> mFunctionWithParameterNoResult;
    private HashMap<String,FunctionWithParameterWithResult> mFunctionWithParameterWithResult;

    public FunctionsManager addFunction(FunctionNoParameterNoResult function){
        mFunctionNoParameterNoResult.put(function.mFunctionName,function);
        return this;
    }

    public void invokeFunction(String functionName){
        if (TextUtils.isEmpty(functionName)){
            return;
        }
        if (mFunctionNoParameterNoResult!=null){
            FunctionNoParameterNoResult func=mFunctionNoParameterNoResult.get(functionName);
            if (func!=null){
                func.function();
            }else {
                try {
                    throw new FunctionException("Has no this function:"+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public FunctionsManager addFunction(FunctionNoParameterWithResult function){
        mFunctionNoParameterWithResult.put(function.mFunctionName,function);
        return this;
    }

    public <Result>Result invokeFunction(String functionName,Class<Result> c){
        if (TextUtils.isEmpty(functionName)){
            return null;
        }
        if (mFunctionNoParameterWithResult!=null){
            FunctionNoParameterWithResult func=mFunctionNoParameterWithResult.get(functionName);
            if (func!=null){
                if (c!=null){
                    return c.cast(func.function());
                }else {
                    return (Result) func.function();
                }

            }else {
                try {
                    throw new FunctionException("Has no this function:"+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    public FunctionsManager addFunction(FunctionWithParameterNoResult function){
        mFunctionWithParameterNoResult.put(function.mFunctionName,function);
        return this;
    }

    public <Param> void invokeFunction(String functionName,Param data){
        if (TextUtils.isEmpty(functionName)){
            return ;
        }
        if (mFunctionWithParameterNoResult!=null){
            FunctionWithParameterNoResult func=mFunctionWithParameterNoResult.get(functionName);
            if (func!=null){
                func.function(data);
            }else {
                try {
                    throw new FunctionException("Has no this function:"+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public FunctionsManager addFunction(FunctionWithParameterWithResult function){
        mFunctionWithParameterWithResult.put(function.mFunctionName,function);
        return this;
    }

    public <Result,Param> Result invokeFunction(String functionName,Param data,Class<Result> c){
        if (TextUtils.isEmpty(functionName)){
            return null;
        }
        if (mFunctionWithParameterWithResult!=null){
            FunctionWithParameterWithResult func=mFunctionWithParameterWithResult.get(functionName);
            if (func!=null){
                if (c!=null){
                    return c.cast(func.function(data));
                }else {
                    return (Result)func.function(data);
                }
            }else {
                try {
                    throw new FunctionException("Has no this function:"+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
