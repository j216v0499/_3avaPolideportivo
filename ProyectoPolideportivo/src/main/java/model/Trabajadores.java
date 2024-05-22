package model;

import base.Writable;

public class Trabajadores extends Writable {
    private static Trabajadores instance;
    private String nombre;
    private String pass;
    private String DNI;

    public Trabajadores(String nombre, String pass, String DNI) {
        this.nombre = nombre;
        this.pass = pass;
        this.DNI = DNI;
    }
    /**
     * Obtiene la instancia única de Trabajador.
     *
     * La llamada inicial a este método debe proporcionar los parámetros necesarios.
     * Las llamadas posteriores ignorarán los parámetros y devolverán la instancia existente.
     *
     * @param nombre El nombre del trabajador.
     * @param pass La contraseña del trabajador.
     * @param DNI El DNI del trabajador.
     * @return La instancia única de Entrenador.
     */
    public static synchronized Trabajadores getInstance (String nombre, String pass, String DNI){
        if (instance == null) {
            instance = new Entrenador(nombre, pass, DNI);
        }
        return instance;
    }

    public static synchronized Trabajadores getInstance () {
        if (instance == null) {
            throw new IllegalStateException("Instancia no hecha ");
        }
        return instance;
    }









    public Trabajadores() {

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
