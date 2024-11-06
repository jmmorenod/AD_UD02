package org.iesch.ad;

import lombok.extern.log4j.Log4j2;
import org.iesch.ad.modelo.Usuario;
import org.iesch.ad.servicio.UsuarioServicio;

@Log4j2
public class Main {

    //Crear una aplicación de gestión de usuarios que incluya operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
    //Incluir diferentes niveles de log en cada operación para ilustrar su uso.

    public static void main(String[] args) {
        log.info("Comienza nuestra app");
        UsuarioServicio usuarioServicio = new UsuarioServicio();

        usuarioServicio.createUsuario(1, "Juan Manuel", "jj@aaa.es");
        usuarioServicio.createUsuario(2, "Pedro lopez", "pedro@a23.com");

        usuarioServicio.getUser(1);
        usuarioServicio.getUser(2);

        usuarioServicio.updateUser(1, "Perro Antonio", "perro@aa.es");
        usuarioServicio.updateUser(3, "PEta", "noamil@aa.es");

        usuarioServicio.deleteUser(2);
        usuarioServicio.deleteUser(3);

        Usuario user = usuarioServicio.getUser(1);
        log.info("VEmos el cambio {}" , user);
        log.info("app finalizada.");

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


    }
}