//package controller;
//
//import view.ViewPolideportivoTerminalAuxiliar;
//
//import java.util.Scanner;
//
//import static com.diogonunes.jcolor.Ansi.colorize;
//import static com.diogonunes.jcolor.Attribute.BLUE_TEXT;
//import static com.diogonunes.jcolor.Attribute.BRIGHT_BLUE_TEXT;
//
//public class VerCalendario {
//    /**
//     * Se carga la aplicaccion movil
//     *
//     * @param sc se espera la entrada del usuario
//     *
//     *
//     */
//    private ViewPolideportivoTerminalAuxiliar viewPolideportivoTerminalAuxiliar = new ViewPolideportivoTerminalAuxiliar();
//
//    private MostrarCalendario mostrarCalendario = new MostrarCalendario();
//
//
//    public void verCalendario(Scanner sc){
//
//        Actividades actividad = Actividades.FUTBOL;
//
//        System.out.println(colorize("\nActividad:", BLUE_TEXT()));
//        int cont1=0;
//        for (Actividades act : Actividades.values()){
//            System.out.println(colorize("(" + cont1 + ")" + act.toString(), BLUE_TEXT()));
//            cont1++;
//        }
//        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
//        int numAct = sc.nextInt();
//        actividad =  viewPolideportivoTerminalAuxiliar.eleccionActividad(actividad, numAct);
//
//        System.out.println(colorize("\n¿dao.Semana? (0-51)", BLUE_TEXT()));
//        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
//        int numSemana = sc.nextInt();
//
//        mostrarCalendario.mostrarCalendario(numSemana,actividad);
//    }
//
//
//}