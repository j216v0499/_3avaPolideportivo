package model;


public class Entrenador extends Trabajadores {
    private static Entrenador instance;

    /**
     * Se usa para el instranciar objetos de entrenador
     *
     * @param nombre
     * @param pass
     * @param DNI
     */
    public Entrenador(String nombre, String pass, String DNI) {
        super(nombre, pass, DNI);
    }

    /**
     * Obtiene la instancia única de Entrenador.
     * <p>
     * La llamada inicial a este método debe proporcionar los parámetros necesarios.
     * Las llamadas posteriores ignorarán los parámetros y devolverán la instancia existente.
     *
     * @param nombre El nombre del entrenador.
     * @param pass   La contraseña del entrenador.
     * @param DNI    El DNI del entrenador.
     * @return La instancia única de Entrenador.
     */

    public static synchronized Entrenador getInstance(String nombre, String pass, String DNI) {
        if (instance == null) {
            instance = new Entrenador(nombre, pass, DNI);
        }
        return instance;
    }

    /**
     * Obtiene la instancia única.
     * Debe ser llamado después de que la instancia haya sido creada con parámetros.
     *
     * @return La instancia única.
     * @throws IllegalStateException si la instancia aún no ha sido creada.
     */

    public static synchronized Entrenador getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Instancia no hecha ");
        }
        return instance;
    }
}