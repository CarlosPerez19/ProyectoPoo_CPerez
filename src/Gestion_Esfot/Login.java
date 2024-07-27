package Gestion_Esfot;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public JPanel mainPanel;
    private JTextField usuario;
    private JPasswordField contrasenia;
    private JButton iniciarSesion;
    private JButton registrarseButton;
    private JComboBox rol;
    private JLabel image;

    public Login() {

        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

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
        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (usuario.getText().isEmpty() || contrasenia.getText().isEmpty() || rol.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                    return;
                }


                switch (rol.getSelectedIndex()) {
                    case 1:
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Administrador");
                            FindIterable<Document> documentos = collection.find();

                            boolean usuarioValido = false;

                            String usuarioIngresado = usuario.getText();
                            String contraseniaIngresada = new String(contrasenia.getPassword());

                            for (Document documento : documentos) {
                                String busquedaUsuario = documento.getString("Usuario");
                                String busquedaContrasenia = documento.getString("Contrasenia");

                                if (busquedaUsuario.equals(usuarioIngresado) && busquedaContrasenia.equals(contraseniaIngresada)) {
                                    usuarioValido = true;
                                    break;
                                }
                            }

                            if (usuarioValido) {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Correctos");
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Incorrectos");
                            }

                        }

                        JFrame frame = new JFrame();
                        frame.setContentPane(new Administrador().mainPanel);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setSize(900, 800);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);

                        break;

                    case 2:
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Profesor");
                            FindIterable<Document> documentos = collection.find();

                            boolean usuarioValido = false;

                            String usuarioIngresado = usuario.getText();
                            String contraseniaIngresada = contrasenia.getText();

                            for (Document documento : documentos) {
                                String busquedaUsuario = documento.getString("Usuario");
                                String busquedaContrasenia = documento.getString("Contrasenia");

                                if (busquedaUsuario.equals(usuarioIngresado) && busquedaContrasenia.equals(contraseniaIngresada)) {
                                    usuarioValido = true;
                                    break;
                                }
                            }

                            if (usuarioValido) {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Correctos");
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Incorrectos");
                            }

                            JFrame frame2 = new JFrame();
                            frame2.setContentPane(new Profesor().mainPanel);
                            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame2.pack();
                            frame2.setSize(900, 800);
                            frame2.setLocationRelativeTo(null);
                            frame2.setVisible(true);

                        }

                        break;

                    case 3:

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Estudiante");
                            FindIterable<Document> documentos = collection.find();

                            boolean usuarioValido = false;

                            String usuarioIngresado = usuario.getText();
                            String contraseniaIngresada = contrasenia.getText();

                            for (Document documento : documentos) {
                                String busquedaUsuario = documento.getString("Usuario");
                                String busquedaContrasenia = documento.getString("Contrasenia");

                                if (busquedaUsuario.equals(usuarioIngresado) && busquedaContrasenia.equals(contraseniaIngresada)) {
                                    usuarioValido = true;
                                    break;
                                }
                            }

                            if (usuarioValido) {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Correctos");
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario y Contraseña Incorrectos");
                            }

                            JFrame frame3 = new JFrame();
                            frame3.setContentPane(new Reservas_Aulas().mainPanel);
                            frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame3.pack();
                            frame3.setSize(900, 800);
                            frame3.setLocationRelativeTo(null);
                            frame3.setVisible(true);

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error al conectar");
                            ex.printStackTrace();
                        }

                        break;
                }
            }
        });
    }
}
