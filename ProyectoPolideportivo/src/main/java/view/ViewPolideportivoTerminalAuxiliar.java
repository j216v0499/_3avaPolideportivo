package view;

import controller.ControllerOficinista;
import dao.Oficinista;
import dao.Usuario;
import util.FileManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class ViewPolideportivoTerminalAuxiliar {

    private final ControllerOficinista controllerOficinista = new ControllerOficinista();



    public String menuInicial() {
        Scanner sc = new Scanner(System.in);

        System.out.println(colorize("\nＰＯＬＩＤＥＰＯＲＴＩＶＯ", BRIGHT_BLUE_TEXT()));

        System.out.println(colorize("\nAccedes como...", BLUE_TEXT()));
        System.out.println(colorize("\nusuario(1)[app movil]         trabajador(2)[app oficina]", BLUE_TEXT()));
        System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
        return sc.next();

    }

    public void menuAlta(Scanner sc, Oficinista oficinista) {

            System.out.print(colorize("\nNombre de usuario: ", BRIGHT_RED_TEXT()));
            String nomUser = sc.next();
            System.out.print(colorize("\nIntroduce tu DNI para identificarte: ", BRIGHT_RED_TEXT()));
            String DNI = sc.next();
            System.out.print(colorize("\nAsignar contraseña: ", BRIGHT_RED_TEXT()));
            String pass = sc.next();

            Usuario usuario = new Usuario(nomUser, pass, DNI);

            List<Usuario> usuarios1 =
                    (List<Usuario>) FileManager.getInstance().loadFileList(
                            FileManager.LISTA_USUARIOS);
            controllerOficinista.darAlta(usuarios1, usuario);
            System.out.print(colorize("\nUsuario dado de Alta\n ", BRIGHT_RED_TEXT()));
            System.out.print(colorize("Datos del usuario nuevo -->\n", BRIGHT_YELLOW_BACK()));
            System.out.println(usuarioToString(usuario));

    }

    public boolean inicioUsuarios(Scanner sc) {

        System.out.println(colorize("\nLista de usuarios registrados (elige que perfil utilizar):", BLUE_TEXT()));
        ArrayList<Usuario> usus1 = null;

        if ((ArrayList<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS) == null) {

            System.out.println("Hace falta un usuario para inicial la sección");

        } else {
            usus1 = (ArrayList<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS);
        }

        if (usus1 == null || usus1.isEmpty()) {
            System.out.println("No hay usuarios registrados para iniciar sesión.");
            return true;
        } else {

            int contador = 0;
            for (Usuario eleccion : usus1) {
                System.out.println(colorize("(" + contador + ")" + eleccion.getNombre(), BLUE_TEXT()));
                contador++;
            }
            System.out.println();
            System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));


            int numUser = sc.nextInt();

            if (numUser > contador) {
                System.out.println("El usuario no exsiste");
                return true;

            }

            System.out.println(colorize("\nIdentificación:", BLUE_TEXT()));
            System.out.print(colorize("-> ", BRIGHT_BLUE_TEXT()));
            String DNI = sc.next();
            System.out.println(colorize("\nContrasenya:", BLUE_TEXT()));
            System.out.print(colorize("-> ", BRIGHT_BLUE_TEXT()));
            String pass = sc.next();

            FileManager.getInstance().saveFile(FileManager.NUMERO_USUARIO, numUser);

            //comprobación con el filemanager de DNI y pass (if igual true, else false)

            ArrayList<Usuario> usus2 = (ArrayList<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS);

            return !usus2.get(numUser).getDNI().equals(DNI)
                    || !usus2.get(numUser).getPass().equals(pass);
        }
    }

    public boolean inicioSesionOficina(Scanner sc) {

        System.out.println(colorize("\nLista de usuarios registrados (elige que perfil utilizar):", BLUE_TEXT()));

        ArrayList<Usuario> usus1 = (ArrayList<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS);

        int contador = 0;
        for (Usuario eleccion : usus1) {
            System.out.println(colorize("(" + contador + ")" + eleccion.getNombre(), BLUE_TEXT()));
            contador++;
        }
        System.out.println();
        System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));

        int numUser = 0;
        if (sc.hasNextInt()) {
            numUser = sc.nextInt();
        } else {
            sc.nextLine();
            System.out.println(colorize("\nIndice incorrecto;", RED_TEXT()));

            inicioSesionOficina(sc);
        }

        System.out.println(colorize("\nIdentificación:", BLUE_TEXT()));
        System.out.print(colorize("-> ", BRIGHT_BLUE_TEXT()));
        String DNI = sc.next();
        System.out.println(colorize("\ncontrasenya:", BLUE_TEXT()));
        System.out.print(colorize("-> ", BRIGHT_BLUE_TEXT()));
        String pass = sc.next();

        FileManager.getInstance().saveFile(FileManager.NUMERO_USUARIO, numUser);

        //comprobación con el filemanager de DNI y pass (if igual true, else false)

        ArrayList<Usuario> usus2 = (ArrayList<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS);

        return usus2.get(numUser).getDNI().equals(DNI) && usus2.get(numUser).getPass().equals(pass);
    }
//
//    public Actividades eleccionActividad(Actividades actividad, int numAct) {
//        switch (numAct) {
//            case 1: {
//                actividad = Actividades.FUTBOL;
//            }
//            break;
//            case 2: {
//                actividad = Actividades.BALONCESTO;
//            }
//            break;
//            case 3: {
//                actividad = Actividades.PADEL;
//            }
//            break;
//            case 4: {
//                actividad = Actividades.TENIS;
//            }
//            break;
//            case 5: {
//                actividad = Actividades.FRONTON;
//            }
//            break;
//            case 6: {
//                actividad = Actividades.YOGA;
//            }
//            break;
//            case 7: {
//                actividad = Actividades.SPINNING;
//            }
//            break;
//        }
//        return actividad;
//    }

    public String usuarioToString(Usuario user) {
        return  "\t\tUsuario " + "\n"+
                "\t\tDNI --> " + user.getDNI() +"\n"+
                "\t\tNombre -->" + user.getNombre() + "\n"+
                "\t\tEstaSancionado -->" + user.isEstaSancionado() + "\n"+
                "\t\tSancion --> " + user.getSancion();
    }

}
