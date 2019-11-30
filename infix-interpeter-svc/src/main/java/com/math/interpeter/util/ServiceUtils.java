package com.math.interpeter.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceUtils {
	private ServiceUtils() {
		throw new IllegalStateException("Utility class");
	}
	
	public static String objToString(Object o) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(o);
		}catch (Exception e){
			
			printErrorMessage(e,"objToString");
			return null;
		}
	}
	
	public static void printErrorMessage(Exception e, String method) {
		try {
			int linea = 0;
			if (e.getStackTrace().length > 0) {
				linea = e.getStackTrace()[0].getLineNumber();
				method = e.getStackTrace()[0].getMethodName();
			}
			
			log.error("Microservicio giftcode-svc: error: {}  en linea: {} en metodo: {}", e, linea, method);
		} catch (Exception exception) {
			printErrorMessage(exception,"printErrorMessage");
		}
	}

}
