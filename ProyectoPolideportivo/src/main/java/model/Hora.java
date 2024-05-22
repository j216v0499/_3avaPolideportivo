package model;

import base.Writable;
import model.Trabajadores;
import model.Usuario;

import java.util.List;

public class Hora extends Writable {

    private static Hora instance;

    private String formato;

    private List<Usuario> cliente;

    private Trabajadores trabajador;

    public Hora(String formato, List<Usuario> cliente, Trabajadores trabajador) {
        this.formato = formato;
        this.cliente = cliente;
        this.trabajador = trabajador;
    }
    /**
     * Obtiene la instancia única de la Hora.
     *
     * La llamada inicial a este método debe proporcionar los parámetros necesarios.
     * Las llamadas posteriores ignorarán los parámetros y devolverán la instancia existente.
     *
     * @param formato El formato de la hora.
     * @param cliente El cliente que reserva la hora.
     * @param trabajador El trabajador que trabaja a esa hora.
     * @return La instancia única de Hora.
     */
    public static synchronized Hora getInstance(String formato, List<Usuario> cliente, Trabajadores trabajador) {
        if (instance == null) {
            instance = new Hora(formato, cliente, trabajador);
        }
        return instance;
    }

    public static synchronized Hora getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Instancia no hecha ");
        }
        return instance;
    }


    public Hora() {

    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public List<Usuario> getCliente() {
        return cliente;
    }

    public void setCliente(List<Usuario> cliente) {
        this.cliente = cliente;
    }

    public Trabajadores getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajadores trabajador) {
        this.trabajador = trabajador;
    }
}
