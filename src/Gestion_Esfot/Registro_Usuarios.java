package Gestion_Esfot;

public class Registro_Usuarios {
    String nombre;
    String apellido;
    int edad;
    String usuario;
    String contrasenia;
    String cedula;

    public Registro_Usuarios() {
    }

    public Registro_Usuarios(String nombre, String apellido, int edad, String usuario, String contrasenia, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
