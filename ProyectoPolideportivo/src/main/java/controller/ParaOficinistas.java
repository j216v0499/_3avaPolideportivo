package controller;

import model.Reserva;
import model.Usuario;
import util.FileManager;
import util.Menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class ParaOficinistas {

    /**
     * realizar una reserva
     *
     * @param oficinista se espera el objeto de tipo oficinista
     * @param sc espera la entrada del usuario
     *
     * */

    public static void appOficina(Scanner sc, Oficinista oficinista){

        System.out.println(colorize("\n¿Ya tienes un usuario? (s/n) 'n' para darte de alta", BLUE_TEXT()));
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        String res1=sc.next();
        if (res1.equals("n")) {
            Menus.menuAlta(sc, oficinista);
        }else {
            while (!Menus.inicioSesionOficina(sc)) {
                System.out.println(colorize("inicio de sesion incorrecto", BLUE_TEXT()));
            }
            ;
            System.out.println(colorize("\nSesión iniciada", BLUE_TEXT()));

            String res2 = "";
            do {

                System.out.println(colorize("\nAdmin detectado que deseas\n", BLUE_TEXT()));
                // System.out.println(colorize("Sancionar(1)    quitar reserva(2)   mostrar calendario(3)   salir(4)    ver reservas(5)  VerificarSancionar(6)", BLUE_TEXT()));
                System.out.println(colorize("Sancionar(1)  DardeAltaUsuarios(2) salir(3)  VerificarSancionar(4)", BLUE_TEXT()));

                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
                res2 = sc.next();


                if (res2.equals("1")) {
                    System.out.println("que usuario quieres sancionar ?");
                    System.out.println("Dni -->");
                    String dni = sc.nextLine();
                    System.out.println("Sancion :");
                    String sancion = sc.nextLine();
                    sancionarUsuario(dni, sancion);
                }

                if (res2.equals("4")) {
                    System.out.println("que usuario quieres verificar ? DNI:");
                    Scanner scanner = new Scanner(System.in);
                    String DNI = scanner.nextLine();
                    verSancionarUsuario(DNI);
                }

                if (res2.equals("2")) {
                    Menus.menuAlta(sc, oficinista);
                }


//            if (!res2.equals("3") && !res2.equals("4") && !res2.equals("1")) {
//                //Actividad
//                System.out.println(colorize("\nelige el dia deseado para  quitar / ver reserva? ", BLUE_TEXT()));
//                int cont1 = 0;
//                for (Actividades act : Actividades.values()) {
//                    System.out.println(colorize("(" + cont1 + ")" + act.toString(), BLUE_TEXT()));
//                    cont1++;
//                }
//                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
//                int numAct = sc.nextInt();
//                actividad = Menus.eleccionActividad(actividad, numAct);
//
//                //model.Semana
//                System.out.println(colorize("\n¿En que semana quieres situarte? (0-51)", BLUE_TEXT()));
//                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
//                int numSemana = sc.nextInt();
//
//                //model.Dia
//                System.out.println(colorize("\n¿Que dia quieres quitar / ver reserva? (0-4)", BLUE_TEXT()));
//                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
//                int numDia = sc.nextInt();
//
//                //model.Hora
//                int cont2 = 8;
//                System.out.println(colorize("\n¿A que hora?", BLUE_TEXT()));
//                for (int i = 0; i < 10; i++) {
//                    if (cont2 < 10) {
//                        System.out.println(colorize("(" + i + ")    0" + cont2 + ":00               ", BLUE_TEXT()));
//                    } else {
//                        System.out.println(colorize("(" + i + ")    " + cont2 + ":00               ", BLUE_TEXT()));
//                    }
//                    if (cont2 == 13) {
//                        cont2 = cont2 + 4;
//                    } else {
//                        cont2++;
//                    }
//                }
//                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
//                int numHora = sc.nextInt();
//
//                if (res2.equals("2")) {
//                    quitarYmostrar(oficinista, actividad, FileManager.loadFile(FileManager.NUMERO_USUARIO), numSemana, numHora, numDia);
//                }
//
//                if (res2.equals("5")){
//                    verReservas(oficinista, actividad, FileManager.loadFile(FileManager.NUMERO_USUARIO), numSemana, numHora, numDia);
//                }
//            }
            } while (!res2.equals("3"));
        }

    }

    /**
     * Buscar al usuario
     * Quitarle todas las reservas
     * Reordenar las reservas
     * Anadir el usuario y su sancion a un archivo de sanciones
     *
     * */
    public static void sancionarUsuario(String dni,String sancion){

        List<Usuario> usuarios1 = (List<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS);

        //List<Usuario> baneados = (List<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS_BAN);

        for (Usuario usuario : usuarios1) {

            if(usuario.getDNI().equals(dni)) {

                usuario.setSancion("sancion");
                usuarios1.add(usuario);

                FileManager.getInstance().saveFileList(FileManager.LISTA_USUARIOS_BAN, usuarios1);

            }
        }

        System.out.print(colorize("\nSancionarUsuario, se ha terminado el metodo \n ", BRIGHT_RED_TEXT()));

    }
    public static void darSancion(List<Usuario> usuarios1, Usuario usuario){

        //guardar al cliente en lista con filemanager
        if (usuarios1==null)
            usuarios1 = new ArrayList<>();
        usuarios1.add(usuario);

    }

    /**
     * espera poder ver que un usuario esta sancionado
     * @param dni se espera ver el dni del usuario sancionado
     *
     * */
    public static void verSancionarUsuario(String dni){
        //List<Reserva> reservas = (List<Reserva>) FileManager.getInstance().loadFileList("reservas");

        List<Usuario> usuarios1 = (List<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS);

        //List<Usuario> baneados = (List<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS_BAN);

        for (Usuario usuario : usuarios1) {

            if(usuario.getDNI().equals(dni)) {

                System.out.println(usuario.getSancion());
                System.out.println(usuario.toString());

            }
        }

    }


    public static void quitarYmostrar(Oficinista oficinista,Actividades actividad, int numUser, int numSemana, int numHora, int numDia){
        oficinista.quitarReserva(actividad, numUser,numSemana,numHora,numDia, (List<Reserva>) FileManager.getInstance().loadFileList("reservas"));
        MostrarCalendario.mostrarCalendario(numSemana,actividad);
    }
    /**
     * espera poder ver las reservas
     *
     * @param oficinista se espera el objeto de tipo oficinista
     * @param actividad nombre de la actividad
     * @param numUsuario  se espera el numero del usuario
     * @param numSemana espera el número de la semana
     * @param numHora espera la hora
     * @param numDia espera el día
     *
     * */
    public static void verReservas(Oficinista oficinista, Actividades actividad,int numUsuario, int numSemana, int numHora, int numDia){

        List<Reserva> reservas = (List<Reserva>) FileManager.getInstance().loadFileList("reservas");

        int cont = 0;
        for (Reserva reserva : reservas){
            System.out.println(colorize("(" + cont + ")" + "semana:" +reserva.getNumSemana() + ", dia:" + reserva.getNumDia() + ", hora:" + reserva.getNumHora() + ", actividad:" + reserva.getActividad().toString(),BLUE_TEXT()));
            cont++;
        }
    }

//    public static void rellenarActividades(List<Semana> SEMANAS, Map<Actividades,List<Semana>> semanaActs){
//
//        for (Actividades actividades : Actividades.values()){
//            semanaActs.put(actividades,SEMANAS);
//        }
//        FileManager.saveFileMap("mapa", semanaActs);
//
//    }

}