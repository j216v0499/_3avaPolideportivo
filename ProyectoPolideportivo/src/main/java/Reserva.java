public class Reserva {

    private Actividades actividad;
    private int numSemana;
    private int numDia;
    private int numHora;
    private int numCliente;


    public Reserva(Actividades actividad, int numSemana, int numDia, int numHora, int numCliente) {
        this.actividad = actividad;
        this.numSemana = numSemana;
        this.numDia = numDia;
        this.numHora = numHora;
        this.numCliente = numCliente;
    }

    public Reserva(){

    }

    public Actividades getActividad() {
        return actividad;
    }

    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
    }

    public int getNumSemana() {
        return numSemana;
    }

    public void setNumSemana(int numSemana) {
        this.numSemana = numSemana;
    }

    public int getNumDia() {
        return numDia;
    }

    public void setNumDia(int numDia) {
        this.numDia = numDia;
    }

    public int getNumHora() {
        return numHora;
    }

    public void setNumHora(int numHora) {
        this.numHora = numHora;
    }

    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }
}
