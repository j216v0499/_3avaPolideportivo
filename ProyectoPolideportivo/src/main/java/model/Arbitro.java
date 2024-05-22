package model;

import model.Trabajadores;

public class Arbitro extends Trabajadores {

    private static Arbitro instance;
    public Arbitro(String nombre, String pass, String DNI) {
        super(nombre, pass, DNI);
    }

    /**
     * Obtiene la instancia única de Árbitro.
     *
     * La llamada inicial a este método debe proporcionar los parámetros necesarios.
     * Las llamadas posteriores ignorarán los parámetros y devolverán la instancia existente.
     *
     * @param nombre El nombre del árbitro.
     * @param pass La contraseña del árbitro.
     * @param DNI El DNI del árbitro.
     * @return La instancia única de Árbitro.
     */
    public static synchronized Arbitro getInstance(String nombre, String pass, String DNI) {
        if (instance == null) {
            instance = new Arbitro(nombre, pass, DNI);
        }
        return instance;
    }

    public static synchronized Arbitro getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Instancia no hecha ");
        }
        return instance;
    }
}


