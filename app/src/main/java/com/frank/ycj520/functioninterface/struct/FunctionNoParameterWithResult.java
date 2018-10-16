package com.frank.ycj520.functioninterface.struct;

public abstract class FunctionNoParameterWithResult<Result> extends Function {
    public FunctionNoParameterWithResult(String functionName) {
        super(functionName);
    }

    public abstract Result function();
}
