package com.math.interpeter.expression.calculate;

import static org.junit.Assert.assertTrue;

import javax.script.ScriptException;

import org.junit.Test;

import com.math.interpeter.expression.calculate.implementation.CalculateInfixPostfixImp;
import com.math.interpeter.expression.handler.pojo.ResponseHandlerExpression;
import com.math.interpeter.service.pojo.ResponsePostfixInfix;

public class CalculatePostfixImpTest {
	
	@Test
	public void successCalculate() throws ScriptException {
		CalculateInfixPostfixImp calcImp = new CalculateInfixPostfixImp();
		ResponseHandlerExpression request = new ResponseHandlerExpression();
		request.setInfixExp("1+2/3*4");
		request.setPostfixExp("123/4*+");
		ResponsePostfixInfix response = calcImp.calculate(request);
		assertTrue(response != null);
	}

}
