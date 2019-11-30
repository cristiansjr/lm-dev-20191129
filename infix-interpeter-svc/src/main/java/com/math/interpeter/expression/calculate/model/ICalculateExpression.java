package com.math.interpeter.expression.calculate.model;

import javax.script.ScriptException;

public interface ICalculateExpression<I, O> {
	public O calculate (I request) throws ScriptException;
}
