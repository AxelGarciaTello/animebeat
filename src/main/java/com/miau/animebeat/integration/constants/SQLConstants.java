package com.miau.animebeat.integration.constants;

public class SQLConstants {

    public static final String QS_NOTICIAS = ""
        + "SELECT ID_NOTICIA, TITULO, NOTICIA, CVE_USUARIO_ALTA, STP_ALTA "
        + "FROM T_NOTICIA "
        + "WHERE CVE_USUARIO_BAJA IS NULL";

    public static final String QS_NOTICIA = ""
        + "SELECT ID_NOTICIA, TITULO, NOTICIA, CVE_USUARIO_ALTA, STP_ALTA "
        + "FROM T_NOTICIA "
        + "WHERE ID_NOTICIA = ? AND CVE_USUARIO_BAJA IS NULL";

    public static final String QS_IMAGEN_NOTICIA = ""
        + "SELECT ID_IMAGEN_NOTICIA, ID_NOTICIA, NOM_IMAGEN, REF_UID "
        + "FROM T_IMAGEN_NOTICIA "
        + "WHERE ID_NOTICIA = ? AND CVE_USUARIO_BAJA IS NULL";

}
