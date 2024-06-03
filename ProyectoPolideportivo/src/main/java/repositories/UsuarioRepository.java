package repositories;

import dao.Usuario;
import java.util.List;

public interface UsuarioRepository {
    void darAlta(List<Usuario> usuarios, Usuario usuario);
    void sancionarUsuario(String dni, String sancion);
    void verSancionarUsuario(String dni);
}
