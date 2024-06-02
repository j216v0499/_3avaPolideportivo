package controller;

import dao.Semana;
import model.*;
import util.FileManager;

import java.util.List;
import java.util.Map;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class MostrarCalendario {
    /**
     * Mostrar calendario
     *
     * @param numSemana entero para el número de semanas
     * @param actividad actividad para mostrar el calendario
     *
     * */

    public void mostrarCalendario(int numSemana, Actividades actividad) {
        FileManager fileManager = FileManager.getInstance();
        Map<Actividades, List<Semana>> semanaActs = fileManager.loadFileMap("mapa");
        List<Usuario> usuarios = fileManager.loadFileList(FileManager.NUMERO_USUARIO);

        System.out.println(colorize("\n*------------------------------------------------------------------------------------------------------------------------*"));
        System.out.println(colorize("    dao.Semana (" + numSemana + ") " + semanaActs.get(actividad).get(numSemana).getInicio().toString() + " - " + actividad.toString()));
        System.out.println(colorize("*------------------------------------------------------------------------------------------------------------------------*"));
        System.out.println(colorize("    Horario               Lunes            Martes        Miércoles          Jueves          Viernes  "));
        System.out.println(colorize("*------------------------------------------------------------------------------------------------------------------------*"));

        int hora = 8;
        for (int i = 0; i < semanaActs.get(actividad).get(numSemana).getDias().get(0).getHora().size(); i++) {
            if (hora < 10) {
                System.out.print("    0" + hora + ":00               ");
            } else {
                System.out.print("    " + hora + ":00               ");
            }
            for (int j = 0; j < semanaActs.get(actividad).get(numSemana).getDias().size(); j++) {
                if (semanaActs.get(actividad).get(numSemana).getDias().get(j).getHora().get(i).getCliente().get(i).getNombre().equals("Reservado")) {
                    System.out.print(colorize(semanaActs.get(actividad).get(numSemana).getDias().get(j).getHora().get(i).getCliente().get(i).getNombre(), RED_BACK()));
                }

                if (semanaActs.get(actividad).get(numSemana).getDias().get(j).getHora().get(i).getCliente().get(i).getNombre().equals("Disponible")) {
                    System.out.print(colorize(semanaActs.get(actividad).get(numSemana).getDias().get(j).getHora().get(i).getCliente().get(i).getNombre(), GREEN_BACK(), BLACK_TEXT()));
                }

                System.out.print("       ");
            }
            System.out.println(colorize("\n*------------------------------------------------------------------------------------------------------------------------*"));
            if (hora == 13) {
                hora = hora + 4;
            } else {
                hora++;
            }
        }
    }
}
