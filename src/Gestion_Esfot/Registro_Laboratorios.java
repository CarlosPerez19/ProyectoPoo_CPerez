package Gestion_Esfot;

public class Registro_Laboratorios {

    String codigo_lab;
    int numero_laboratorio;
    String nombre_laboratorio;
    int capacidad_laboratorio;
    int numero_computadores;

    public Registro_Laboratorios() {
    }

    public Registro_Laboratorios(String codigo_lab, int numero_laboratorio, String nombre_laboratorio, int capacidad_laboratorio, int numero_computadores) {
        this.codigo_lab = codigo_lab;
        this.numero_laboratorio = numero_laboratorio;
        this.nombre_laboratorio = nombre_laboratorio;
        this.capacidad_laboratorio = capacidad_laboratorio;
        this.numero_computadores = numero_computadores;
    }

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
