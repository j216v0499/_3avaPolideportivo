package util;

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
    public static final String NUMERO_USUARIO = "numUser";
    public static final String CAL_FUTBOL = "FUTBOL";
    public static final String CAL_BALONCESTO = "BALONCESTO";
    public static final String CAL_PADEL = "PADEL";
    public static final String CAL_TENIS = "TENIS";
    public static final String CAL_FRONTON = "FRONTON";
    public static final String CAL_YOGA = "YOGA";
    public static final String CAL_SPINNING = "SPINNING";

    private static FileManager instance;

    private FileManager() {}

    /**
     * Gets the single instance of FileManager.
     *
     * @return single instance of FileManager
     */
    public static synchronized FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    /**
     * Saves an object to a file.
     *
     * @param fileName the name of the file
     * @param object the object to save
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
     * Loads an object from a file.
     *
     * @param fileName the name of the file
     * @return the loaded object
     */
    @Override
    public T loadFile(String fileName) {
        File file = new File(fileName);
        T object = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream reader = new ObjectInputStream(fis)) {

            object = (T) reader.readObject();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo. " + e.getMessage());
        }
        return object;
    }

    /**
     * Saves a list of objects to a file.
     *
     * @param fileName the name of the file
     * @param objects the list of objects to save
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
     * Loads a list of objects from a file.
     *
     * @param fileName the name of the file
     * @return the loaded list of objects
     */
    @Override
    public List<T> loadFileList(String fileName) {
        File file = new File(fileName);
        List<T> list = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream reader = new ObjectInputStream(fis)) {

            list = (List<T>) reader.readObject();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo. " + e.getMessage());
        }
        return list;
    }

    /**
     * Saves a map of objects to a file.
     *
     * @param fileName the name of the file
     * @param objects the map of objects to save
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
     * Loads a map of objects from a file.
     *
     * @param fileName the name of the file
     * @return the loaded map of objects
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


