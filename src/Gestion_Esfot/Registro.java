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
 * Clase para el registro de nuevos usuarios por parte del administrador
 */
public class Registro extends Registro_Usuarios {
    private JTextField contrasenia;
    private JComboBox rol;
    private JTextField usuario;
    private JButton registro;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField edad;
    public JPanel mainPanel;
    private JTextField cedula;
    private JButton volver;
    private JLabel image;

    /**
     * Constructor para la clase de registro
     */

    public Registro() {

        // Imagen que aparecera dentro del frame

        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Boton para registrar un nuevo usuario

        registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // control de campos vacios

                if (nombre.getText().isEmpty() || usuario.getText().isEmpty() || contrasenia.getText().isEmpty() || rol.getSelectedIndex() == 0 || apellido.getText().isEmpty() || edad.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese todos los campos corrrectamente");
                    return;
                }

                // Ingreso de acuerdo a la eleccion del usuario

                switch (rol.getSelectedIndex()) {
                    case 1:

                        // Creacion y seteo del objeto con sus respectivas variables
                        Registro_Usuarios user = new Registro_Usuarios();
                        user.setCedula(cedula.getText());
                        user.setNombre(nombre.getText());
                        user.setApellido(apellido.getText());
                        user.setEdad(Integer.parseInt(edad.getText()));
                        user.setUsuario(usuario.getText());

                        // Sentencia para encriptar la contraseña del usuario
                        String contraseniaEncriptada = Encriptar.generateHash(contrasenia.getText());
                        user.setContrasenia(contraseniaEncriptada);

                        // Conexion con la base de datos y su respectiva colleccion

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<org.bson.Document> collection = database.getCollection("Administrador");

                            // Creacion del documento a insertar en la coleccion
                            org.bson.Document documents = new Document("Nombre:", user.getNombre())
                                    .append("Apellido", user.getApellido())
                                    .append("Edad", user.getEdad())
                                    .append("Usuario", user.getUsuario())
                                    .append("Contrasenia", user.getContrasenia())
                                    .append("Cedula", user.getCedula());
                            collection.insertOne(documents);
                            System.out.println("Documento insertado con éxito");


                        } catch (MongoWriteException ex) {
                            // Validacion en caso de existan usuarios ya registrados
                            if (ex.getError().getCategory().equals(com.mongodb.ErrorCategory.DUPLICATE_KEY)) {
                                JOptionPane.showMessageDialog(null, "Usuario o cédula ya registrados");
                            } else {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error al insertar documento");
                            }
                        }
                        break;

                    case 2:
                        // Creacion y seteo del objeto con sus respectivas variables
                        Registro_Usuarios user2 = new Registro_Usuarios();
                        user2.setCedula(cedula.getText());
                        user2.setNombre(nombre.getText());
                        user2.setApellido(apellido.getText());
                        user2.setEdad(Integer.parseInt(edad.getText()));
                        user2.setUsuario(usuario.getText());

                        // Setencia para encriptar la contraseña del usuario
                        String contraseniaEncriptada2 = Encriptar.generateHash(contrasenia.getText());
                        user2.setContrasenia(contraseniaEncriptada2);

                        // Conexion con la base de datos e ingreso a la coleccion de profesores

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<org.bson.Document> collection = database.getCollection("Profesor");

                            // Creacion del documento a insertar en la coleccion
                            org.bson.Document documents = new Document("Nombre:", user2.getNombre())
                                    .append("Apellido", user2.getApellido())
                                    .append("Edad", user2.getEdad())
                                    .append("Usuario", user2.getUsuario())
                                    .append("Contrasenia", user2.getContrasenia())
                                    .append("Cedula", user2.getCedula());
                            collection.insertOne(documents);
                            System.out.println("Documento insertado con éxito");

                        }catch (MongoWriteException ex) {
                            // Validacion en caso de un usuario ya registrado
                            if (ex.getError().getCategory().equals(com.mongodb.ErrorCategory.DUPLICATE_KEY)) {
                                JOptionPane.showMessageDialog(null, "Usuario o cédula ya registrados");
                            } else {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error al insertar documento");
                            }
                        }
                        break;

                    case 3:

                        // Creacion y seteo del objeto con sus respectivas variables
                        Registro_Usuarios user3 = new Registro_Usuarios();
                        user3.setCedula(cedula.getText());
                        user3.setNombre(nombre.getText());
                        user3.setApellido(apellido.getText());
                        user3.setEdad(Integer.parseInt(edad.getText()));
                        user3.setUsuario(usuario.getText());

                        // Setencia para encriptar la contraseña del usuario
                        String contraseniaEncriptada3 = Encriptar.generateHash(contrasenia.getText());
                        user3.setContrasenia(contraseniaEncriptada3);

                        // Conexion con la base de datos y conexion con la coleccion de estudiantes
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<org.bson.Document> collection = database.getCollection("Estudiante");

                            // Creacion del documento a insertar en la coleccion
                            org.bson.Document documents = new Document("Nombre:", user3.getNombre())
                                    .append("Apellido", user3.getApellido())
                                    .append("Edad", user3.getEdad())
                                    .append("Usuario", user3.getUsuario())
                                    .append("Contrasenia", user3.getContrasenia())
                                    .append("Cedula", user3.getCedula());
                            collection.insertOne(documents);
                            System.out.println("Documento insertado con éxito");

                        } catch (MongoWriteException ex) {

                            // Validacion en caso de usuario ya existente
                            if (ex.getError().getCategory().equals(com.mongodb.ErrorCategory.DUPLICATE_KEY)) {
                                JOptionPane.showMessageDialog(null, "Usuario o cédula ya registrados");
                            } else {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error al insertar documento");
                            }
                        }
                        break;
                }

                // Cierre de la ventana
                ((JFrame) SwingUtilities.getWindowAncestor(registro)).dispose();
            }

        });

        // Boton para volver al frame anterior
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Usuarios().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Cierre del frame
                ((JFrame) SwingUtilities.getWindowAncestor(volver)).dispose();
            }
        });
    }
}
