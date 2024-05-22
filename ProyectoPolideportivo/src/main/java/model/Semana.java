package model;

import base.Writable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Semana extends Writable {
    private static Semana instance;
    private List<Dia> dias;

    private LocalDate inicio;
    private LocalDate fin;


    public Semana(LocalDate inicio, LocalDate fin) {
        this.dias = new ArrayList<>();
        this.inicio = inicio;
        this.fin = fin;
    }

    /**
     * Obtiene la instancia única de la Semana.
     *
     * La llamada inicial a este método debe proporcionar los parámetros necesarios.
     * Las llamadas posteriores ignorarán los parámetros y devolverán la instancia existente.
     *
     * @param inicio El principio de la semana.
     * @param fin El final de la semana.
     * @return La instancia única de Semana.
     */
    public static synchronized Semana getInstance(LocalDate inicio, LocalDate fin) {
        if (instance == null) {
            instance = new Semana(inicio,fin);
        }
        return instance;
    }

    public static synchronized Semana getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Instancia no hecha ");
        }
        return instance;
    }














    public Semana(){
        this.dias = new ArrayList<>();
    }

    public List<Dia> getDias() {
        return dias;
    }

    public void setDias(List<Dia> dias) {
        this.dias = dias;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }
}
