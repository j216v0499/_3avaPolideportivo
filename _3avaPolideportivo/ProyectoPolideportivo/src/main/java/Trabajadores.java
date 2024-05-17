import base.Writable;

public class Trabajadores extends Writable {

    private String nombre;
    private String pass;
    private String DNI;

    public Trabajadores(String nombre, String pass, String DNI) {
        this.nombre = nombre;
        this.pass = pass;
        this.DNI = DNI;
    }

    public Trabajadores() {

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
