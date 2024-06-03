package util;

import java.util.List;
import java.util.Map;

/**
 * La interfaz FileManagerInterfaz define los métodos que deben ser implementados para la gestión de archivos.
 *
 * @param <T> El tipo de objeto que se espera manejar.
 */
public interface FileManagerInterfaz<T> {

    /**
     * Método para guardar un objeto en un archivo.
     *
     * @param fileName El nombre del archivo.
     * @param object El objeto a guardar.
     */
    public void saveFile(String fileName, T object);

    /**
     * Método para cargar un objeto desde un archivo.
     *
     * @param fileName El nombre del archivo.
     * @return El objeto cargado.
     */
    T loadFile(String fileName);

    /**
     * Método para guardar una lista de objetos en un archivo.
     *
     * @param fileName El nombre del archivo.
     * @param objects La lista de objetos a guardar.
     */
    void saveFileList(String fileName, List<?> objects);

    /**
     * Método para cargar una lista de objetos desde un archivo.
     *
     * @param fileName El nombre del archivo.
     * @return La lista de objetos cargada.
     */
    List<T> loadFileList(String fileName);

    /**
     * Método para guardar un mapa de objetos en un archivo.
     *
     * @param fileName El nombre del archivo.
     * @param objects El mapa de objetos a guardar.
     */
    void saveFileMap(String fileName, Map<?, ?> objects);

    /**
     * Método para cargar un mapa de objetos desde un archivo.
     *
     * @param fileName El nombre del archivo.
     * @return El mapa de objetos cargado.
     */
    Map<?, ?> loadFileMap(String fileName);
}
