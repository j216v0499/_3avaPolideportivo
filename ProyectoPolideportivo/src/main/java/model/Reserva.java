package model;

import controller.Actividades;

import java.util.List;

public class Reserva {
    private static Reserva instance;
    private Actividades actividad;
    private int numSemana;
    private int numDia;
    private int numHora;
    private int numCliente;


    public Reserva(Actividades actividad, int numSemana, int numDia, int numHora, int numCliente) {
        this.actividad = actividad;
        this.numSemana = numSemana;
        this.numDia = numDia;
        this.numHora = numHora;
        this.numCliente = numCliente;
    }

    /**
     * Obtiene la instancia única de la Reserva.
     *
     * La llamada inicial a este método debe proporcionar los parámetros necesarios.
     * Las llamadas posteriores ignorarán los parámetros y devolverán la instancia existente.
     *
     * @param actividad La actividad que se reserva.
     * @param numSemana La semana de la reserva.
     * @param numDia El día de la reserva.
     * @param numHora La hora de la reserva.
     * @param numCliente Número del cliente para la reserva.
     * @return La instancia única de Reserva.
     */
    public static synchronized Reserva getInstance(Actividades actividad, int numSemana, int numDia, int numHora, int numCliente) {
        if (instance == null) {
            instance = new Reserva(actividad, numSemana, numDia, numHora, numCliente);
        }
        return instance;
    }

    public static synchronized Reserva getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Instancia no hecha ");
        }
        return instance;
    }

    public Reserva(){

    }

    public Actividades getActividad() {
        return actividad;
    }

    private void setActividad(Actividades actividad) {
        this.actividad = actividad;
    }

    public int getNumSemana() {
        return numSemana;
    }

    private void setNumSemana(int numSemana) {
        this.numSemana = numSemana;
    }

    public int getNumDia() {
        return numDia;
    }

    private void setNumDia(int numDia) {
        this.numDia = numDia;
    }

    public int getNumHora() {
        return numHora;
    }

    private void setNumHora(int numHora) {
        this.numHora = numHora;
    }

    public int getNumCliente() {
        return numCliente;
    }

    private void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }
}