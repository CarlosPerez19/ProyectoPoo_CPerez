package Gestion_Esfot;

/**
 * Clase que representa los datos de un usuario en el sistema.
 */

public class Registro_Usuarios {

    // Variables de recepcion
    String nombre;
    String apellido;
    int edad;
    String usuario;
    String contrasenia;
    String cedula;

    /**
     * Constructor por defecto.
     */

    public Registro_Usuarios() {
    }

    /**
     * Constructor con parámetros para inicializar un usuario.
     *
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     * @param edad Edad del usuario
     * @param usuario Nombre de usuario para el acceso
     * @param contrasenia Contraseña para el acceso
     * @param cedula Cédula del usuario
     */

    public Registro_Usuarios(String nombre, String apellido, int edad, String usuario, String contrasenia, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cedula = cedula;
    }

    /**
     * Getters y setters
     * @return Setearan y devolveran las variables respectivas
     */
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
