import util.FileManager;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //actividades
        int numAct = 0;Actividades actividad = Actividades.FUTBOL;
        //Oficinista
        Oficinista oficinista = new Oficinista();

        Map<Actividades, List<Semana>> semanaActs = new HashMap<>();


        if (FileManager.loadFileMap("mapa")==null)
            rellenarActividades(calendario(), semanaActs);

        if (FileManager.loadFileMap("reservas")==null){
            List<Reserva> reservas = new ArrayList<>();
            FileManager.saveFileList("reservas", reservas);
        }



        System.out.println(colorize("\nＰＯＬＩＤＥＰＯＲＴＩＶＯ",BRIGHT_BLUE_TEXT()));

        System.out.println(colorize("\nAccedes como...", BLUE_TEXT()));
        System.out.println(colorize("\nusuario(1)[app movil]         trabajador(2)[app oficina]", BLUE_TEXT()));
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        String menu1 = sc.next();
        if (menu1.equals("1")){
            appMovil(sc,oficinista, actividad);
        }else{
            appOficina(sc);
        }


    }
    public static List<Semana> calendario(){

        //Código para generar las fechas del año
        LocalDate fechaInicio = LocalDate.parse("2023-01-01");
        LocalDate fechaFinal = LocalDate.parse("2024-01-01");
        List<LocalDate> dates = Stream.iterate(fechaInicio, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(fechaInicio, fechaFinal))
                .collect(Collectors.toList());

        //Generación de la lista para funcionar como semana
        Semana semana = new Semana();
        List<Semana> SEMANAS = new ArrayList<>();


        //bucle para generar fechas y rellenar la lista
        for (LocalDate date: dates){

            //Introducción de dias en semana
            if(!date.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                Dia dia = new Dia(date.getDayOfWeek().toString());
                semana.getDias().add(dia);

                //Introducción de horas en dias trabajadores y clientes en horas
                for (int i = 0; i<10;i++) {
                    Hora hora = new Hora();
                    Usuario usuario = new Usuario("Disponible","pass",null);
                    Trabajadores trabajador = new Trabajadores("Nombre","pass",null);
                    hora.getCliente().add(usuario);
                    hora.setTrabajador(trabajador);
                    hora.setFormato("00:00");
                    dia.getHora().add(hora);
                }
            }

            //filtro de dias (solo de lunes a viernes)
            if(date.getDayOfWeek().equals(DayOfWeek.MONDAY)){
                semana.setInicio(date);
            }
            if(date.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
                semana.setFin(date);
                SEMANAS.add(semana);
                semana = new Semana();
            }
        }


        //Devolución de la lista con las semanas rellenadas
        return SEMANAS;

    }
    public static void mostrarCalendario(int numSemana, Actividades actividad){


        Map<Actividades, List<Semana>> semanaActs = FileManager.loadFileMap("mapa");

        System.out.println(colorize("\n*------------------------------------------------------------------------------------------------------------------------*"));
        System.out.println(colorize("    Semana (" + numSemana + ") "  + semanaActs.get(actividad).get(numSemana).getInicio().toString() + " - " + actividad.toString()));
        System.out.println(colorize("*------------------------------------------------------------------------------------------------------------------------*"));
        System.out.println(colorize("    Horario               Lunes            Martes        Miércoles          Jueves          Viernes  "));
        System.out.println(colorize("*------------------------------------------------------------------------------------------------------------------------*"));

        int hora = 8;
        for (int i = 0; i< semanaActs.get(actividad).get(numSemana).getDias().get(0).getHora().size(); i++) {

            if (hora<10){System.out.print("    0" + hora +":00               ");}else{System.out.print("    " + hora +":00               ");}
            for (int j = 0; j < semanaActs.get(actividad).get(numSemana).getDias().size(); j++) {
                if (semanaActs.get(actividad).get(numSemana).getDias().get(j).getHora().get(i).getCliente().get(FileManager.loadFile(FileManager.NUMERO_USUARIO)).getNombre().equals("Reservado")){
                    System.out.print(colorize(semanaActs.get(actividad).get(numSemana).getDias().get(j).getHora().get(i).getCliente().get(FileManager.loadFile(FileManager.NUMERO_USUARIO)).getNombre(),RED_BACK()));
                }
                if (semanaActs.get(actividad).get(numSemana).getDias().get(j).getHora().get(i).getCliente().get(FileManager.loadFile(FileManager.NUMERO_USUARIO)).getNombre().equals("Disponible")){
                    System.out.print(colorize(semanaActs.get(actividad).get(numSemana).getDias().get(j).getHora().get(i).getCliente().get(FileManager.loadFile(FileManager.NUMERO_USUARIO)).getNombre(),GREEN_BACK(),BLACK_TEXT()));
                }
                System.out.print("       ");
            }
            System.out.println(colorize("\n*------------------------------------------------------------------------------------------------------------------------*"));
            if (hora==13){hora=hora+4;}else{hora++;}
        }

    }
    public static void rellenarActividades(List<Semana> SEMANAS, Map<Actividades,List<Semana>> semanaActs){



            for (Actividades actividades : Actividades.values()){
            semanaActs.put(actividades,SEMANAS);
            }
        FileManager.saveFileMap("mapa", semanaActs);






    }
    public static void menuAlta(Scanner sc,Oficinista oficinista){

        System.out.print(colorize("\nNombre de usuario: ",BRIGHT_RED_TEXT()));
        String nomUser = sc.next();
        System.out.print(colorize("\nIntroduce tu DNI para identificarte: ",BRIGHT_RED_TEXT()));
        String DNI = sc.next();
        System.out.print(colorize("\nAsignar contraseña: ",BRIGHT_RED_TEXT()));
        String pass = sc.next();

        Usuario usuario = new Usuario(nomUser,pass,DNI);


        List<Usuario> usuarios1 = (List<Usuario>) FileManager.loadFileList(FileManager.LISTA_USUARIOS);
        oficinista.darAlta(nomUser,pass,DNI,usuarios1,usuario);
        System.out.print(colorize("\nUsuario dado de Alta\n ",BRIGHT_RED_TEXT()));



    }
    public static void reservarYmostrar(Oficinista oficinista,Actividades actividad,String nomReserva,int numUser,int numSemana,int numHora, int numDia, List<Reserva> reservas){
        oficinista.realizarReserva(actividad,nomReserva,numUser,numSemana,numHora,numDia);
        mostrarCalendario(numSemana,actividad);
    }
    public static void quitarYmostrar(Oficinista oficinista,Actividades actividad, int numUser, int numSemana, int numHora, int numDia){
        oficinista.quitarReserva(actividad, numUser,numSemana,numHora,numDia, (List<Reserva>) FileManager.loadFileList("reservas"));
        mostrarCalendario(numSemana,actividad);
    }
    public static void appMovil(Scanner sc, Oficinista oficinista, Actividades actividad){

        System.out.println(colorize("\n¿Ya tienes un usuario? (s/n) 'n' para darte de alta", BLUE_TEXT()));
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        String res1=sc.next();
        if (res1.equals("n")) {
            menuAlta(sc, oficinista);
        }
            while (!inicioSesion(sc)){
                System.out.println(colorize("inicio de sesion incorrecto", BLUE_TEXT()));
            };
            System.out.println(colorize("\nSesión iniciada", BLUE_TEXT()));


        String res2="";
        do {

            System.out.println(colorize("\nBienvenido al polideportivo ¿que desea hacer?\n", BLUE_TEXT()));
            System.out.println(colorize("reservar(1)    quitar reserva(2)   mostrar calendario(3)   salir(4)    ver reservas(5)", BLUE_TEXT()));
            System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
            res2 = sc.next();


            if (res2.equals("3")){
                verCalendario(sc);
            }

            if (!res2.equals("3") && !res2.equals("4")) {
                //Actividad
                System.out.println(colorize("\n¿Que actividad eliges para reservar?", BLUE_TEXT()));
                int cont1 = 0;
                for (Actividades act : Actividades.values()) {
                    System.out.println(colorize("(" + cont1 + ")" + act.toString(), BLUE_TEXT()));
                    cont1++;
                }
                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
                int numAct = sc.nextInt();
                actividad = eleccionActividad(actividad, numAct);

                //Semana
                System.out.println(colorize("\n¿En que semana quieres situarte? (0-51)", BLUE_TEXT()));
                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
                int numSemana = sc.nextInt();

                //Dia
                System.out.println(colorize("\n¿Que dia quieres reservar? (0-4)", BLUE_TEXT()));
                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
                int numDia = sc.nextInt();

                //Hora
                int cont2 = 8;
                System.out.println(colorize("\n¿A que hora?", BLUE_TEXT()));
                for (int i = 0; i < 10; i++) {
                    if (cont2 < 10) {
                        System.out.println(colorize("(" + i + ")    0" + cont2 + ":00               ", BLUE_TEXT()));
                    } else {
                        System.out.println(colorize("(" + i + ")    " + cont2 + ":00               ", BLUE_TEXT()));
                    }
                    if (cont2 == 13) {
                        cont2 = cont2 + 4;
                    } else {
                        cont2++;
                    }
                }
                System.out.print(colorize("--> ", BRIGHT_BLUE_TEXT()));
                int numHora = sc.nextInt();

                if (res2.equals("1")) {
                    reservarYmostrar(oficinista, actividad, "Reservado", FileManager.loadFile(FileManager.NUMERO_USUARIO), numSemana, numHora, numDia,(List<Reserva>) FileManager.loadFileList("reservas"));
                } else if (res2.equals("2")) {
                    quitarYmostrar(oficinista, actividad, FileManager.loadFile(FileManager.NUMERO_USUARIO), numSemana, numHora, numDia);
                }

                if (res2.equals("5")){
                    verReservas(oficinista, actividad, FileManager.loadFile(FileManager.NUMERO_USUARIO), numSemana, numHora, numDia);
                }
            }
        }while (!res2.equals("4"));



    }
    public static void appOficina(Scanner sc){





    }
    public static boolean inicioSesion(Scanner sc){

        System.out.println(colorize("\nLista de usuarios registrados (elige que perfil utilizar):", BLUE_TEXT()));

        ArrayList<Usuario> usus1 = (ArrayList<Usuario>) FileManager.loadFileList(FileManager.LISTA_USUARIOS);

        int contador = 0;
        for (Usuario eleccion : usus1){
            System.out.println(colorize("(" + contador + ")" + eleccion.getNombre().toString(), BLUE_TEXT()));
            contador++;
        }
        System.out.println();
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        int numUser = sc.nextInt();


        System.out.println(colorize("\nIdentificación:", BLUE_TEXT()));
        System.out.print(colorize("-> ",BRIGHT_BLUE_TEXT()));
        String DNI= sc.next();
        System.out.println(colorize("\ncontrasenya:", BLUE_TEXT()));
        System.out.print(colorize("-> ",BRIGHT_BLUE_TEXT()));
        String pass= sc.next();

        FileManager.saveFile(FileManager.NUMERO_USUARIO,numUser);

        //comprobación con el filemanager de DNI y pass (if igual true, else false)

        ArrayList<Usuario> usus2 = (ArrayList<Usuario>) FileManager.loadFileList(FileManager.LISTA_USUARIOS);

        if (usus2.get(numUser).getDNI().toString().equals(DNI) && usus2.get(numUser).getPass().toString().equals(pass))
            return true;
        return false;
    }
    public static Actividades eleccionActividad(Actividades actividad,int numAct){
        switch (numAct){
            case 1:{actividad=Actividades.FUTBOL;}break;
            case 2:{actividad=Actividades.BALONCESTO;}break;
            case 3:{actividad=Actividades.PADEL;}break;
            case 4:{actividad=Actividades.TENIS;}break;
            case 5:{actividad=Actividades.FRONTON;}break;
            case 6:{actividad=Actividades.YOGA;}break;
            case 7:{actividad=Actividades.SPINNING;}break;
        }
        return actividad;
    }
    public static void verCalendario(Scanner sc){

        Actividades actividad = Actividades.FUTBOL;

        System.out.println(colorize("\nActividad:", BLUE_TEXT()));
        int cont1=0;
        for (Actividades act : Actividades.values()){
            System.out.println(colorize("(" + cont1 + ")" + act.toString(), BLUE_TEXT()));
            cont1++;
        }
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        int numAct = sc.nextInt();
        actividad = eleccionActividad(actividad, numAct);

        System.out.println(colorize("\n¿Semana? (0-51)", BLUE_TEXT()));
        System.out.print(colorize("--> ",BRIGHT_BLUE_TEXT()));
        int numSemana = sc.nextInt();

        mostrarCalendario(numSemana,actividad);
    }

    public static void verReservas(Oficinista oficinista, Actividades actividad,int numUsuario, int numSemana, int numHora, int numDia){

        List<Reserva> reservas = (List<Reserva>) FileManager.loadFileList("reservas");

        int cont = 0;
        for (Reserva reserva : reservas){
            System.out.println(colorize("(" + cont + ")" + "semana:" +reserva.getNumSemana() + ", dia:" + reserva.getNumDia() + ", hora:" + reserva.getNumHora() + ", actividad:" + reserva.getActividad().toString(),BLUE_TEXT()));
            cont++;
        }

    }

}
