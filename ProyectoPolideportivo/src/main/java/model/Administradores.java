package model;

public class Administradores extends Trabajadores {

    private static Administradores instance;

    // Private constructor
    private Administradores(String nombre, String pass, String DNI) {
        super(nombre, pass, DNI);
    }

    /**
     * Obtiene la instancia única de Administradores.
     *
     * La llamada inicial a este método debe proporcionar los parámetros necesarios.
     * Las llamadas posteriores ignorarán los parámetros y devolverán la instancia existente.
     *
     * @param nombre El nombre del administrador.
     * @param pass La contraseña del administrador.
     * @param DNI El DNI del administrador.
     * @return La instancia única de Administradores.
     */
    public static synchronized Administradores getInstance(String nombre, String pass, String DNI) {
        if (instance == null) {
            instance = new Administradores(nombre, pass, DNI);
        }
        return instance;
    }

    public static synchronized Administradores getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Instancia no hecha ");
        }
        return instance;
    }
}