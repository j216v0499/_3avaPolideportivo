package view;

import util.Menus;

import java.util.Scanner;

public class LauncherPresentacion {
    /**
     * 1. Login.
     * Se ha adaptado los methods que hay ya en el codigo
     *
     * 3. Sancionar usuario.
     * 4. Dar de alta usuario.
     * */

    public static void lanzador() {
        Scanner sc = new Scanner(System.in);
        String respuestaUsuario= Menus.menuInicial();

        boolean iniciadoComoUser = false;
        boolean iniciadoComoAdmi = false;

        if(respuestaUsuario.equals("1")){
            System.out.println("Ha seleccionado la opción de usuario");
            iniciadoComoUser= Menus.inicioSesionUsuarios(sc);
        }else{
            System.out.println("Ha seleccionado la opción de oficinista ");
            iniciadoComoAdmi = Menus.inicioSesionOficina(sc);
        }

        if(iniciadoComoUser){

//            ParaUsuarios.reservarYmostrar();
//
//            MostrarCalendario.mostrarCalendario();

        }
        if(iniciadoComoAdmi){

//            ParaOficinistas.sancionarUsuario();
//
//            ParaOficinistas.verSancionarUsuario();
//
//            MostrarCalendario.mostrarCalendario();
        }
    }
}
