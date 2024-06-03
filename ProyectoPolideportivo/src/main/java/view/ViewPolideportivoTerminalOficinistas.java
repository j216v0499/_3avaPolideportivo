package view;

import controller.ControllerOficinista;
import dao.Oficinista;

import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

/**
 * La clase ViewPolideportivoTerminalOficinistas proporciona una interfaz de terminal para interactuar con los oficinistas.
 */

public class ViewPolideportivoTerminalOficinistas {

    private final ViewPolideportivoTerminalAuxiliar viewPolideportivoTerminalAuxiliar = new ViewPolideportivoTerminalAuxiliar();

    private final ControllerOficinista controllerOficinista = new ControllerOficinista();

    /**
     * Realizar una reserva
     *
     * @param oficinista se espera el objeto de tipo oficinista
     * @param sc espera la entrada del usuario
     *
     * */
    public void appOficina(Scanner sc, Oficinista oficinista) {
        if (!usuarioExiste(sc)) {
            viewPolideportivoTerminalAuxiliar.menuAlta(sc, oficinista);
            appOficina(sc, oficinista);
            return;//Se usa para salir del metodo
        }

        iniciarSesion(sc);
        mostrarMenu(sc, oficinista);
    }

    /**
     * Método para verificar si el usuario existe.
     *
     * @param sc Scanner para leer la entrada del usuario.
     * @return Verdadero si el usuario existe, falso en caso contrario.
     */
    private boolean usuarioExiste(Scanner sc) {
        System.out.println(colorize("\n¿Ya tienes un usuario? (s/n) 'n' para darte de alta", BLUE_TEXT()));
        System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
        return !sc.next().equals("n");
    }

    /**
     * Método para iniciar sesión.
     *
     * @param sc Scanner para leer la entrada del usuario.
     */
    private void iniciarSesion(Scanner sc) {
        while (!viewPolideportivoTerminalAuxiliar.inicioSesionOficina(sc)) {
            System.out.println(colorize("\tInicio de sesión incorrecto", BLUE_TEXT()));
        }
        System.out.println(colorize("\nSesión iniciada", BLUE_TEXT()));
    }

    /**
     * Método para mostrar el menú al usuario.
     *
     * @param sc Scanner para leer la entrada del usuario.
     * @param oficinista El oficinista que está utilizando la aplicación.
     */
    private void mostrarMenu(Scanner sc, Oficinista oficinista) {
        String opcion;
        do {
            System.out.println(colorize("Sancionar(1)\tDardeAltaUsuarios(2)\tVerificarSancionar(3)\tSalir(4)", BLUE_TEXT()));
            System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
            opcion = sc.next();
            procesarOpcion(opcion, sc, oficinista);
        } while (!opcion.equals("4"));
    }

    /**
     * Método para procesar la opción seleccionada por el usuario.
     *
     * @param opcion La opción seleccionada por el usuario.
     * @param sc Scanner para leer la entrada del usuario.
     * @param oficinista El oficinista que está utilizando la aplicación.
     */
    private void procesarOpcion(String opcion, Scanner sc, Oficinista oficinista) {
        switch (opcion) {
            case "1":
                sancionarUsuario(sc);
                break;
            case "2":
                viewPolideportivoTerminalAuxiliar.menuAlta(sc, oficinista);
                break;
            case "3":
                verificarUsuario(sc);
                break;
            case "4":
                // Salir
                break;
            default:
                System.out.println(colorize("Opción no válida", BRIGHT_RED_TEXT()));
                break;
        }
    }

    /**
     * Método para sancionar a un usuario.
     *
     * @param sc Scanner para leer la entrada del usuario.
     */
    private void sancionarUsuario(Scanner sc) {
        System.out.println("¿Qué usuario quieres sancionar?");
        sc.nextLine(); // Limpiar el buffer
        System.out.println(colorize("DNI -->", BRIGHT_MAGENTA_TEXT()));
        String dni = sc.nextLine();
        System.out.println(colorize("Sanción:", BRIGHT_MAGENTA_TEXT()));
        String sancion = sc.nextLine();

        boolean usuarioEncontrado = controllerOficinista.sancionarUsuario(dni, sancion);

        if (usuarioEncontrado) {
            System.out.print(colorize("\n\t\tUsuario sancionado\n", BRIGHT_RED_TEXT()));
        } else {
            System.out.print(colorize("\nUsuario con DNI " + dni + " no encontrado.\n", BRIGHT_RED_TEXT()));
        }
    }

    /**
     * Método para verificar un usuario.
     *
     * @param sc Scanner para leer la entrada del usuario.
     */
    private void verificarUsuario(Scanner sc) {
        System.out.println("¿Qué usuario quieres verificar? DNI:");
        sc.nextLine(); // Limpiar el buffer
        String dni = sc.nextLine();
        System.out.println(controllerOficinista.verSancionarUsuario(dni));
    }

}