package com.math.interpeter.expression.handler.implementation;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.math.interpeter.exception.InvalidExpressionException;
import com.math.interpeter.expression.handler.model.IHandleExpression;
import com.math.interpeter.expression.handler.pojo.ResponseHandlerExpression;

@Service
public class HandleInfixPostfixImp implements IHandleExpression<String, ResponseHandlerExpression> {

	@Override
	public ResponseHandlerExpression handle(String request) throws InvalidExpressionException {
		ResponseHandlerExpression response = new ResponseHandlerExpression();
		LinkedList<String> operatorStack = new LinkedList<>();
		String banderaPuntoAnteriormente = "N";
		String banderaOperadorAnteriormente = "N";
		String outputStack = "";
		if (request != null || !"".equals(request)) {
			for (int i = 0; i < request.length(); i++) {
				char c = request.charAt(i);
				if (i == 0 && !Character.isDigit(c)) {
					throw new InvalidExpressionException("002", "Primer valor de la cadena invalido");
				}
				if ("Y".equals(banderaPuntoAnteriormente) && c == '.')
					throw new InvalidExpressionException("003", "Numero invalido");
				if(Character.isDigit(c) || c == '.') {
					outputStack += c;
					if (c == '.') {
						banderaPuntoAnteriormente = "Y";
					}
						
				}
				if (isAnOperator(c)) {
					char primerOperadorStack = 0;
					if(!operatorStack.isEmpty())
						primerOperadorStack = operatorStack.getFirst().charAt(0);
					if ("Y".equals(banderaOperadorAnteriormente)) {
						throw new InvalidExpressionException("004", "Expresion invalida");
					} else {
						
						 if(operatorStack.isEmpty()) {
							 String operador = "";
							 operador += c;
							 operatorStack.add(operador);
							 if("Y".equals(banderaPuntoAnteriormente))
								 banderaPuntoAnteriormente = "N";
						 } else {
							 if (primerOperadorStack != 0) {
								 if (Prec(c) <= Prec(primerOperadorStack)) {
									 outputStack += primerOperadorStack;
									 operatorStack.removeFirst();
								 } else {
									 String operador = "";
									 operador += c;
									 operatorStack.add(operador);
									 if("Y".equals(banderaPuntoAnteriormente))
										 banderaPuntoAnteriormente = "N";
								 }
							 }
							 
						 }						 
					}
				}
			}
			while (!operatorStack.isEmpty()) {
				String operador = operatorStack.removeFirst();
				outputStack += operador;
				
			}
			response.setInfixExp(request);
			response.setPostfixExp(outputStack);
		} else {
			throw new InvalidExpressionException("001", "Entrada nula o vacía");
		}
		return response;
	}
	
	private int Prec(char ch) {
		switch(ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}
	
	private boolean isAnOperator(char ch) {
		switch(ch) {
		case '+':
		case '-':
		case '*':
		case '/':
			return true;
		} 
		return false;
	}

}
