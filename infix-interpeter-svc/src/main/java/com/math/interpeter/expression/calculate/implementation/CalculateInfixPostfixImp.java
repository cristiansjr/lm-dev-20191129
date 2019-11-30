package com.math.interpeter.expression.calculate.implementation;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.stereotype.Service;

import com.math.interpeter.expression.calculate.model.ICalculateExpression;
import com.math.interpeter.expression.handler.pojo.ResponseHandlerExpression;
import com.math.interpeter.service.pojo.ResponsePostfixInfix;

@Service
public class CalculateInfixPostfixImp implements ICalculateExpression<ResponseHandlerExpression, ResponsePostfixInfix> {

	@Override
	public ResponsePostfixInfix calculate(ResponseHandlerExpression request) throws ScriptException {
		ResponsePostfixInfix response = new ResponsePostfixInfix();
		response.setInfix(request.getInfixExp());
		response.setPostfix(request.getPostfixExp());
		ScriptEngineManager mngr = new ScriptEngineManager();
		ScriptEngine eng = mngr.getEngineByName("JavaScript");
		Double value = (Double) eng.eval(request.getInfixExp());
		response.setResult(value);
		return response;
	}

}
