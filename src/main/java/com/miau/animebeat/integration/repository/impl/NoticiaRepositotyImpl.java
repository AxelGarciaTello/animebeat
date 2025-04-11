package com.miau.animebeat.integration.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.miau.animebeat.exception.BusinessException;
import com.miau.animebeat.integration.constants.SQLConstants;
import com.miau.animebeat.integration.repository.INoticiaRepository;
import com.miau.animebeat.model.ImagenNoticia;
import com.miau.animebeat.model.Noticia;

@Repository
public class NoticiaRepositotyImpl implements INoticiaRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Noticia> obtenerNoticias() throws BusinessException {
        try {
            return jdbcTemplate.query(
                SQLConstants.QS_NOTICIAS,
                BeanPropertyRowMapper.newInstance(Noticia.class));
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consulta",e.getMessage());
        }
    }

    @Override
    public Noticia obtenerNoticia(Long idNoticia) throws BusinessException {
        try {
            return jdbcTemplate.queryForObject(
                SQLConstants.QS_NOTICIA, 
                BeanPropertyRowMapper.newInstance(Noticia.class),
                idNoticia);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consulta",e.getMessage());
        }
    }

    @Override
    public ImagenNoticia obtenerImagenNoticia(Long idNoticia) throws BusinessException {
        try {
            return jdbcTemplate.queryForObject(
                SQLConstants.QS_IMAGEN_NOTICIA, 
                BeanPropertyRowMapper.newInstance(ImagenNoticia.class), 
                idNoticia);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consulta",e.getMessage());
        }
    }


    
}
