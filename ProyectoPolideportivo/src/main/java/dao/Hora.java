package dao;

import base.Writable;
import model.Trabajadores;
import model.Usuario;

import java.util.List;

/**
 * La clase Hora representa una hora en el sistema.
 * Se extiende de la clase Writable.
 */

public class Hora extends Writable {

    private String formato;
    private List<Usuario> cliente;
    private Trabajadores trabajador;

    /**
     * Constructor para la clase Hora.
     *
     * @param formato El formato de la hora.
     * @param cliente La lista de clientes.
     * @param trabajador El trabajador asignado.
     */

    public Hora(String formato, List<Usuario> cliente, Trabajadores trabajador) {
        this.formato = formato;
        this.cliente = cliente;
        this.trabajador = trabajador;
    }

    /**
     * Obtiene el formato de la hora.
     *
     * @return El formato de la hora.
     */

    public String getFormato() {
        return formato;
    }

    /**
     * Establece el formato de la hora.
     *
     * @param formato El formato de la hora.
     */

    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * Obtiene la lista de clientes.
     *
     * @return La lista de clientes.
     */

    public List<Usuario> getCliente() {
        return cliente;
    }

    /**
     * Establece la lista de clientes.
     *
     * @param cliente La lista de clientes.
     */

    public void setCliente(List<Usuario> cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el trabajador asignado.
     *
     * @return El trabajador asignado.
     */

    public Trabajadores getTrabajador() {
        return trabajador;
    }

    /**
     * Establece el trabajador asignado.
     *
     * @param trabajador El trabajador asignado.
     */

    public void setTrabajador(Trabajadores trabajador) {
        this.trabajador = trabajador;
    }
}
