package controller;

import util.FileManager;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class MostrarCalendario {
    public static List<Semana> calendario(){

        //Código para generar las fechas del año
        LocalDate fechaInicio = LocalDate.parse("2023-01-01");
        LocalDate fechaFinal = LocalDate.parse("2024-01-01");
        List<LocalDate> dates = Stream.iterate(fechaInicio, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(fechaInicio, fechaFinal))
                .collect(Collectors.toList());

        //Generación de la lista para funcionar como semana
        Semana semana = new Semana();
        List<Semana> SEMANAS = new ArrayList<>();

        //Array de usuarios
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();



        //bucle para generar fechas y rellenar la lista
        for (LocalDate date: dates){

            //Introducción de dias en semana
            if(!date.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                Dia dia = new Dia(date.getDayOfWeek().toString());
                semana.getDias().add(dia);

                //Introducción de horas en dias trabajadores y clientes en horas
                for (int i = 0; i<10;i++) {
                    //public controller.Hora(String formato, List<controller.Usuario> cliente, controller.Trabajadores trabajador) {
                    Usuario usuario = new Usuario("Disponible","pass",null,null);
                    Trabajadores trabajador = new Trabajadores("Nombre","pass",null);

                    usuarios.add(usuario);

                    Hora hora = new Hora("00:00",usuarios,trabajador);

//                    hora.SetCliente(usuario).add(usuario); //TODO get mal funcionamiento
//                    hora.setTrabajador(trabajador);
//                    hora.setFormato("00:00");
//                    dia.getHora().add(hora);
                }
            }

            //filtro de dias (solo de lunes a viernes)
            if(date.getDayOfWeek().equals(DayOfWeek.MONDAY)){
                semana.setInicio(date);
            }
            if(date.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
                semana.setFin(date);
                SEMANAS.add(semana);
                semana = new Semana();
            }
        }


        //Devolución de la lista con las semanas rellenadas
        return SEMANAS;

    }


    public static void mostrarCalendario(int numSemana, Actividades actividad){


        Map<Actividades, List<Semana>> semanaActs = FileManager.loadFileMap("mapa");

        System.out.println(colorize("\n*------------------------------------------------------------------------------------------------------------------------*"));
        System.out.println(colorize("    controller.Semana (" + numSemana + ") "  + semanaActs.get(actividad).get(numSemana).getInicio().toString() + " - " + actividad.toString()));
        System.out.println(colorize("*------------------------------------------------------------------------------------------------------------------------*"));
        System.out.println(colorize("    Horario               Lunes            Martes        Miércoles          Jueves          Viernes  "));
        System.out.println(colorize("*------------------------------------------------------------------------------------------------------------------------*"));

        int hora = 8;
        for (int i = 0; i< semanaActs.get(actividad).get(numSemana).getDias().get(0).getHora().size(); i++) {

            if (hora<10){System.out.print("    0" + hora +":00               ");}else{System.out.print("    " + hora +":00               ");}
            for (int j = 0; j < semanaActs.get(actividad).get(numSemana).getDias().size(); j++) {
                if (semanaActs.get(actividad).get(numSemana).getDias().get(j).getHora().get(i).getCliente().get(FileManager.loadFile(FileManager.NUMERO_USUARIO)).getNombre().equals("Reservado")){
                    System.out.print(colorize(semanaActs.get(actividad).get(numSemana).getDias().get(j).getHora().get(i).getCliente().get(FileManager.loadFile(FileManager.NUMERO_USUARIO)).getNombre(),RED_BACK()));
                }
                if (semanaActs.get(actividad).get(numSemana).getDias().get(j).getHora().get(i).getCliente().get(FileManager.loadFile(FileManager.NUMERO_USUARIO)).getNombre().equals("Disponible")){
                    System.out.print(colorize(semanaActs.get(actividad).get(numSemana).getDias().get(j).getHora().get(i).getCliente().get(FileManager.loadFile(FileManager.NUMERO_USUARIO)).getNombre(),GREEN_BACK(),BLACK_TEXT()));
                }
                System.out.print("       ");
            }
            System.out.println(colorize("\n*------------------------------------------------------------------------------------------------------------------------*"));
            if (hora==13){hora=hora+4;}else{hora++;}
        }

    }

    public static void verCalendario(Scanner sc){

        Actividades actividad = Actividades.FUTBOL;

        System.out.println(colorize("\nActividad:", BLUE_TEXT()));
        int cont1=0;
        for (Actividades act : Actividades.values()){
            System.out.println(colorize("(" + cont1 + ")" + act.toString(), BLUE_TEXT()));
            cont1++;
        }
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        int numAct = sc.nextInt();
        actividad =  Menus.eleccionActividad(actividad, numAct);

        System.out.println(colorize("\n¿controller.Semana? (0-51)", BLUE_TEXT()));
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        int numSemana = sc.nextInt();

        MostrarCalendario.mostrarCalendario(numSemana,actividad);
    }

}
