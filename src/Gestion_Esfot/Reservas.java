package Gestion_Esfot;

/**
 * Clase para reservas
 */

public class Reservas {

    // Variblaes que recibira la clase
    String codigo;
    int hora_inicio;
    int hora_fin;
    int dia;
    String cedula;

    /**
     * Constructor para inicializar
     */

    public Reservas() {
    }

    /**
     * Constructor con parámetros para inicializar una reserva.
     *
     * @param codigo Código del aula o laboratorio reservado
     * @param hora_inicio Hora de inicio de la reserva
     * @param hora_fin Hora de fin de la reserva
     * @param dia Día de la reserva
     * @param cedula Cédula del usuario que realiza la reserva
     */

    public Reservas(String codigo, int hora_inicio, int hora_fin, int dia, String cedula) {
        this.codigo = codigo;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.dia = dia;
        this.cedula = cedula;
    }

    /**
     * Getters y setter
     * @return Seterean y devolveran las variables asignadas
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(int hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
