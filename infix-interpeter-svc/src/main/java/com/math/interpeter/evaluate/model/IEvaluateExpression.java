package com.math.interpeter.evaluate.model;

import javax.script.ScriptException;

import com.math.interpeter.exception.InvalidExpressionException;

public interface IEvaluateExpression<I, O> {
	public O evaluateExpression(I request) throws InvalidExpressionException, ScriptException;
}
