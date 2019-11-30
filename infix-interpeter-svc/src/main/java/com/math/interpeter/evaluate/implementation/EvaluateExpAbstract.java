package com.math.interpeter.evaluate.implementation;

import javax.script.ScriptException;

import org.springframework.stereotype.Service;

import com.math.interpeter.evaluate.model.IEvaluateExpression;
import com.math.interpeter.exception.InvalidExpressionException;

@Service
public abstract class EvaluateExpAbstract<I, O, M> implements IEvaluateExpression<I, O> {

	@Override
	public O evaluateExpression(I request) throws InvalidExpressionException, ScriptException {
		
		return calculateResult(handleInput(request));
	}

	abstract M handleInput(I request) throws InvalidExpressionException;
	
	abstract O calculateResult(M request) throws ScriptException;
}
