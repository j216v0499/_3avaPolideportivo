package model;

import base.Writable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Semana extends Writable {

    private List<Dia> dias;

    private LocalDate inicio;
    private LocalDate fin;


    public Semana( LocalDate inicio, LocalDate fin) {
        this.dias = new ArrayList<>();
        this.inicio = inicio;
        this.fin = fin;
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
