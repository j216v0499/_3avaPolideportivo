package repositories;

import dao.Usuario;
import java.util.List;

/**
 * La interfaz RepositoryOficinistaInterfaz define los métodos que deben ser implementados para la gestión de oficinistas.
 */
public interface RepositoryOficinistaInterfaz {

    /**
     * Método para dar de alta a un nuevo usuario.
     *
     * @param usuarios La lista de usuarios existentes.
     * @param usuario El nuevo usuario a dar de alta.
     */
    void darAlta(List<Usuario> usuarios, Usuario usuario);

    /**
     * Método para sancionar a un usuario identificado por su DNI.
     *
     * @param dni El DNI del usuario a sancionar.
     * @param sancion La descripción de la sanción.
     * @return Verdadero si el usuario fue encontrado y sancionado, falso en caso contrario.
     */
    boolean sancionarUsuario(String dni, String sancion);

    /**
     * Método para ver la sanción de un usuario identificado por su DNI.
     *
     * @param dni El DNI del usuario cuya sanción se quiere ver.
     */
    void verSancionarUsuario(String dni);
}
