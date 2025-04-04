package com.miau.animebeat.exception;


import lombok.Getter;
import lombok.Setter;

import org.springframework.http.HttpStatus;

import com.miau.animebeat.model.RespuestaError;

@Setter
@Getter
public class BusinessException extends Exception {
	private static final long serialVersionUID = 2044610281664856520L;
	private transient RespuestaError respuestaError;

	public BusinessException(
			HttpStatus status,
			String businessMessage,
			String reasonPhrase) {
		super(reasonPhrase);

        respuestaError = new RespuestaError(status, businessMessage, reasonPhrase);
	}

	public BusinessException(RespuestaError respuestaError) {
		this.respuestaError = respuestaError;
	}
}
