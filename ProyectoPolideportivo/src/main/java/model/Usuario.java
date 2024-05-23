package model;

import base.Writable;

public class Usuario extends Writable {

    private String DNI;
    private String nombre;
    private String pass;
    private boolean esAdmin;
    private boolean estaSancionado;

    private String sancion;


    public Usuario(String nombre, String pass,String DNI,Boolean esAdmin ) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.pass = pass;
        this.esAdmin = esAdmin;
        this.estaSancionado=false;
        this.sancion = null;

    }

    /**
     * Constructor para usuario
     *
     * @param DNI se espera el dni
     * @param nombre nombre del ususuario
     * @param pass contraseña
     *
     * */

    public Usuario(String nombre, String pass,String DNI) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.pass = pass;
        this.esAdmin = false;
        this.estaSancionado=false;
        this.sancion = null;

    }

    /**
     * Constructor para usuario
     *
     * @param DNI se espera el dni
     * @param nombre nombre del usuario
     * @param pass contraseña
     * @param sancion sanicion directa al usuario
     * @param esAdmin bolean por sii fuera admin
     *
     * */
    public Usuario(String nombre, String pass,String DNI,Boolean esAdmin,String sancion ) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.pass = pass;
        this.esAdmin = esAdmin;
        this.estaSancionado=false;
        this.sancion = sancion;

    }

    /**
     * Constructor copia
     *
     * */
    public Usuario(Usuario usuario) {
        this.nombre = usuario.getDNI();
        this.pass = usuario.getPass();
        this.esAdmin = usuario.esAdmin;
        this.estaSancionado= usuario.estaSancionado;
        this.sancion = usuario.sancion;

    }
    /**
     * Devuelve el nombre
     * */

    public String getNombre() {
        return nombre;
    }

    /**
     * Introduce el nombre
     * */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public boolean isEsAdmin() {
        return esAdmin;
    }

    public boolean isEstaSancionado() {
        return estaSancionado;
    }

    public void setEstaSancionado(boolean estaSancionado) {
        this.estaSancionado = estaSancionado;
    }


    public String getSancion() {
        return sancion;
    }

    public void setSancion(String sancion) {
        if(this.sancion!=null) {
            this.sancion += " " + sancion;
            this.estaSancionado = true;
        }else{
            this.sancion=sancion;
        }
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pass='" + pass + '\'' +
                ", esAdmin=" + esAdmin +
                ", estaSancionado=" + estaSancionado +
                ", sancion='" + sancion + '\'' +
                '}';
    }
}

