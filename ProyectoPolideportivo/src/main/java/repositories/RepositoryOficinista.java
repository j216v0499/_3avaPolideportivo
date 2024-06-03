package repositories;

import dao.Usuario;
import util.FileManager;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase RepositoryOficinista implementa la interfaz RepositoryOficinistaInterfaz y proporciona una implementación del repositorio para la gestión de oficinistas.
 * Utiliza el patrón Singleton para garantizar que solo exista una instancia de RepositoryOficinista.
 */
public class RepositoryOficinista implements RepositoryOficinistaInterfaz {

    private static RepositoryOficinista instance;

    private RepositoryOficinista() {}

    /**
     * Obtiene una instancia única de RepositoryOficinista.
     *
     * @return instancia de RepositoryOficinista
     */
    public static RepositoryOficinista getInstance() {
        if (instance == null) {
            instance = new RepositoryOficinista();
        }
        return instance;
    }

    private final FileManager fileManager = FileManager.getInstance();

    /**
     * Da de alta un nuevo usuario.
     *
     * @param usuarios Lista de usuarios existente
     * @param usuario El nuevo usuario a dar de alta
     */
    @Override
    public void darAlta(List<Usuario> usuarios, Usuario usuario) {
        if (usuarios == null)
            usuarios = new ArrayList<>();
        usuarios.add(usuario);
        this.fileManager.getInstance().saveFileList(FileManager.LISTA_USUARIOS, usuarios);
    }

    /**
     * Sanciona a un usuario identificado por su DNI.
     *
     * @param dni DNI del usuario a sancionar
     * @param sancion Descripción de la sanción
     */
    @Override
    public boolean sancionarUsuario(String dni, String sancion) {
        List<Usuario> listaUsuarios = (List<Usuario>) this.fileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS);

        boolean usuarioEncontrado = false;

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getDNI().equals(dni)) {
                usuario.setSancion(sancion);
                usuarioEncontrado = true;
                break;
            }
        }
        if (usuarioEncontrado) {
            this.fileManager.getInstance().saveFileList(this.fileManager.getInstance().LISTA_USUARIOS, listaUsuarios);
        }

        return  usuarioEncontrado;

    }

    /**
     * Muestra la sanción de un usuario identificado por su DNI.
     *
     * @param dni DNI del usuario cuya sanción se quiere ver
     */
    @Override
    public String verSancionarUsuario(String dni) {
        List<Usuario> usuarios = (List<Usuario>) this.fileManager.getInstance().loadFileList(this.fileManager.getInstance().LISTA_USUARIOS);

        for (Usuario usuario : usuarios) {
            if (usuario.getDNI().equals(dni)) {
                return  usuario.getSancion();
            }
        }
        return "No hay sanciones";
    }
}
