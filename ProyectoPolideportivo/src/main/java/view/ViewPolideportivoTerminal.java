package view;

import controller.*;
import model.Semana;
import util.Menus;

import java.util.*;


public class ViewPolideportivoTerminal {

    public void lanzador() {
        Scanner sc = new Scanner(System.in);
        // Creación de oficinista y mapa de actividades
        Oficinista oficinista = new Oficinista();
        Map<Actividades, List<Semana>> semanaActs = new HashMap<>();

        // Definir y asignar un valor a actividad
        //Actividades actividad = Actividades.FUTBOL;

        // Manejo del menú inicial
        manejarMenuInicial(sc, oficinista, semanaActs);
        //LauncherTerminal.manejarMenuInicial(sc, oficinista, semanaActs);

    }

    private void manejarMenuInicial(Scanner sc, Oficinista oficinista, Map<Actividades, List<Semana>> semanaActs) {
        boolean opcionCorrecta = false;
        while (!opcionCorrecta) {
            String opcion = Menus.menuInicial();
            switch (opcion) {
                case "1":
                    opcionCorrecta = true;
                    ParaUsuarios.appMovil(sc, oficinista);
                    break;
                case "2":
                    opcionCorrecta = true;
                    ParaOficinistas.appOficina(sc, oficinista);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione de nuevo.");
            }
        }
    }

}


