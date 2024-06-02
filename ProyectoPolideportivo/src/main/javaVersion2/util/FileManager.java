package util;

import repositories.FileManagerRepository;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Singleton para la manipulacion de archivos.
 *
 * @param <T> tipo de objeto
 */
public class FileManager<T> implements FileManagerRepository<T> {

    public static final String LISTA_USUARIOS = "listausu";
    public static final String LISTA_USUARIOS_BAN = "listausuban";

    public static final String NUMERO_USUARIO = "numUser";

    private static FileManager instance;

    private FileManager() {}

    /**
     * Obtiene una sola  instancia de FileManager.
     *
     * @return instancia de FileManager
     */
    public static synchronized FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    /**
     * Guarda un objeto en un fichero
     *
     * @param fileName nombre del archivo
     * @param object objeto
     */
    @Override
    public void saveFile(String fileName, T object) {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream escribir = new ObjectOutputStream(fos)) {
            escribir.writeObject(object);

        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo. " + e.getMessage());
        }
    }

    /**
     * Carga un objeto de un fichero.
     *
     * @param fileName nombre del archivo
     * @return objeto
     */
    @Override
    public T loadFile(String fileName) {
        File file = new File(fileName);
        T object = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream reader = new ObjectInputStream(fis)) {

            //Aquí puede haber problemas, por el tema del casting
            object = (T) reader.readObject();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo. " + e.getMessage());
        }
        return object;
    }

    /**
     * Guarda una lista de objetos en un fichero.
     *
     * @param fileName nombre del fichero
     * @param objects lista de los objetos
     */
    @Override
    public void saveFileList(String fileName, List<?> objects) {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream escribir = new ObjectOutputStream(fos)) {

            escribir.writeObject(objects);

        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo. " + e.getMessage());
        }
    }

    /**
     * Carga una lista de objetos desde un fichero.
     *
     * @param fileName nombre fichero
     * @return lista de objetos
     */
    @Override
    public List<T> loadFileList(String fileName) {
        File file = new File(fileName);
        List<T> list = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream reader = new ObjectInputStream(fis)) {

            //Aquí puede haber problemas, por el tema del casting
            list = (List<T>) reader.readObject();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo. " + e.getMessage());
        }
        return list;
    }

    /**
     * Guarda un mapa de objetos en un fichero.
     *
     * @param fileName nombre archivo
     * @param objects mapa de objetos
     */
    @Override
    public void saveFileMap(String fileName, Map<?, ?> objects) {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream escribir = new ObjectOutputStream(fos)) {

            escribir.writeObject(objects);

        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo. " + e.getMessage());
        }
    }

    /**
     * Carga un mapa de objetos desde un fichero.
     *
     * @param fileName nombre archivo
     * @return mapa de objetos
     */
    @Override
    public Map<?, ?> loadFileMap(String fileName) {
        File file = new File(fileName);
        Map<?, ?> map = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream reader = new ObjectInputStream(fis)) {

            map = (Map<?, ?>) reader.readObject();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo. " + e.getMessage());
        }
        return map;
    }


}


