import util.FileManager;
import controller.*;

import java.util.*;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // pepe 26766978H pepe

        //actividades
        int numAct = 0;
        Actividades actividad = Actividades.FUTBOL;
        //controller.Oficinista
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
            AppOficina.appOficina(sc,oficinista, actividad);
        }
    }
}

