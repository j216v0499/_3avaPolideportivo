package dao;

import base.Writable;

/**
 * La clase Usuario representa un usuario en el sistema.
 * Cada usuario tiene un DNI, nombre, contraseña, estado de administrador, estado de sanción y detalles de sanción.
 */
public class Usuario extends Writable {

    private String DNI;
    private String nombre;
    private String pass;
    private boolean esAdmin;
    private boolean estaSancionado;
    private String sancion;

    /**
     * Constructor para crear un nuevo usuario con nombre, contraseña, DNI y estado de administrador.
     *
     * @param nombre El nombre del usuario.
     * @param pass La contraseña del usuario.
     * @param DNI El DNI del usuario.
     * @param esAdmin El estado de administrador del usuario.
     */
    public Usuario(String nombre, String pass,String DNI,Boolean esAdmin ) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.pass = pass;
        this.esAdmin = esAdmin;
        this.estaSancionado=false;
        this.sancion = null;
    }

    /**
     * Constructor para crear un nuevo usuario con nombre, contraseña y DNI.
     * El usuario no es un administrador por defecto.
     *
     * @param nombre El nombre del usuario.
     * @param pass La contraseña del usuario.
     * @param DNI El DNI del usuario.
     */
    public Usuario(String nombre, String pass,String DNI) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.pass = pass;
        this.esAdmin = false;
        this.estaSancionado=false;
        this.sancion = null;
    }

    /**
     * Constructor para crear un nuevo usuario con nombre, contraseña, DNI, estado de administrador y sanción.
     *
     * @param nombre El nombre del usuario.
     * @param pass La contraseña del usuario.
     * @param DNI El DNI del usuario.
     * @param esAdmin El estado de administrador del usuario.
     * @param sancion La sanción del usuario.
     */
    public Usuario(String nombre, String pass,String DNI,Boolean esAdmin,String sancion ) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.pass = pass;
        this.esAdmin = esAdmin;
        this.estaSancionado=false;
        this.sancion = sancion;
    }

    /**
     * Constructor de copia para crear un nuevo usuario a partir de un usuario existente.
     *
     * @param usuario El usuario existente.
     */
    public Usuario(Usuario usuario) {
        this.nombre = usuario.getDNI();
        this.pass = usuario.getPass();
        this.esAdmin = usuario.esAdmin;
        this.estaSancionado= usuario.estaSancionado;
        this.sancion = usuario.sancion;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el DNI del usuario.
     *
     * @return El DNI del usuario.
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Establece el DNI del usuario.
     *
     * @param DNI El nuevo DNI del usuario.
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPass() {
        return pass;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param pass La nueva contraseña del usuario.
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Comprueba si el usuario es administrador.
     *
     * @return Verdadero si el usuario es administrador, falso en caso contrario.
     */
    public boolean isEsAdmin() {
        return esAdmin;
    }

    /**
     * Comprueba si el usuario está sancionado.
     *
     * @return Verdadero si el usuario está sancionado, falso en caso contrario.
     */
    public boolean isEstaSancionado() {
        return estaSancionado;
    }

    /**
     * Establece el estado de sanción del usuario.
     *
     * @param estaSancionado El nuevo estado de sanción del usuario.
     */
    public void setEstaSancionado(boolean estaSancionado) {
        this.estaSancionado = estaSancionado;
    }

    /**
     * Obtiene la sanción del usuario.
     *
     * @return La sanción del usuario.
     */
    public String getSancion() {
        return sancion;
    }

    /**
     * Establece la sanción del usuario.
     * Si el usuario ya tiene una sanción, se añade la nueva sanción a la existente y se establece el estado de sanción a verdadero.
     *
     * @param sancion La nueva sanción del usuario.
     */
    public void setSancion(String sancion) {
        if(this.sancion!=null) {
            this.sancion += " " + sancion;
            this.estaSancionado = true;
        }else{
            this.sancion=sancion;
        }
    }
}
