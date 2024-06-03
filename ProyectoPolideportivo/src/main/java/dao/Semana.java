//package dao;
//
//import base.Writable;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * La clase Semana representa una semana en el sistema.
// * Se extiende de la clase Writable.
// */
//
//public class Semana extends Writable {
//    private List<Dia> dias;
//    private LocalDate inicio;
//    private LocalDate fin;
//
//    /**
//     * Constructor para la clase Semana.
//     *
//     * @param inicio La fecha de inicio de la semana.
//     * @param fin La fecha de fin de la semana.
//     */
//
//    public Semana(LocalDate inicio, LocalDate fin) {
//        this.dias = new ArrayList<>();
//        this.inicio = inicio;
//        this.fin = fin;
//    }
//
//    /**
//     * Constructor por defecto para la clase Semana.
//     */
//
//    public Semana(){
//        this.dias = new ArrayList<>();
//    }
//
//    /**
//     * Obtiene la lista de días.
//     *
//     * @return La lista de días.
//     */
//
//    public List<Dia> getDias() {
//        return dias;
//    }
//
//    /**
//     * Establece la lista de días.
//     *
//     * @param dias La lista de días.
//     */
//
//    public void setDias(List<Dia> dias) {
//        this.dias = dias;
//    }
//
//    /**
//     * Obtiene la fecha de inicio de la semana.
//     *
//     * @return La fecha de inicio de la semana.
//     */
//
//    public LocalDate getInicio() {
//        return inicio;
//    }
//
//    /**
//     * Establece la fecha de inicio de la semana.
//     *
//     * @param inicio La fecha de inicio de la semana.
//     */
//
//    public void setInicio(LocalDate inicio) {
//        this.inicio = inicio;
//    }
//
//    /**
//     * Obtiene la fecha de fin de la semana.
//     *
//     * @return La fecha de fin de la semana.
//     */
//
//    public LocalDate getFin() {
//        return fin;
//    }
//
//    /**
//     * Establece la fecha de fin de la semana.
//     *
//     * @param fin La fecha de fin de la semana.
//     */
//
//    public void setFin(LocalDate fin) {
//        this.fin = fin;
//    }
//}
