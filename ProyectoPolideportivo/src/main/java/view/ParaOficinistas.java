package view;

import controller.ControllerOficinista;
import dao.Oficinista;

import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class ParaOficinistas {

    private final ViewPolideportivoTerminalAuxiliar viewPolideportivoTerminalAuxiliar = new ViewPolideportivoTerminalAuxiliar();

    private final ControllerOficinista controllerOficinista = new ControllerOficinista();


    /**
     * Realizar una reserva
     *
     * @param oficinista se espera el objeto de tipo oficinista
     * @param sc espera la entrada del usuario
     *
     * */

    public void appOficina(Scanner sc, Oficinista oficinista){

        System.out.println(colorize("\n¿Ya tienes un usuario? (s/n) 'n' para darte de alta", BLUE_TEXT()));
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        String res1=sc.next();
        if (res1.equals("n")) {
            viewPolideportivoTerminalAuxiliar.menuAlta(sc, oficinista);
            appOficina(sc,oficinista);
        }else {
            while (!viewPolideportivoTerminalAuxiliar.inicioSesionOficina(sc)) {
                System.out.println(colorize("\tInicio de session incorrecto", BLUE_TEXT()));
            }

            System.out.println(colorize("\nSesión iniciada", BLUE_TEXT()));
            String res2 = "";

            do {

                //System.out.println(colorize("\nAdmin detectado que deseas\n", BLUE_TEXT()));
                // System.out.println(colorize("Sancionar(1)    quitar reserva(2)   mostrar calendario(3)   salir(4)    ver reservas(5)  VerificarSancionar(6)", BLUE_TEXT()));
                System.out.println(colorize("Sancionar(1)\tDardeAltaUsuarios(2)\tVerificarSancionar(3)\tSalir(4)", BLUE_TEXT()));
                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
                res2 = sc.next();

                if (res2.equals("1")) {
                    System.out.println("Que usuario quieres sancionar ?");
                    sc.nextLine();
                    System.out.println(colorize("Dni -->" , BRIGHT_MAGENTA_TEXT()));
                    String dni = sc.nextLine();
                    System.out.println(colorize("Sancion :",BRIGHT_MAGENTA_TEXT()));
                    String sancion = sc.nextLine();
                    boolean usuarioEncontrado =
                    controllerOficinista.sancionarUsuario(dni, sancion);

                    if (usuarioEncontrado) {
                        System.out.print(colorize("\n\t\tUsuario sancionado \n", BRIGHT_RED_TEXT()));
                    } else {
                        System.out.print(colorize("\nUsuario con DNI " + dni + " no encontrado.\n", BRIGHT_RED_TEXT()));
                    }


                }

                if (res2.equals("3")) {
                    System.out.println("que usuario quieres verificar ? DNI:");
                    Scanner scanner = new Scanner(System.in);
                    String DNI = scanner.nextLine();
                    controllerOficinista.verSancionarUsuario(DNI);
                }

                if (res2.equals("2")) {
                    viewPolideportivoTerminalAuxiliar.menuAlta(sc, oficinista);
                }

//              TODO: Esta parte ya se hara el la version 2 del proyecto

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
//                //dao.Semana
//                System.out.println(colorize("\n¿En que semana quieres situarte? (0-51)", BLUE_TEXT()));
//                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
//                int numSemana = sc.nextInt();
//
//                //dao.Dia
//                System.out.println(colorize("\n¿Que dia quieres quitar / ver reserva? (0-4)", BLUE_TEXT()));
//                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
//                int numDia = sc.nextInt();
//
//                //dao.Hora
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
            } while (!res2.equals("4"));
        }
    }

}