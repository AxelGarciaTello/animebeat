package com.miau.animebeat.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Noticia {
    
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Identificador de la noticia")
    private Long idNoticia;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Titulo de la noticia")
    private String titulo;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Noticia")
    private String noticia;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Imagen de la noticia")
    private String imagen;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Persona que escribio la noticia")
    private String cveUsuarioAlta;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Fecha en que se escribio la noticia")
    private String stpAlta;

}
