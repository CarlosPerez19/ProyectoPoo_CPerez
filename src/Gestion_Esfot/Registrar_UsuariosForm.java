package Gestion_Esfot;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para el registro de usuarios excluyendo al ddministrador
 */
public class Registrar_UsuariosForm {
    private JButton registrar;
    private JTextField cedula;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField edad;
    private JTextField user;
    private JTextField contrasenia;
    private JComboBox rol;
    public JPanel mainPanel;
    private JButton volver;
    private JLabel image;
    private JFrame frame;

    /**
     * Contrustor para la clase de registro de usuarios
     */
    public Registrar_UsuariosForm() {

        // Imagen que se mostrara en el frame
        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Boton para registrar un nuevo usuario
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Control de los campos vacios

                if (cedula.getText().isEmpty() || nombre.getText().isEmpty() || apellido.getText().isEmpty() || edad.getText().isEmpty() || user.getText().isEmpty() || contrasenia.getText().isEmpty() || rol.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Llenar los campos");
                    return;
                }

                // Control para la cedula

                if (cedula.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cedula valida");
                    return;
                }

                // Ingreso de acuerdo a la seleccion del usuario

                switch (rol.getSelectedIndex()) {

                    case 1:
                        //Creacion y seteo del objeto con sus respectivas variables
                        Registro_Usuarios usuario = new Registro_Usuarios();
                        usuario.setCedula(cedula.getText());
                        usuario.setNombre(nombre.getText());
                        usuario.setApellido(apellido.getText());
                        usuario.setEdad(Integer.parseInt(edad.getText()));
                        usuario.setUsuario(user.getText());

                        // Sentencia para encriptar la contraseña del usuario
                        String ContraseniaEncriptada = Encriptar.generateHash(contrasenia.getText());
                        usuario.setContrasenia(ContraseniaEncriptada);

                        // Conexion con la base de datos e ingreso a la coleccion de profesores
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")){
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Profesor");

                            // Creacion del documento a insertar en la coleccion
                            org.bson.Document documents = new Document("Nombre", usuario.getNombre())
                                    .append("Apellido", usuario.getApellido())
                                    .append("Edad", usuario.getEdad())
                                    .append("Usuario", usuario.getUsuario())
                                    .append("Contrasenia", usuario.getContrasenia())
                                    .append("Cedula", usuario.getCedula());
                            collection.insertOne(documents);
                            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                        } catch (MongoWriteException ex) {

                            // Validacion en caso de usuarios ya existentes
                            if (ex.getError().getCategory().equals(com.mongodb.ErrorCategory.DUPLICATE_KEY)) {
                                JOptionPane.showMessageDialog(null, "Usuario o cédula ya registrados");
                            } else {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error al insertar documento");
                            }
                        }
                        break;

                    case 2:

                        // Creacion del objeto y seteo con sus respectivas variables
                        Registro_Usuarios usuario2 = new Registro_Usuarios();
                        usuario2.setCedula(cedula.getText());
                        usuario2.setNombre(nombre.getText());
                        usuario2.setApellido(apellido.getText());
                        usuario2.setEdad(Integer.parseInt(edad.getText()));
                        usuario2.setUsuario(user.getText());

                        // Setencia para encriptar la contraseña del usuario
                        String ContraseniaEncriptada2 = Encriptar.generateHash(contrasenia.getText());
                        usuario2.setContrasenia(ContraseniaEncriptada2);

                        // Conexion con la base de datos e ingreso a la coleccion de estudiantes
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")){
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Estudiante");

                            // Creacion del documento a insertar en la coleccion
                            org.bson.Document documents = new Document("Nombre", usuario2.getNombre())
                                    .append("Apellido", usuario2.getApellido())
                                    .append("Edad", usuario2.getEdad())
                                    .append("Usuario", usuario2.getUsuario())
                                    .append("Contrasenia", usuario2.getContrasenia())
                                    .append("Cedula", usuario2.getCedula());
                            collection.insertOne(documents);
                            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                        } catch (MongoWriteException ex) {

                            // Control en caso de usuarios ya registrados
                            if (ex.getError().getCategory().equals(com.mongodb.ErrorCategory.DUPLICATE_KEY)) {
                                JOptionPane.showMessageDialog(null, "Usuario o cédula ya registrados");
                            } else {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error al insertar documento");
                            }
                        }
                        break;
                }

                // Cierre del frame
                ((JFrame) SwingUtilities.getWindowAncestor(registrar)).dispose();
            }
        });
        // Boton para volver al frame anterior
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra el frame actual
                ((JFrame) SwingUtilities.getWindowAncestor(volver)).dispose();
            }
        });
    }
}
