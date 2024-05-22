package model;

import model.Trabajadores;

public class Entrenador extends Trabajadores {
    private static Entrenador instance;

    public Entrenador(String nombre, String pass, String DNI) {
        super(nombre, pass, DNI);
    }
        /**
         * Obtiene la instancia única de Entrenador.
         *
         * La llamada inicial a este método debe proporcionar los parámetros necesarios.
         * Las llamadas posteriores ignorarán los parámetros y devolverán la instancia existente.
         *
         * @param nombre El nombre del entrenador.
         * @param pass La contraseña del entrenador.
         * @param DNI El DNI del entrenador.
         * @return La instancia única de Entrenador.
         */
        public static synchronized Entrenador getInstance (String nombre, String pass, String DNI){
            if (instance == null) {
                instance = new Entrenador(nombre, pass, DNI);
            }
            return instance;
        }

        public static synchronized Entrenador getInstance () {
            if (instance == null) {
                throw new IllegalStateException("Instancia no hecha ");
            }
            return instance;
        }
    }