package controller;

import util.Menus;

import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BLUE_TEXT;
import static com.diogonunes.jcolor.Attribute.BRIGHT_BLUE_TEXT;

public class ParaUsuarios {

    /**
     *  Se carga la aplicacción movil
     *
     * @param sc se espera la entrada del usuario
     * @param oficinista se espera el acceso de un oficinista
     *
     */

    public static void appMovil(Scanner sc, Oficinista oficinista){

        System.out.println(colorize("\n¿Ya tienes un usuario? (s/n) 'n' para darte de alta", BLUE_TEXT()));
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        String res1=sc.next();
        if (res1.equals("n")) {
            Menus.menuAlta(sc, oficinista);
        }

        // Comprobamos si hay usuarios registrados
        if (!Menus.inicioSesionUsuarios(sc)) {
            System.out.println(colorize("No hay usuarios registrados.", BLUE_TEXT()));
            return; // Salimos del método si no hay usuarios registrados
        }

        // Continuamos con el inicio de sesión
        while (!Menus.inicioSesionUsuarios(sc)) {
            System.out.println(colorize("Inicio de sesión incorrecto", BLUE_TEXT()));
        }

        System.out.println(colorize("\nSesión iniciada", BLUE_TEXT()));

        String res2="";
        do {

            System.out.println(colorize("\nBienvenido al polideportivo ¿que desea hacer?\n", BLUE_TEXT()));
            System.out.println(colorize("reservar(1)    quitar reserva(2)   mostrar calendario(3)   salir(4)    ver reservas(5)", BLUE_TEXT()));
            System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
            res2 = sc.next();

        }while (!res2.equals("4"));
    }
}
