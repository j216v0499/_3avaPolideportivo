package controller;

import model.ModelOficinista;
import dao.Usuario;

import java.util.List;

public class ControllerOficinista {

    protected ModelOficinista modelOficinista = new ModelOficinista();

    /**
     *  Se espera dar de alta un usuario
     *
     * @param usuario se espera el acceso del usuario
     * @param usuarios1 lista de usuarios
     * */
    public void darAlta(List<Usuario> usuarios1, Usuario usuario){
        modelOficinista.darAlta(usuarios1,usuario);
    }

    /**
     * Sancionar usuario
     *
     * @param dni dni del usuario a sancionar
     * @param sancion sanción del usuario
     *
     * */

    public boolean sancionarUsuario(String dni, String sancion) {
        return modelOficinista.sancionarUsuario(dni,sancion);
    }

    /**
     * Se espera poder ver que un usuario está sancionado
     * @param dni se espera ver el dni del usuario sancionado
     *
     * */
    public String verSancionarUsuario(String dni){
       return  modelOficinista.verSancionarUsuario(dni);
    }

}
