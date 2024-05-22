package view;

import controller.*;
import model.Reserva;
import model.Semana;
import util.FileManager;
import util.Menus;

import java.util.*;


public class LauncherTerminal {

    public static void lanzador() {
        Scanner sc = new Scanner(System.in);
        // Creación de oficinista y mapa de actividades
        Oficinista oficinista = new Oficinista();
        Map<Actividades, List<Semana>> semanaActs = new HashMap<>();

        // Definir y asignar un valor a actividad
        Actividades actividad = Actividades.FUTBOL;

        // Manejo del menú inicial
        LauncherTerminal.manejarMenuInicial(sc, oficinista, semanaActs);
        //LauncherTerminal.manejarMenuInicial(sc, oficinista, semanaActs);

    }

    private void cargarArchivos(Map<Actividades, List<Semana>> semanaActs) {
        if (FileManager.getInstance().loadFileMap("mapa") == null) {
            //TODO --> ParaUsuarios.rellenarActividades(CrearCalendario.calendario(), semanaActs);
        }

        if (FileManager.getInstance().loadFileMap("reservas") == null) {
            List<Reserva> reservas = new ArrayList<>();
            FileManager.getInstance().saveFileList("reservas", reservas);
        }
    }

    private static void manejarMenuInicial(Scanner sc, Oficinista oficinista, Map<Actividades, List<Semana>> semanaActs) {
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


