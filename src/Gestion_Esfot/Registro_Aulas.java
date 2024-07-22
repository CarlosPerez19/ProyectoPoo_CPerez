package Gestion_Esfot;

public class Registro_Aulas {

    String codigo_aula;
    int num_aula;
    int capacidad;
    int numero_bancas;

    public Registro_Aulas() {
    }

    public Registro_Aulas(String codigo_aula, int num_aula, int capacidad, int numero_bancas) {
        this.codigo_aula = codigo_aula;
        this.num_aula = num_aula;
        this.capacidad = capacidad;
        this.numero_bancas = numero_bancas;
    }

    public String getCodigo_aula() {
        return codigo_aula;
    }

    public void setCodigo_aula(String codigo_aula) {
        this.codigo_aula = codigo_aula;
    }

    public int getNum_aula() {
        return num_aula;
    }

    public void setNum_aula(int num_aula) {
        this.num_aula = num_aula;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNumero_bancas() {
        return numero_bancas;
    }

    public void setNumero_bancas(int numero_bancas) {
        this.numero_bancas = numero_bancas;
    }
}
