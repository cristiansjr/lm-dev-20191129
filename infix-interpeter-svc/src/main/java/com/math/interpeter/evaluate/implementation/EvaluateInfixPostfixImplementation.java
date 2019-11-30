package com.math.interpeter.evaluate.implementation;

import javax.script.ScriptException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.math.interpeter.exception.InvalidExpressionException;
import com.math.interpeter.expression.calculate.model.ICalculateExpression;
import com.math.interpeter.expression.handler.model.IHandleExpression;
import com.math.interpeter.expression.handler.pojo.ResponseHandlerExpression;
import com.math.interpeter.service.pojo.RequestPostfixInfix;
import com.math.interpeter.service.pojo.ResponsePostfixInfix;

@Service
public class EvaluateInfixPostfixImplementation extends EvaluateExpAbstract<RequestPostfixInfix, ResponsePostfixInfix, ResponseHandlerExpression>{
	private IHandleExpression<String, ResponseHandlerExpression> handleExpressionImp;
	private ICalculateExpression<ResponseHandlerExpression, ResponsePostfixInfix> calculateExpressionImp;
	
	@Autowired
	public EvaluateInfixPostfixImplementation(IHandleExpression<String, ResponseHandlerExpression> handleExpressionImp,
			ICalculateExpression<ResponseHandlerExpression, ResponsePostfixInfix> calculateExpressionImp) {
		this.handleExpressionImp = handleExpressionImp;
		this.calculateExpressionImp = calculateExpressionImp;
	}

	@Override
	ResponseHandlerExpression handleInput(RequestPostfixInfix request) throws InvalidExpressionException {
		return handleExpressionImp.handle(request.getExp());
	}

	@Override
	ResponsePostfixInfix calculateResult(ResponseHandlerExpression request) throws ScriptException {
		return calculateExpressionImp.calculate(request);
	}

}
