package controller;

import dao.Dia;
import dao.Hora;
import dao.Semana;
import model.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CrearCalendario {

    /**
     *
     * @return List<Semana> se espera una lista de semanas
     *
     * */

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

        //Bucle para generar fechas y rellenar la lista
        for (LocalDate date: dates){

            //Introducción de dias en semana
            if(!date.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                Dia dia = Dia.getInstance(date.getDayOfWeek().toString());
                semana.getDias().add(dia);

                //Introducción de horas en dias trabajadores y clientes en horas
                for (int i = 0; i<10;i++) {
                    //public dao.Hora(String formato, List<model.Usuario> cliente, model.Trabajadores trabajador) {
                    Usuario usuario = new Usuario("Disponible","pass",null,null);
                    Trabajadores trabajador = new Trabajadores("Nombre","pass",null);

                    usuarios.add(usuario);

                    Hora hora = new Hora("00:00",usuarios,trabajador);
//                    TODO get mal funcionamiento, es metodo de las reservas ya se encargara
//                    hora.SetCliente(usuario).add(usuario);
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
}
