package Gestion_Esfot;

/**
 * Clase que representa los datos de un laboratorio.
 */

public class Registro_Laboratorios {
    // Variables de recepcion
    String codigo_lab;
    int numero_laboratorio;
    String nombre_laboratorio;
    int capacidad_laboratorio;
    int numero_computadores;

    /**
     * Constructor por defecto
     */

    public Registro_Laboratorios() {
    }

    /**
     * Constructor con parámetros para inicializar un laboratorio.
     *
     * @param codigo_lab Código del laboratorio
     * @param numero_laboratorio Número identificador del laboratorio
     * @param nombre_laboratorio Nombre del laboratorio
     * @param capacidad_laboratorio Capacidad del laboratorio
     * @param numero_computadores Número de computadoras en el laboratorio
     */

    public Registro_Laboratorios(String codigo_lab, int numero_laboratorio, String nombre_laboratorio, int capacidad_laboratorio, int numero_computadores) {
        this.codigo_lab = codigo_lab;
        this.numero_laboratorio = numero_laboratorio;
        this.nombre_laboratorio = nombre_laboratorio;
        this.capacidad_laboratorio = capacidad_laboratorio;
        this.numero_computadores = numero_computadores;
    }

    /**
     * Getter y setters
     * @return Setean y devuelven las variables respectivas
     */
    public String getCodigo_lab() {
        return codigo_lab;
    }

    public void setCodigo_lab(String codigo_lab) {
        this.codigo_lab = codigo_lab;
    }

    public int getNumero_laboratorio() {
        return numero_laboratorio;
    }

    public void setNumero_laboratorio(int numero_laboratorio) {
        this.numero_laboratorio = numero_laboratorio;
    }

    public String getNombre_laboratorio() {
        return nombre_laboratorio;
    }

    public void setNombre_laboratorio(String nombre_laboratorio) {
        this.nombre_laboratorio = nombre_laboratorio;
    }

    public int getCapacidad_laboratorio() {
        return capacidad_laboratorio;
    }

    public void setCapacidad_laboratorio(int capacidad_laboratorio) {
        this.capacidad_laboratorio = capacidad_laboratorio;
    }

    public int getNumero_computadores() {
        return numero_computadores;
    }

    public void setNumero_computadores(int numero_computadores) {
        this.numero_computadores = numero_computadores;
    }
}
