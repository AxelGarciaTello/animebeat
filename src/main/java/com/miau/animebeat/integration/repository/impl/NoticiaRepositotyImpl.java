package com.miau.animebeat.integration.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.miau.animebeat.exception.BusinessException;
import com.miau.animebeat.integration.repository.INoticiaRepository;
import com.miau.animebeat.model.Noticia;

@Repository
public class NoticiaRepositotyImpl implements INoticiaRepository {

    @Override
    public List<Noticia> obtenerNoticias() throws BusinessException {
        try {
            List<Noticia> noticias = new ArrayList<>();

            Noticia noticia1 = new Noticia();
            noticia1.setIdNoticia((long)1);
            noticia1.setTitulo("El rick es Gay");
            noticia1.setNoticia("Se ha confirmado lo que todo el mundo ya sabia, el Richy es joto");
            noticia1.setCveUsuarioAlta("El Miau");
            noticia1.setStpAlta("03/04/2025 12:25:00");
            noticias.add(noticia1);

            Noticia noticia2 = new Noticia();
            noticia2.setIdNoticia((long)2);
            noticia2.setTitulo("Lolis legales???");
            noticia2.setNoticia("Se habla de un avistamiento de una loli legal en una convención");
            noticia2.setCveUsuarioAlta("El Miau");
            noticia2.setStpAlta("03/04/2025 12:25:00");
            noticias.add(noticia2);

            return noticias;
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consulta",e.getMessage());
        }
    }

    @Override
    public Noticia obtenerNoticia(Long idNoticia) throws BusinessException {
        try {
            Noticia noticia = new Noticia();
            switch (Long.toString(idNoticia)) {
                case "1":
                    noticia.setIdNoticia((long)1);
                    noticia.setTitulo("El rick es Gay");
                    noticia.setNoticia("Se ha confirmado lo que todo el mundo ya sabia, el Richy es joto");
                    noticia.setCveUsuarioAlta("El Miau");
                    noticia.setStpAlta("03/04/2025 12:25:00");
                    return noticia;
                case "2":
                    noticia.setIdNoticia((long)2);
                    noticia.setTitulo("Lolis legales???");
                    noticia.setNoticia("Se habla de un avistamiento de una loli legal en una convención");
                    noticia.setCveUsuarioAlta("El Miau");
                    noticia.setStpAlta("03/04/2025 12:25:00");
                    return noticia;
                default:
                    break;
            }
            return null;
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consulta",e.getMessage());
        }
    }


    
}
