package controller;

import base.Writable;

public class Usuario extends Writable {

    private String DNI;
    private String nombre;
    private String pass;

    public Usuario(String nombre, String pass,String DNI) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.pass = pass;
    }


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
}
