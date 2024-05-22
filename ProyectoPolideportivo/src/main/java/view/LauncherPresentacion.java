package view;

import controller.Actividades;
import controller.Oficinista;
import controller.ParaOficinistas;
import model.Usuario;
import util.FileManager;
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

            System.out.println("ususario");
//
//            ParaUsuarios.reservarYmostrar();
//
//            MostrarCalendario.mostrarCalendario();

        }

        if(iniciadoComoAdmi){

            System.out.println("admin");


            //    Para ofocinistas  appOficina(Scanner sc, Oficinista oficinista, Actividades actividad){
            Actividades actividad = Actividades.FUTBOL;

            ParaOficinistas.appOficina(sc,new Oficinista());
//            ParaOficinistas.sancionarUsuario();
//
//            ParaOficinistas.verSancionarUsuario();
//
//            MostrarCalendario.mostrarCalendario();
        }
    }
}
