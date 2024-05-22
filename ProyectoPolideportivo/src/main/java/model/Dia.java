package model;

import base.Writable;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Dia extends Writable {


    private static Dia instance;

    private String diaSemana;
    private List<Hora> hora;

    public Dia(String diaSemana) {
        this.hora = new ArrayList<>();
        this.diaSemana = diaSemana;
    }

    /**
     * Obtiene la instancia única de Día.
     *
     * La llamada inicial a este método debe proporcionar los parámetros necesarios.
     * Las llamadas posteriores ignorarán los parámetros y devolverán la instancia existente.
     *
     * @param diaSemana El nombre del día.
     */
    public static synchronized Dia getInstance(String diaSemana) {
        if (instance == null) {
            instance = new Dia(diaSemana);
        }
        return instance;
    }

    public static synchronized Dia getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Instancia no hecha ");
        }
        return instance;
    }

    public Dia() {

    }

    public List<Hora> getHora() {
        return hora;
    }

    public void setHora(List<Hora> hora) {
        this.hora = hora;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = String.valueOf(diaSemana);
    }
}
