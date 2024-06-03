package dao;

import base.Writable;

/**
 * La clase Trabajadores representa a los trabajadores en el sistema.
 * Se extiende de la clase Writable a su vez de serializable.
 */

public class Trabajadores extends Writable {
    private String nombre;
    private String pass;
    private String DNI;

    /**
     * Constructor para la clase Trabajadores.
     *
     * @param nombre El nombre del trabajador.
     * @param pass La contraseña del trabajador.
     * @param DNI El DNI del trabajador.
     */

    public Trabajadores(String nombre, String pass, String DNI) {
        this.nombre = nombre;
        this.pass = pass;
        this.DNI = DNI;
    }







    public Trabajadores() {

    }








    /**
     * Obtiene el nombre del trabajador.
     *
     * @return El nombre del trabajador.
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del trabajador.
     *
     * @param nombre El nombre del trabajador.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del trabajador.
     *
     * @return La contraseña del trabajador.
     */

    public String getPass() {
        return pass;
    }

    /**
     * Establece la contraseña del trabajador.
     *
     * @param pass La contraseña del trabajador.
     */

    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Obtiene el DNI del trabajador.
     *
     * @return El DNI del trabajador.
     */

    public String getDNI() {
        return DNI;
    }


    /**
     * Establece el DNI del trabajador.
     *
     * @param DNI El DNI del trabajador.
     */

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
