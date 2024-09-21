package ar.edu.unju.escmi.tp4.dominio;

public abstract class Inmueble {
    protected String codigo;
    protected boolean disponibilidad;

    public Inmueble(String codigo, boolean disponibilidad) {
        this.codigo = codigo;
        this.disponibilidad = disponibilidad;
    }

    public abstract void mostrarDatos();

    public boolean estadisponible() {
        return disponibilidad;
    }

    public void setestadisponible(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
