package repositories;

import dao.Usuario;
import util.FileManager;
import java.util.ArrayList;
import java.util.List;
import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BRIGHT_RED_TEXT;

/**
 * Implementación del repositorio para la gestión de oficinistas.
 */
public class RepositoryOficinista implements UsuarioRepository {

    private static RepositoryOficinista instance;

    private RepositoryOficinista() {}

    /**
     * Obtiene una instancia única de RepositoryOficinista.
     *
     * @return instancia de RepositoryOficinista
     */
    public static synchronized RepositoryOficinista getInstance() {
        if (instance == null) {
            instance = new RepositoryOficinista();
        }
        return instance;
    }

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
        FileManager.getInstance().saveFileList(FileManager.LISTA_USUARIOS, usuarios);
    }

    /**
     * Sanciona a un usuario identificado por su DNI.
     *
     * @param dni DNI del usuario a sancionar
     * @param sancion Descripción de la sanción
     */
    @Override
    public void sancionarUsuario(String dni, String sancion) {
        List<Usuario> listaUsuarios = (List<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS);

        boolean usuarioEncontrado = false;

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getDNI().equals(dni)) {
                usuario.setSancion(sancion);
                usuarioEncontrado = true;
                break;
            }
        }

        if (usuarioEncontrado) {
            FileManager.getInstance().saveFileList(FileManager.LISTA_USUARIOS, listaUsuarios);
            System.out.print(colorize("\n\t\tUsuario sancionado \n", BRIGHT_RED_TEXT()));
        } else {
            System.out.print(colorize("\nUsuario con DNI " + dni + " no encontrado.\n", BRIGHT_RED_TEXT()));
        }

        System.out.print(colorize("\n\t\tEl proceso de sancionar usuario ha terminado correctamente\n", BRIGHT_RED_TEXT()));
    }

    /**
     * Muestra la sanción de un usuario identificado por su DNI.
     *
     * @param dni DNI del usuario cuya sanción se quiere ver
     */
    @Override
    public void verSancionarUsuario(String dni) {
        List<Usuario> usuarios = (List<Usuario>) FileManager.getInstance().loadFileList(FileManager.LISTA_USUARIOS);

        for (Usuario usuario : usuarios) {
            if (usuario.getDNI().equals(dni)) {
                System.out.println(usuario.getSancion());
            }
        }
    }
}
