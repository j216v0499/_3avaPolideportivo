package model;

import dao.Usuario;
import util.FileManager;
import view.ViewPolideportivoTerminalAuxiliar;

import java.util.ArrayList;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BRIGHT_RED_TEXT;

public class ModelOficinista {

    ViewPolideportivoTerminalAuxiliar viewPolideportivoTerminalAuxiliar = new ViewPolideportivoTerminalAuxiliar();

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

    /**
     * Sancionar usuario
     *
     * @param dni dni del usuario a sancionar
     * @param sancion sancion del usuario
     *
     * */

    public void sancionarUsuario(String dni, String sancion) {
        List<Usuario> listaUsuarios = (List<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS);

        boolean usuarioEncontrado = false;

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getDNI().equals(dni)) {

                usuario.setSancion(sancion);

                usuarioEncontrado = true;
                break;  // Se usa para salir del for
            }
        }

        if (usuarioEncontrado) {
            FileManager.getInstance().saveFileList(FileManager.LISTA_USUARIOS, listaUsuarios);

            System.out.print(colorize("\n\t\tUsuario sancionado \n", BRIGHT_RED_TEXT()));

        } else {
            System.out.print(colorize("\nUsuario con DNI " + dni + " no encontrado.\n", BRIGHT_RED_TEXT()));
        }

        System.out.print(colorize("\n\t\tEl proceso de sancionar usuario ha terminado correctamente\n", BRIGHT_RED_TEXT()));
    }

    /**
     * Se espera poder ver que un usuario esta sancionado
     * @param dni se espera ver el dni del usuario sancionado
     *
     * */
    public void verSancionarUsuario(String dni){

        List<Usuario> usuarios1 = (List<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS);

        for (Usuario usuario : usuarios1) {

            if(usuario.getDNI().equals(dni)) {

                System.out.println(usuario.getSancion());
                System.out.println(viewPolideportivoTerminalAuxiliar.usuarioToString(usuario));

            }
        }
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
//        List<Reserva> reservas = (List<Reserva>) FileManager.getInstance().loadFileList("reservas");
//
//        int cont = 0;
//        for (Reserva reserva : reservas){
//            System.out.println(colorize("(" + cont + ")" + "semana:" +reserva.getNumSemana() + ", dia:" + reserva.getNumDia() + ", hora:" + reserva.getNumHora() + ", actividad:" + reserva.getActividad().toString(),BLUE_TEXT()));
//            cont++;
//        }
//    }




}
