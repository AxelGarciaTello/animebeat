package com.miau.animebeat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miau.animebeat.exception.BusinessException;
import com.miau.animebeat.model.Noticia;
import com.miau.animebeat.model.RespuestaError;
import com.miau.animebeat.service.INoticiaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("animebeat/v1")
public class NoticiaController {

    @Autowired
    private INoticiaService iNoticiaService;

    @Operation(summary = "Lista de noticias", description = "Obtiene todas las noticias", tags = { "Noticias" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Noticia.class))
        }),
        @ApiResponse(responseCode = "204", description = "Sin coincidencias"),
        @ApiResponse(responseCode = "500", description = "Error interno", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaError.class))
        })
    })
    @GetMapping(value = "/noticias", produces = { "application/json" })
    public ResponseEntity<?> obtenerNoticias () {
        try {
            List<Noticia> noticias = iNoticiaService.obtenerNoticias();
            if (noticias.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(noticias, HttpStatus.OK);
        } catch (BusinessException be) {
			log.error("Error al consultar: {}", be.getMessage());
			int numberHTTPDesired = Integer.parseInt(be.getRespuestaError().getCode());
			RespuestaError respuestaError = be.getRespuestaError();
			return new ResponseEntity<>(respuestaError, HttpStatus.valueOf(numberHTTPDesired));
		} catch (Exception e) {
			log.error("Exception al consultar", e);
		}
        return null;
    }

    @Operation(summary = "Obtención de noticia", description = "Obtiene una noticia", tags = { "Noticias" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Noticia.class))
        }),
        @ApiResponse(responseCode = "204", description = "Sin coincidencias"),
        @ApiResponse(responseCode = "500", description = "Error interno", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaError.class))
        })
    })
    @GetMapping(value = "/noticas/{idNoticia}", produces = { "application/json" })
    public ResponseEntity<?> obtenerNoticia (
        @Parameter(in = ParameterIn.DEFAULT, description = "Id de la noticia", schema = @Schema()) @PathVariable Long idNoticia
    ) {
        try {
            return new ResponseEntity<>(iNoticiaService.obtenerNoticia(idNoticia), HttpStatus.OK);
        } catch (BusinessException be) {
			log.error("Error al consultar: {}", be.getMessage());
			int numberHTTPDesired = Integer.parseInt(be.getRespuestaError().getCode());
			RespuestaError respuestaError = be.getRespuestaError();
			return new ResponseEntity<>(respuestaError, HttpStatus.valueOf(numberHTTPDesired));
		} catch (Exception e) {
			log.error("Exception al consultar", e);
		}
        return null;
    }
    
}
