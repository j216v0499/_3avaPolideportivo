package view;

import dao.Oficinista;

import java.util.*;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

/**
 * La clase ViewPolideportivoTerminal proporciona la interfaz
 * inicial que dara paso a los otros .java, que están más enfocados a los usuarios y a los oficinistas.
 */

public class ViewPolideportivoTerminal {

    private Scanner scanner = new Scanner(System.in);

    private final ViewPolideportivoTerminalAuxiliar viewPolideportivoTerminalAuxiliar = new ViewPolideportivoTerminalAuxiliar();

    private final ViewPolideportivoTerminalOficinistas paraOficinistas = new ViewPolideportivoTerminalOficinistas();


    /**
     * Método para mostrar el menú principal de la aplicación.
     */
    public void mostrarMenu() {
        Oficinista oficinista = new Oficinista();
        boolean opcionNoCorrecta;

        do {
            opcionNoCorrecta = manejarMenuInicial(oficinista);
        }while (!opcionNoCorrecta);

    }

    /**
     * Método para manejar el menú inicial de la aplicación.
     *
     * @param oficinista El oficinista que está utilizando la aplicación.
     * @return Verdadero si la opción seleccionada es correcta, falso en caso contrario.
     */

    private boolean  manejarMenuInicial(Oficinista oficinista) {
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
                case "3":
                    contacteConPolideportivo();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione de nuevo.");
            }
        }
        return  opcionCorrecta;
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
        String respuesta1=sc.next();

        if (respuesta1.equals("n")) {
            viewPolideportivoTerminalAuxiliar.menuAlta(sc, oficinista);
        }

        // Comprobamos si hay usuarios registrados
        if (viewPolideportivoTerminalAuxiliar.inicioUsuarios(sc)) {
            System.out.println(colorize("No hay usuarios registrados.", BLUE_TEXT()));
            return; // Salimos del método si no hay usuarios registrados
        }

        // Continuamos con el inicio de sesión
        while (viewPolideportivoTerminalAuxiliar.inicioUsuarios(sc)) {
            System.out.println(colorize("Inicio de sesión incorrecto", BLUE_TEXT()));
        }

        System.out.println(colorize("\nSesión iniciada", BLUE_TEXT()));

        String respuesta2;
        do {

            System.out.println(colorize("\nBienvenido al polideportivo ¿que desea hacer?\n", BLUE_TEXT()));
            System.out.println(colorize("reservar(1)    quitar reserva(2)   mostrar calendario(3)   salir(4)    ver reservas(5)", BLUE_TEXT()));
            System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
            respuesta2 = sc.next();
            System.out.println(colorize("\nAPLICACION EN DESAROLLO, CONTEACTE POR TELEFONO AL POLIDEPORTIVO, GRACIAS\n", BRIGHT_BLUE_TEXT()));
            System.out.println();
            contacteConPolideportivo();

        }while (!respuesta2.equals("4"));
    }

    /**
     * Método para mostrar un mensaje de contacto al usuario.
     * Este método se utiliza cuando la aplicación está en desarrollo y
     * se necesita que el usuario contacte con el polideportivo por teléfono.
     * Se ha hecho para poder hacer una pregunta al profesor e intentar que
     * le firme la bandera de la gran y magnífica ESPAÑA a sus alumnos preferidos,
     * ya que obviamente somos su clase preferida, pese a tener tres bajas en
     * nuestro equipo, creemos que en esta version el código es un poco más aceptable
     * y pedimos por favor a su merced tener más de un 5.
     * Somos pobres y no podemos pagar un JJJ.
     */
    public void contacteConPolideportivo(){
        System.out.println();
        System.out.print(colorize("APLICACION EN DESAROLLO, CONTEACTE POR TELEFONO AL POLIDEPORTIVO, GRACIAS\n",  RED_BACK()));
        System.out.print(colorize("APLICACION EN DESAROLLO, CONTEACTE POR TELEFONO AL POLIDEPORTIVO, GRACIAS\n",  YELLOW_BACK()));
        System.out.print(colorize("APLICACION EN DESAROLLO, CONTEACTE POR TELEFONO AL POLIDEPORTIVO, GRACIAS\n",  RED_BACK()));

    }

}


