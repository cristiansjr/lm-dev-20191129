package com.math.interpeter.service.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"infix",
"postfix",
"result"
})
@Data
public class ResponsePostfixInfix implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("infix")
	private String infix;
	@JsonProperty("postfix")
	private String postfix;
	@JsonProperty("result")
	private Double result;

}
