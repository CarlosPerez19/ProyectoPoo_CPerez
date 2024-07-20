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

    public Login() {
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Registro().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
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

                            MongoDatabase database = mongoClient.getDatabase("Proyectoo");
                            MongoCollection<Document> collection = database.getCollection("Administrador");
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

                        }

                        break;

                    case 2:
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("Proyectoo");
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

                        }

                        break;

                    case 3:

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("Proyectoo");
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

                        }

                        break;

                }
            }
        });
    }
}
