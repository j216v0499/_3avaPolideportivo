package controller;

import util.Menus;

import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BLUE_TEXT;
import static com.diogonunes.jcolor.Attribute.BRIGHT_BLUE_TEXT;

public class VerCalendario {
    /**
     *  carga la aplicaccion movil
     *
     * @param sc se espera la entrada del usuario
     *
     *
     */
    public static void verCalendario(Scanner sc){

        Actividades actividad = Actividades.FUTBOL;

        System.out.println(colorize("\nActividad:", BLUE_TEXT()));
        int cont1=0;
        for (Actividades act : Actividades.values()){
            System.out.println(colorize("(" + cont1 + ")" + act.toString(), BLUE_TEXT()));
            cont1++;
        }
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        int numAct = sc.nextInt();
        actividad =  Menus.eleccionActividad(actividad, numAct);

        System.out.println(colorize("\n¿model.Semana? (0-51)", BLUE_TEXT()));
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        int numSemana = sc.nextInt();

        MostrarCalendario.mostrarCalendario(numSemana,actividad);
    }


}
