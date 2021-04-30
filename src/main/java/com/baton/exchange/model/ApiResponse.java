package com.baton.exchange.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
	
	private String status;
	@JsonInclude(Include.NON_EMPTY)
	private String message;
    @JsonInclude(Include.NON_EMPTY)
	private Object data;

}
