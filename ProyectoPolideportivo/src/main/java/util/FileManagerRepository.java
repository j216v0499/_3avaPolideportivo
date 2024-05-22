package util;

import java.util.List;
import java.util.Map;

/**
 * Interface para los ficheros.
 *
 * @param <T> es el tipo de objeto que se supone que va a utilizar
 */
public abstract interface FileManagerRepository<T> {
    void saveFile(String fileName, T object);
    T loadFile(String fileName);
    void saveFileList(String fileName, List<?> objects);
    List<T> loadFileList(String fileName);
    void saveFileMap(String fileName, Map<?, ?> objects);
    Map<?, ?> loadFileMap(String fileName);
}
