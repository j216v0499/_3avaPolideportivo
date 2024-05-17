package controller;

import util.FileManager;

import java.util.List;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BLUE_TEXT;
import static com.diogonunes.jcolor.Attribute.BRIGHT_BLUE_TEXT;

public class AppOficina {

    public static void appOficina(Scanner sc, Oficinista oficinista, Actividades actividad){

        System.out.println(colorize("\n¿Ya tienes un usuario? (s/n) 'n' para darte de alta", BLUE_TEXT()));
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        String res1=sc.next();
        if (res1.equals("n")) {
            Menus.menuAlta(sc, oficinista);
        }
        while (!Menus.inicioSesionOficina(sc)){
            System.out.println(colorize("inicio de sesion incorrecto", BLUE_TEXT()));
        };
        System.out.println(colorize("\nSesión iniciada", BLUE_TEXT()));

        String res2="";
        do {

            System.out.println(colorize("\nAdmin detectado que deseas\n", BLUE_TEXT()));
           // System.out.println(colorize("Sancionar(1)    quitar reserva(2)   mostrar calendario(3)   salir(4)    ver reservas(5)  VerificarSancionar(6)", BLUE_TEXT()));
            System.out.println(colorize("Sancionar(1)  DardeAltaUsuarios(2) salir(3)  VerificarSancionar(4)", BLUE_TEXT()));

            System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
            res2 = sc.next();


            if(res2.equals("1")){
                System.out.println("que usuario quieres sancionar ? DNI:");
                String DNI = sc.nextLine();
                System.out.println("Sancion :");
                String Sancion = sc.nextLine();
                sancionarUsuario(DNI,Sancion);
            }

            if(res2.equals("4")){
                System.out.println("que usuario quieres verificar ? DNI:");
                Scanner scanner = new Scanner(System.in);
                String DNI = scanner.nextLine();
                buscarSancionarUsuario(DNI);
            }

            if (res2.equals("2")){
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
//                //controller.Semana
//                System.out.println(colorize("\n¿En que semana quieres situarte? (0-51)", BLUE_TEXT()));
//                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
//                int numSemana = sc.nextInt();
//
//                //controller.Dia
//                System.out.println(colorize("\n¿Que dia quieres quitar / ver reserva? (0-4)", BLUE_TEXT()));
//                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
//                int numDia = sc.nextInt();
//
//                //controller.Hora
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
        }while (!res2.equals("3"));

    }


    public static void sancionarUsuario(String dni,String Sancion){
/*
* Buscar al usuario
* Quitarle todas las reservas
* Reordenar las reservas
* Anadir el usuario y su sancion a un archivo de sanciones
* 
* */
 //    FileManager.saveFileList( usuarios ,"numUser");

    }

    public static void buscarSancionarUsuario(String dni){
        List<Reserva> reservas = (List<Reserva>) FileManager.loadFileList("reservas");


        for (Reserva reserva : reservas){
//            if(dni){
//                System.out.println(reserva);
//            }
        }
    }


    public static void quitarYmostrar(Oficinista oficinista,Actividades actividad, int numUser, int numSemana, int numHora, int numDia){
        oficinista.quitarReserva(actividad, numUser,numSemana,numHora,numDia, (List<Reserva>) FileManager.loadFileList("reservas"));
        MostrarCalendario.mostrarCalendario(numSemana,actividad);
    }

    public static void verReservas(Oficinista oficinista, Actividades actividad,int numUsuario, int numSemana, int numHora, int numDia){

        List<Reserva> reservas = (List<Reserva>) FileManager.loadFileList("reservas");

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