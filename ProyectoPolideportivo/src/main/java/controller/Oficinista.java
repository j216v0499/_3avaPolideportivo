package controller;

import java.util.ArrayList;
import util.FileManager;
import java.util.List;
import java.util.Map;
import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class Oficinista extends Trabajadores{

    public Oficinista(){
        super();
    }

    public void darAlta(String nomCliente,String passwdCliente,String DNI,List<Usuario> usuarios1,Usuario usuario){

        //guardar al cliente en lista con filemanager
        if (usuarios1==null)
            usuarios1 = new ArrayList<>();
        usuarios1.add(usuario);
        FileManager.saveFileList(FileManager.LISTA_USUARIOS,usuarios1);

    }

    public void realizarReserva(Actividades actividad, String nomReserva, int numUser, int numSemana, int numHora, int numDia){

        Map<Actividades, List<Semana>> mapaActs = FileManager.loadFileMap("mapa");

        if (mapaActs.get(actividad).toString().equals(Actividades.YOGA) || mapaActs.get(actividad).toString().equals(Actividades.SPINNING)){

            if (mapaActs.get(actividad).get(numSemana).getDias().get(numDia).getHora().get(numHora).getCliente().size()<=20){
                mapaActs.get(actividad).get(numSemana).getDias().get(numDia).getHora().get(numHora).getCliente().get(numUser).setNombre(nomReserva);
            }else{
                System.out.println(colorize("\nNo hay espacio para mas reservas en esta actividad\n",BLUE_TEXT()));
            }

        }else {
            mapaActs.get(actividad).get(numSemana).getDias().get(numDia).getHora().get(numHora).getCliente().get(numUser).setNombre(nomReserva);
        }

        Reserva reserva = new Reserva(actividad,numSemana,numDia,numHora,FileManager.loadFile(FileManager.NUMERO_USUARIO));

        FileManager.saveFileMap("mapa", mapaActs);

    }

    public void quitarReserva(Actividades actividad, int numUser, int numSemana, int numHora, int numDia, List<Reserva> reservas){

        Map<Actividades, List<Semana>> mapaActs = FileManager.loadFileMap("mapa");

        mapaActs.get(actividad).get(numSemana).getDias().get(numDia).getHora().get(numHora).getCliente().get(numUser).setNombre("Disponible");

        FileManager.saveFileMap("mapa", mapaActs);


    }

    private void asignarTrabajador(Actividades actividad, int numSemana,int numDia, int numHora, Trabajadores trabajador){


        Map<Actividades, List<Semana>> mapaActs = FileManager.loadFileMap("mapa");

        mapaActs.get(actividad).get(numSemana).getDias().get(numDia).getHora().get(numHora).setTrabajador(trabajador);

        FileManager.saveFileMap("mapa", mapaActs);

    }

    private static void verReservas(Oficinista oficinista, Actividades actividad,int numUsuario, int numSemana, int numHora, int numDia){

        List<Reserva> reservas = (List<Reserva>) FileManager.loadFileList("reservas");

        int cont = 0;
        for (Reserva reserva : reservas){
            System.out.println(colorize("(" + cont + ")" + "semana:" +reserva.getNumSemana() + ", dia:" + reserva.getNumDia() + ", hora:" + reserva.getNumHora() + ", actividad:" + reserva.getActividad().toString(),BLUE_TEXT()));
            cont++;
        }
    }

}
