package dao;

import base.Writable;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Dia representa un día en el sistema.
 * Se extiende de la clase Writable.
 */

public class Dia extends Writable {

    private String diaSemana;
    private List<Hora> hora;

    /**
     * Constructor para la clase Dia.
     *
     * @param diaSemana El día de la semana.
     */

    public Dia(String diaSemana) {
        this.hora = new ArrayList<>();
        this.diaSemana = diaSemana;
    }

    /**
     * Obtiene la lista de horas.
     *
     * @return La lista de horas.
     */

    public List<Hora> getHora() {
        return hora;
    }

    /**
     * Establece la lista de horas.
     *
     * @param hora La lista de horas.
     */

    public void setHora(List<Hora> hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el día de la semana.
     *
     * @return El día de la semana.
     */

    public String getDiaSemana() {
        return diaSemana;
    }

    /**
     * Establece el día de la semana.
     *
     * @param diaSemana El día de la semana.
     */

    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = String.valueOf(diaSemana);
    }
}
