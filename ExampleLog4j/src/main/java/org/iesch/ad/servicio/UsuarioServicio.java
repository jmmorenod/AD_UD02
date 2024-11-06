package org.iesch.ad.servicio;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.iesch.ad.modelo.Usuario;

import java.util.HashMap;
import java.util.Map;

//CRUD
public class UsuarioServicio {
    private static final Logger logger = LogManager.getLogger("UsuarioServicio.class");
    private Map<Integer, Usuario> usuarioDatabase = new HashMap<>();

    //Create
    public void createUsuario (int id, String nombre, String email){
        logger.trace("Entramos en el metodo createUsuario ----------");
        if (usuarioDatabase.containsKey(id)){
            logger.warn("Usuario con Id: {} existe" , id );
            return;
        }
        Usuario user = Usuario.builder().nombre(nombre).email(email).id(id).build();
        usuarioDatabase.put(id, user);
        logger.info("Usuario creado: {}" , user);
        logger.trace("salimos de createUsuario -------");

    }
    //read
    public Usuario getUser (int id){
        logger.trace("Entramos en get User------");
        Usuario user = usuarioDatabase.get(id);
        if(user == null){
            logger.error("Usuario con id {} no encontrado", id);
        }
        else
            logger.debug("Usuario obtenido {} ", user);

        logger.trace("Salimos de get User------");
        return user;
    }

    //update
    public void updateUser (int id, String nombre, String email){
        logger.trace("Entramos en update User------");
        Usuario user = usuarioDatabase.get(id);
        if(user == null){
            logger.error("Usuario con id {} no encontrado", id);
            logger.trace("salimos en update User------");
            return;
        }
        usuarioDatabase.put(id, Usuario.builder().id(id).nombre(nombre).email(email).build());
        logger.info("Usuario updateado: {}", usuarioDatabase.get(id));


        logger.trace("salimos en update User------");

    }
    //delete:
    public void deleteUser (int id){
        logger.trace("Entramos en delete user --------");
        Usuario user = usuarioDatabase.remove(id);
        if (user == null ){
            logger.error("Usuario con id {} no encontrado", id);
        }
        else {
            logger.info("Usuario borrado {} " ,  user);
        }

       logger.trace("salimos en delete user --------");
    }

}
