package com.frank.ycj520.functioninterface.struct;

public abstract class FunctionWithParameterWithResult<Result,Param> extends Function {
    public FunctionWithParameterWithResult(String functionName) {
        super(functionName);
    }

    public abstract Result function(Param data);
}
