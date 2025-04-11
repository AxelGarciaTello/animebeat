package com.miau.animebeat.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImagenNoticia {

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Identificador de la imagen")
    private Long idImagenNoticia;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Identificador de la noticia")
    private Long idNoticia;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Nombre de la imagen")
    private String nomImagen;
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Referencia de la imagen")
    private String refUid;
    
}
