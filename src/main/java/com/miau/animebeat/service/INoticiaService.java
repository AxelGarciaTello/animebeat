package com.miau.animebeat.service;

import java.util.List;

import com.miau.animebeat.exception.BusinessException;
import com.miau.animebeat.model.Noticia;

public interface INoticiaService {

    List<Noticia> obtenerNoticias() throws BusinessException;
    Noticia obtenerNoticia(Long idNoticia) throws BusinessException;
    
}
