package com.miau.animebeat.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class RespuestaError {
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Código de estatus HTTP")
	private String code;  //"HTTP Status code"
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Descripción de código de estatus HTTP")
	private String description;  // HTTP Status description
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Mensaje de error de negocio")
	private String businessMessage;  // Mensaje de negocio
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Mensaje de la excepción real")
	private String reasonPhrase;  // Mensaje de la excepción real
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Para uso futuro")
	private String uri;  // Para uso futuro
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Para uso futuro")
	private String contactEmail; // Para uso futuro
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Fecha y hora en la que se genera la excepción")
	private String timeStamp;  // Fecha y hora de la excepcion

    public RespuestaError(HttpStatus status, String businessMessage, String reasonPhrase) {
		this.code = String.valueOf(status.value());
		this.description = status.getReasonPhrase();
		this.businessMessage = businessMessage;
		this.reasonPhrase = reasonPhrase;
		this.uri = "";

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

		this.timeStamp = dateFormat.format(new Date());
    }
}
