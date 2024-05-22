package model;

import base.Writable;

public class Usuario extends Writable {

    private String DNI;
    private String nombre;
    private String pass;

    private boolean esAdmin;
    private boolean estaSancionado;


    public Usuario(String nombre, String pass,String DNI,Boolean esAdmin ) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.pass = pass;
        this.esAdmin = esAdmin;
        this.estaSancionado=false;

    }

//    public Usuario(String nombre, String pass,String DNI) {
//        this.DNI = DNI;
//        this.nombre = nombre;
//        this.pass = pass;
//        this.esAdmin = false;
//        this.estaSancionado=false;
//
//    }


    public String getNombre() {
        return nombre;
    }

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
}