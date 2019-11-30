package com.math.interpeter.expression.handler;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.math.interpeter.exception.InvalidExpressionException;
import com.math.interpeter.expression.handler.implementation.HandleInfixPostfixImp;
import com.math.interpeter.expression.handler.pojo.ResponseHandlerExpression;

public class HandleInfixPostfixImpTest {

	@Test
	public void successHandleInfixPostFix() {
		HandleInfixPostfixImp handle = new HandleInfixPostfixImp();
		ResponseHandlerExpression response = null;
		try {
			response = handle.handle("1+2.5/3*4");
		} catch (InvalidExpressionException e) {
			e.printStackTrace();
		}
		assertTrue("12.53/4*+".equals(response.postfixExp));
	}
}
