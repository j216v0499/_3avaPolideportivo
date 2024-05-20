package controller;
import util.FileManager;

import java.util.*;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class LauncherTerminal {
    public static void lanzador() {


        Scanner sc = new Scanner(System.in);
        //actividades
        int numAct = 0;
        Actividades actividad = Actividades.FUTBOL;
        //controller.Oficinista
        Oficinista oficinista = new Oficinista(); //cramos una oficinista

        Map<Actividades, List<Semana>> semanaActs = new HashMap<>();  //creamos un mapa de actividades

        if (util.FileManager.loadFileMap("mapa") == null)
            ParaUsuarios.rellenarActividades(MostrarCalendario.calendario(), semanaActs);

        if (FileManager.loadFileMap("reservas") == null) {
            List<Reserva> reservas = new ArrayList<>();
            FileManager.saveFileList("reservas", reservas);
        }
        boolean opcionCorrecta =false;
        while (!(opcionCorrecta)) {
            if (Menus.menuInicial().equals("1")) {
                opcionCorrecta=true;
                ParaUsuarios.appMovil(sc, oficinista, actividad);

            } else if (Menus.menuInicial().equals("2")) {
                opcionCorrecta=true;
                ParaOficinistas.appOficina(sc, oficinista, actividad);
            }
        }


    }
}
