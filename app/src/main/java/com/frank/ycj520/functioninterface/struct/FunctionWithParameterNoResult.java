package com.frank.ycj520.functioninterface.struct;

public abstract class FunctionWithParameterNoResult<Param> extends Function {
    public FunctionWithParameterNoResult(String functionName) {
        super(functionName);
    }

    public abstract void function(Param data);
}
