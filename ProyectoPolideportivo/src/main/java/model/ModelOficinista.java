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

    //ViewPolideportivoTerminalAuxiliar viewPolideportivoTerminalAuxiliar = new ViewPolideportivoTerminalAuxiliar();


    private RepositoryOficinista repositoryOficinista = RepositoryOficinista.getInstance();


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

    /**
     * Se espera poder ver las reservas
     *
     * @param oficinista se espera el objeto de tipo oficinista
     * @param actividad nombre de la actividad
     * @param numUsuario  se espera el numero del usuario
     * @param numSemana espera el número de la semana
     * @param numHora espera la hora
     * @param numDia espera el día
     *
     * */
//    public void verReservas(Oficinista oficinista, Actividades actividad,int numUsuario, int numSemana, int numHora, int numDia){
//
    //     repositoryOficinista.verReservas(.....)
//    }




}