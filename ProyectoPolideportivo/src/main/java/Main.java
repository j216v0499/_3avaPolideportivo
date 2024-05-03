import Util.FileManager;
import jdk.jshell.execution.Util;

import java.util.*;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // pepe 26766978H pepe

        //actividades
        int numAct = 0;Actividades actividad = Actividades.FUTBOL;
        //Oficinista
        Oficinista oficinista = new Oficinista(); //cramos una oficinista

        Map<Actividades, List<Semana>> semanaActs = new HashMap<>();  //creamos un mapa de actividades

        if (FileManager.loadFileMap("mapa")==null)
            AppMovil.rellenarActividades(MostrarCalendario.calendario(), semanaActs);

        if (FileManager.loadFileMap("reservas")==null){
            List<Reserva> reservas = new ArrayList<>();
            FileManager.saveFileList("reservas", reservas);
        }

        if (Menus.menuInicial().equals("1")){
            AppMovil.appMovil(sc,oficinista, actividad);
        }else{
            AppOficina.appOficina(sc);
        }
    }
}
