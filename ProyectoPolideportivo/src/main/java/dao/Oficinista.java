package dao;

/**
 * La clase Oficinista representa a un oficinista en el sistema.
 * Se usará como parametro al crear las actividades y los usuarios,
 * para evitar que un usuario común pueda hacer este tipo de acciones
 * Se extiende de la clase Trabajadores.
 */
public class Oficinista extends Trabajadores{

    /**
     * Constructor para la clase Oficinista.
     *
     * @param nombre El nombre del oficinista.
     * @param pass La contraseña del oficinista.
     * @param DNI El DNI del oficinista.
     */

    public Oficinista(String nombre, String pass, String DNI) {
            super(nombre, pass, DNI);
    }

    /**
     * Constructor por defecto para la clase Oficinista.
     */

    public Oficinista() {
        super();
    }
}

