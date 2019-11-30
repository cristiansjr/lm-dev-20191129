package com.math.interpeter.expression.handler.model;

import com.math.interpeter.exception.InvalidExpressionException;

public interface IHandleExpression <I, O>{
	public O handle(I request) throws InvalidExpressionException;

}
