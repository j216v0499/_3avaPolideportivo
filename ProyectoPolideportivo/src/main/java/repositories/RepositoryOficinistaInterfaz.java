package repositories;

import dao.Usuario;
import java.util.List;

public interface RepositoryOficinistaInterfaz {
    void darAlta(List<Usuario> usuarios, Usuario usuario);
    boolean sancionarUsuario(String dni, String sancion);
    void verSancionarUsuario(String dni);
}
