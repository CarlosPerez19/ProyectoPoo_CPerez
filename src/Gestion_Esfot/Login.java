package Gestion_Esfot;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase Login maneja la interfaz gráfica y la lógica de autenticación para el inicio de sesión de usuarios.
 */

public class Login {
    public JPanel mainPanel;
    private JTextField usuario;
    private JPasswordField contrasenia;
    private JButton iniciarSesion;
    private JButton registrarseButton;
    private JComboBox rol;
    private JLabel image;

    /**
     * Constructor de la clase Login.
     * Configura la interfaz gráfica y define los eventos para los botones.
     */

    public Login() {

        // Imagen que se presentara dentro del frame
        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Llama del frame para registrarse por medio del boton
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Registrar_UsuariosForm().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        // Conexion con la base de datos y validacciones
        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Se encarga de validar los campos en blanco

                if (usuario.getText().isEmpty() || contrasenia.getText().isEmpty() || rol.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                    return;
                }

                // Conexion con la base de datos y su respectiva colleccion basado en la eleccion del usuario
                // LLamada del frame respectivo con base a la seleccion del usuario

                switch (rol.getSelectedIndex()) {
                    case 1:
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Administrador");
                            FindIterable<Document> documentos = collection.find();

                            boolean usuarioValido = false;

                            // Variables de ingreso por parte del usuario
                            String usuarioIngresado = usuario.getText();
                            String contraseniaIngresada = Encriptar.generateHash(contrasenia.getText());

                            for (Document documento : documentos) {
                                String busquedaUsuario = documento.getString("Usuario");
                                String busquedaContrasenia = documento.getString("Contrasenia");

                                // Comparacion para validar el acceso
                                if (busquedaUsuario.equals(usuarioIngresado) && busquedaContrasenia.equals(contraseniaIngresada)) {
                                    usuarioValido = true;
                                    break;
                                }
                            }

                            if (usuarioValido) {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Correctos");

                                JFrame frame = new JFrame();
                                frame.setContentPane(new Administrador().mainPanel);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.pack();
                                frame.setSize(900, 800);
                                frame.setLocationRelativeTo(null);
                                frame.setVisible(true);

                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Incorrectos");
                            }

                        }
                        ((JFrame) SwingUtilities.getWindowAncestor(iniciarSesion)).dispose();
                        break;

                    case 2:
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Profesor");
                            FindIterable<Document> documentos = collection.find();

                            boolean usuarioValido = false;

                            // Variables de ingreso
                            String usuarioIngresado = usuario.getText();
                            String contraseniaIngresada = Encriptar.generateHash(contrasenia.getText());

                            for (Document documento : documentos) {

                                // Busqueda de los registros
                                String busquedaUsuario = documento.getString("Usuario");
                                String busquedaContrasenia = documento.getString("Contrasenia");

                                // Comparacion de las variables
                                if (busquedaUsuario.equals(usuarioIngresado) && busquedaContrasenia.equals(contraseniaIngresada)) {
                                    usuarioValido = true;
                                    break;
                                }
                            }

                            if (usuarioValido) {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Correctos");

                                JFrame frame2 = new JFrame();
                                frame2.setContentPane(new Profesor().mainPanel);
                                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame2.pack();
                                frame2.setSize(900, 800);
                                frame2.setLocationRelativeTo(null);
                                frame2.setVisible(true);

                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Incorrectos");
                            }

                        }
                        ((JFrame) SwingUtilities.getWindowAncestor(iniciarSesion)).dispose();
                        break;

                    case 3:

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Estudiante");
                            FindIterable<Document> documentos = collection.find();

                            boolean usuarioValido = false;

                            // Variables de ingreso
                            String usuarioIngresado = usuario.getText();
                            String contraseniaIngresada = Encriptar.generateHash(contrasenia.getText());

                            for (Document documento : documentos) {

                                // Variables de busqueda
                                String busquedaUsuario = documento.getString("Usuario");
                                String busquedaContrasenia = documento.getString("Contrasenia");

                                // Comparacion de las variables
                                if (busquedaUsuario.equals(usuarioIngresado) && busquedaContrasenia.equals(contraseniaIngresada)) {
                                    usuarioValido = true;
                                    break;
                                }
                            }

                            if (usuarioValido) {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Correctos");

                                JFrame frame3 = new JFrame();
                                frame3.setContentPane(new Reservas_Aulas().mainPanel);
                                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame3.pack();
                                frame3.setSize(900, 800);
                                frame3.setLocationRelativeTo(null);
                                frame3.setVisible(true);

                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Incorrectos");
                            }


                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error al conectar");
                            ex.printStackTrace();
                        }
                        ((JFrame) SwingUtilities.getWindowAncestor(iniciarSesion)).dispose();
                        break;
                }
            }
        });
    }
}
