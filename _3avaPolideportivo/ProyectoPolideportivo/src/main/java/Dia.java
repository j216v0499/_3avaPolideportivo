import base.Writable;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Dia extends Writable {

    private List<Hora> hora;

    private String diaSemana;

    public Dia(String diaSemana) {
        this.hora = new ArrayList<>();
        this.diaSemana = diaSemana;
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
