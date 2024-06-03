package model;

import dao.Usuario;
import repositories.RepositoryOficinista;
import util.FileManager;
import view.ViewPolideportivoTerminalAuxiliar;

import java.util.ArrayList;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BRIGHT_RED_TEXT;

public class ModelOficinista {

     private final RepositoryOficinista repositoryOficinista = RepositoryOficinista.getInstance();

    /**
     *  Se espera dar de alta un usuario
     *
     * @param usuario se espera el acceso del usuario
     * @param usuarios1 lista de usuarios
     * */
    public void darAlta(List<Usuario> usuarios1, Usuario usuario){
        repositoryOficinista.darAlta(usuarios1,usuario);
    }

    /**
     * Sancionar usuario
     *
     * @param dni dni del usuario a sancionar
     * @param sancion sancion del usuario
     *
     * */

    public void sancionarUsuario(String dni, String sancion) {
        repositoryOficinista.sancionarUsuario(dni, sancion);
    }

    /**
     * Se espera poder ver que un usuario esta sancionado
     * @param dni se espera ver el dni del usuario sancionado
     *
     * */
    public void verSancionarUsuario(String dni){
        repositoryOficinista.verSancionarUsuario(dni);
    }
}
