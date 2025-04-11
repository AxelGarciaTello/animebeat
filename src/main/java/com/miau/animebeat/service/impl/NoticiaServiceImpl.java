package com.miau.animebeat.service.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.miau.animebeat.exception.BusinessException;
import com.miau.animebeat.integration.repository.INoticiaRepository;
import com.miau.animebeat.model.ImagenNoticia;
import com.miau.animebeat.model.Noticia;
import com.miau.animebeat.service.INoticiaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoticiaServiceImpl implements INoticiaService {

    @Autowired
    private INoticiaRepository iNoticiaRepository;

    @Value("${file.upload-dir}")
    private String fileSystemPath;

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
            Noticia noticia =  iNoticiaRepository.obtenerNoticia(idNoticia);

            if (noticia == null)
                return null;
            
            ImagenNoticia imagenNoticia = iNoticiaRepository.obtenerImagenNoticia(idNoticia);
            if (imagenNoticia != null) {
	            //Obtener el archivo
	            File dir = new File(fileSystemPath);			
				
				File[] foundFiles = dir.listFiles(new FilenameFilter() {
					public boolean accept(File dir, String name) {
						return name.startsWith(imagenNoticia.getRefUid());
					}
				});
	
	            long lastMod = Long.MIN_VALUE;
				File file = null;
				for (File fileTemp : foundFiles) {
					if (fileTemp.lastModified() > lastMod) {
						file = fileTemp;
						lastMod = fileTemp.lastModified();
					}
				}
	
	            if (file == null || !file.exists())
	                throw new BusinessException(HttpStatus.CONFLICT,"El archivo " + imagenNoticia.getNomImagen() + " no se encuentra registrado en el sistema.", "Imagen no encontrada");
	
	            //Construcción de los objetos
	            byte[] fileBytes = Files.readAllBytes(file.toPath());
	            noticia.setImagen(Base64.getEncoder().encodeToString(fileBytes));
	        }

            return noticia;
        } catch(Exception e) {
            throw new BusinessException(HttpStatus.CONFLICT,"Error en el proceso", e.getMessage());
        }
    }
    
}
