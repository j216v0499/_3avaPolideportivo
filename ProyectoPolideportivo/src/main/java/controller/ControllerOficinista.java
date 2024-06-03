package controller;

import model.Usuario;
import util.FileManager;

import java.util.ArrayList;
import java.util.List;

public class ControllerOficinista extends Oficinista{


    /**
     *  Se espera dar de alta un usuario
     *
     * @param usuario se espera el acceso del usuario
     * @param usuarios1 lista de usuarios
     * */
    public void darAlta(List<Usuario> usuarios1, Usuario usuario){

        //guardar al cliente en lista con filemanager
        if (usuarios1==null)
            usuarios1 = new ArrayList<>();
        usuarios1.add(usuario);
        FileManager.getInstance().saveFileList(FileManager.LISTA_USUARIOS, usuarios1);

    }

}
