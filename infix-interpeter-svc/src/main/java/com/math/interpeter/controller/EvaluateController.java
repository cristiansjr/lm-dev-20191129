package com.math.interpeter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.math.interpeter.process.InfixPostfixProcess;
import com.math.interpeter.service.pojo.RequestPostfixInfix;

@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
	private InfixPostfixProcess postfixInfixProcess;
	
	@Autowired
	public EvaluateController(InfixPostfixProcess postfixInfixProcess) {
		this.postfixInfixProcess = postfixInfixProcess;
	}
	
	@PostMapping
	public ResponseEntity<?> testController(@RequestBody RequestPostfixInfix request){
		
		return postfixInfixProcess.process(request);
	}

}
