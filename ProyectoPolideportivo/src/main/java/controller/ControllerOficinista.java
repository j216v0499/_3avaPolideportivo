package controller;

import dao.Oficinista;
import model.ModelOficinista;
import dao.Usuario;

import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class ControllerOficinista extends Oficinista {

    private ModelOficinista modelOficinista = new ModelOficinista();

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
     * @param sancion sancion del usuario
     *
     * */

    public void sancionarUsuario(String dni, String sancion) {
        modelOficinista.sancionarUsuario(dni,sancion);
    }

    /**
     * Se espera poder ver que un usuario esta sancionado
     * @param dni se espera ver el dni del usuario sancionado
     *
     * */
    public void verSancionarUsuario(String dni){
        modelOficinista.verSancionarUsuario(dni);
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
//          modelOficinista.verReservas(oficinista,actividad,numUsuario .....)
//    }

}
