package view;

import controller.*;
import dao.Semana;

import java.util.*;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BLUE_TEXT;
import static com.diogonunes.jcolor.Attribute.BRIGHT_BLUE_TEXT;


public class ViewPolideportivoTerminal {

    //private ControllerProduct controllerProduct = new ControllerProduct();
    private Scanner scanner = new Scanner(System.in);

    private final ViewPolideportivoTerminalAuxiliar viewPolideportivoTerminalAuxiliar = new ViewPolideportivoTerminalAuxiliar();

    private final ParaOficinistas paraOficinistas = new ParaOficinistas();


    public void mostrarMenu() {
        // Creación de oficinista y mapa de actividades
        Oficinista oficinista = new Oficinista();
        Map<Actividades, List<Semana>> semanaActs = new HashMap<>();

        // Definir y asignar un valor a actividad
        //Actividades actividad = Actividades.FUTBOL;

        // Manejo del menú inicial
        manejarMenuInicial(oficinista, semanaActs);
        //LauncherTerminal.manejarMenuInicial(sc, oficinista, semanaActs);

    }

    private void manejarMenuInicial(Oficinista oficinista, Map<Actividades, List<Semana>> semanaActs) {
        boolean opcionCorrecta = false;
        while (!opcionCorrecta) {
            String opcion = viewPolideportivoTerminalAuxiliar.menuInicial();
            switch (opcion) {
                case "1":
                    opcionCorrecta = true;
                    appParaUsuarios(scanner, oficinista);
                    break;
                case "2":
                    opcionCorrecta = true;
                    paraOficinistas.appOficina(scanner, oficinista);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione de nuevo.");
            }
        }
    }


    /**
     *  Se carga la aplicacción movil
     *
     * @param sc se espera la entrada del usuario
     * @param oficinista se espera el acceso de un oficinista
     *
     */

    public void appParaUsuarios(Scanner sc, Oficinista oficinista){

        System.out.println(colorize("\n¿Ya tienes un usuario? (s/n) 'n' para darte de alta", BLUE_TEXT()));
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        String res1=sc.next();
        if (res1.equals("n")) {
            viewPolideportivoTerminalAuxiliar.menuAlta(sc, oficinista);
        }

        // Comprobamos si hay usuarios registrados
        if (!viewPolideportivoTerminalAuxiliar.inicioSesionUsuarios(sc)) {
            System.out.println(colorize("No hay usuarios registrados.", BLUE_TEXT()));
            return; // Salimos del método si no hay usuarios registrados
        }

        // Continuamos con el inicio de sesión
        while (!viewPolideportivoTerminalAuxiliar.inicioSesionUsuarios(sc)) {
            System.out.println(colorize("Inicio de sesión incorrecto", BLUE_TEXT()));
        }

        System.out.println(colorize("\nSesión iniciada", BLUE_TEXT()));

        String res2="";
        do {

            System.out.println(colorize("\nBienvenido al polideportivo ¿que desea hacer?\n", BLUE_TEXT()));
            System.out.println(colorize("reservar(1)    quitar reserva(2)   mostrar calendario(3)   salir(4)    ver reservas(5)", BLUE_TEXT()));
            System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
            res2 = sc.next();
            System.out.println(colorize("\nAPLICACION EN DESAROLLO, CONTEACTE POR TELEFONO AL POLIDEPORTIVO, GRACIAS\n", BRIGHT_BLUE_TEXT()));

        }while (!res2.equals("4"));
    }
}


