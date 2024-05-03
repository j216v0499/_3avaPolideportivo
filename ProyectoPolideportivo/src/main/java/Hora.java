import base.Writable;

import java.util.ArrayList;
import java.util.List;

public class Hora extends Writable {

    private String formato;

    private List<Usuario> cliente;

    private Trabajadores trabajador;

    public Hora(String formato, List<Usuario> cliente, Trabajadores trabajador) {
        this.formato = formato;
        this.cliente = cliente;
        this.trabajador = trabajador;
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
