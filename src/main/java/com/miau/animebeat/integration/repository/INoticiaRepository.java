package com.miau.animebeat.integration.repository;

import java.util.List;

import com.miau.animebeat.exception.BusinessException;
import com.miau.animebeat.model.Noticia;

public interface INoticiaRepository {
    
    List<Noticia> obtenerNoticias() throws BusinessException;
    Noticia obtenerNoticia(Long idNoticia) throws BusinessException;

}
