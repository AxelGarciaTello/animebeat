package com.miau.animebeat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.miau.animebeat.exception.BusinessException;
import com.miau.animebeat.integration.repository.INoticiaRepository;
import com.miau.animebeat.model.Noticia;
import com.miau.animebeat.service.INoticiaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoticiaServiceImpl implements INoticiaService {

    @Autowired
    private INoticiaRepository iNoticiaRepository;

    @Override
    public List<Noticia> obtenerNoticias() throws BusinessException {
        try {
            return iNoticiaRepository.obtenerNoticias();
        } catch(Exception e) {
            throw new BusinessException(HttpStatus.CONFLICT,"Error en el proceso", e.getMessage());
        }
    }

    @Override
    public Noticia obtenerNoticia(Long idNoticia) throws BusinessException {
        try {
            return iNoticiaRepository.obtenerNoticia(idNoticia);
        } catch(Exception e) {
            throw new BusinessException(HttpStatus.CONFLICT,"Error en el proceso", e.getMessage());
        }
    }
    
}
