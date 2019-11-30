package com.math.interpeter.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.math.interpeter.evaluate.model.IEvaluateExpression;
import com.math.interpeter.exception.InvalidExpressionException;
import com.math.interpeter.service.pojo.RequestPostfixInfix;
import com.math.interpeter.service.pojo.ResponseErrorPostfixInfix;
import com.math.interpeter.service.pojo.ResponsePostfixInfix;
import com.math.interpeter.util.ServiceUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InfixPostfixProcess {
	private IEvaluateExpression<RequestPostfixInfix, ResponsePostfixInfix> evaluateImp;
	private Environment env;
	
	private static final String LOG_RESPONSE_MESSAGE = "Response Body PostfixInfixProcess: {}";
	
	@Autowired
	public InfixPostfixProcess(IEvaluateExpression<RequestPostfixInfix, ResponsePostfixInfix> evaluateImp, Environment env) {
		this.evaluateImp = evaluateImp;
		this.env = env;
	}
	
	/**
	 * 
	 * @param request request del servicio en el se encuentra la expresión a evaluar
	 * @return retorna la respuesta del sevicio Response Entity (incluye código de respuesta HTTP y el body de la respuesta)
	 */
	public ResponseEntity<?> process(RequestPostfixInfix request) {
		log.info("Request PostfixInfixProcess: {}", ServiceUtils.objToString(request));
		try {
			ResponsePostfixInfix response = evaluateImp.evaluateExpression(request);
			log.info(LOG_RESPONSE_MESSAGE, ServiceUtils.objToString(request));
			return new ResponseEntity<>(response, HttpStatus.resolve(Integer.parseInt(env.getProperty("response-codes.http.success"))));
		}catch (InvalidExpressionException e) {
			ResponseErrorPostfixInfix response = new ResponseErrorPostfixInfix();
			response.setMessage("The expression".concat(request.getExp()).concat("is invalid"));
			log.info(LOG_RESPONSE_MESSAGE, ServiceUtils.objToString(response));
			return new ResponseEntity<>(response, HttpStatus.resolve(Integer.parseInt(env.getProperty("response-codes.http.expression-error"))));
		}catch (Exception e) {
			ResponseErrorPostfixInfix response = new ResponseErrorPostfixInfix();
			response.setMessage("Some error ocurred while processing the expression");
			log.info(LOG_RESPONSE_MESSAGE, ServiceUtils.objToString(response));
			return new ResponseEntity<>(response, HttpStatus.resolve(Integer.parseInt(env.getProperty("response-codes.http.general-error"))));
		}
	}

}
