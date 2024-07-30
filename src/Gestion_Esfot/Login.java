package Gestion_Esfot;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para el inicio de sesion de acuerdo a la seleccion del usuario
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
     * Constructor para la clase login
     */
    public Login() {

        // Imagen que aparecera en el frame
        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Boton para registrar un usuario nuevo
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

        // Boton para iniciar sesion de acuerdo a la seleccion del usuario
        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Control de campos vacios
                if (usuario.getText().isEmpty() || contrasenia.getText().isEmpty() || rol.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                    return;
                }

                // Conexion de acuerdo al rol seleccionado por el usuario
                switch (rol.getSelectedIndex()) {
                    case 1:

                        // Conexion con la base de datos e ingreso a la coleccion de administrador
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Administrador");
                            FindIterable<Document> documentos = collection.find();

                            boolean usuarioValido = false;

                            // Varibables de busqueda
                            String usuarioIngresado = usuario.getText();

                            //Encriptacion de contraseña
                            String contraseniaIngresada = Encriptar.generateHash(contrasenia.getText());

                            // Busqueda de variables
                            for (Document documento : documentos) {
                                String busquedaUsuario = documento.getString("Usuario");
                                String busquedaContrasenia = documento.getString("Contrasenia");

                                // Comparacion de variables
                                if (busquedaUsuario.equals(usuarioIngresado) && busquedaContrasenia.equals(contraseniaIngresada)) {
                                    usuarioValido = true;
                                    break;
                                }
                            }

                            // Apertura del frame
                            if (usuarioValido) {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Correctos");
                                JFrame frame = new JFrame();
                                frame.setContentPane(new Administrador().mainPanel);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.pack();
                                frame.setSize(900, 800);
                                frame.setLocationRelativeTo(null);
                                frame.setVisible(true);

                                // Cierre del frame
                                ((JFrame) SwingUtilities.getWindowAncestor(iniciarSesion)).dispose();

                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Incorrectos");
                            }

                        }

                        break;

                    case 2:

                        // Conexion con la base de datos e ingreso a la coleccion de profesor
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Profesor");
                            FindIterable<Document> documentos = collection.find();

                            boolean usuarioValido = false;

                            // Recepcion de variables
                            String usuarioIngresado = usuario.getText();

                            //Encriptacion de contraseña
                            String contraseniaIngresada = Encriptar.generateHash(contrasenia.getText());

                            // Busqeuda de variables en el documento
                            for (Document documento : documentos) {
                                String busquedaUsuario = documento.getString("Usuario");
                                String busquedaContrasenia = documento.getString("Contrasenia");

                                // Comparacion de las variables
                                if (busquedaUsuario.equals(usuarioIngresado) && busquedaContrasenia.equals(contraseniaIngresada)) {
                                    usuarioValido = true;
                                    break;
                                }
                            }

                            // Apertura del frame correspondiente
                            if (usuarioValido) {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Correctos");
                                JFrame frame2 = new JFrame();
                                frame2.setContentPane(new Profesor().mainPanel);
                                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame2.pack();
                                frame2.setSize(900, 800);
                                frame2.setLocationRelativeTo(null);
                                frame2.setVisible(true);

                                // Cierre del frame
                                ((JFrame) SwingUtilities.getWindowAncestor(iniciarSesion)).dispose();

                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Incorrectos");
                            }

                        }

                        break;

                    case 3:

                        // Conexion con la base de datos e ingreso a la coleccion de estudiantes.
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Estudiante");
                            FindIterable<Document> documentos = collection.find();

                            boolean usuarioValido = false;

                            // Recepccion de variables
                            String usuarioIngresado = usuario.getText();

                            // Encriptacion de contraseña
                            String contraseniaIngresada = Encriptar.generateHash(contrasenia.getText());

                            // Busqueda de variables en el documento
                            for (Document documento : documentos) {
                                String busquedaUsuario = documento.getString("Usuario");
                                String busquedaContrasenia = documento.getString("Contrasenia");

                                // Comparacion de variables
                                if (busquedaUsuario.equals(usuarioIngresado) && busquedaContrasenia.equals(contraseniaIngresada)) {
                                    usuarioValido = true;
                                    break;
                                }
                            }

                            // Apertura del frame correspondiente
                            if (usuarioValido) {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Correctos");
                                JFrame frame3 = new JFrame();
                                frame3.setContentPane(new Reservas_Aulas().mainPanel);
                                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame3.pack();
                                frame3.setSize(900, 800);
                                frame3.setLocationRelativeTo(null);
                                frame3.setVisible(true);

                                // Cierre del frame
                                ((JFrame) SwingUtilities.getWindowAncestor(iniciarSesion)).dispose();

                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Incorrectos");
                            }

                        }

                        break;
                }
            }
        });
    }
}
