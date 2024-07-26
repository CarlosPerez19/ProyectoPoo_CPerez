package Gestion_Esfot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public Registro() {
        registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (nombre.getText().isEmpty() || usuario.getText().isEmpty() || contrasenia.getText().isEmpty() || rol.getSelectedIndex() == 0 || apellido.getText().isEmpty() || edad.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese todos los campos corrrectamente");
                    return;
                }

                switch (rol.getSelectedIndex()) {
                    case 1:
                        Registro_Usuarios user = new Registro_Usuarios();
                        user.setCedula(cedula.getText());
                        user.setNombre(nombre.getText());
                        user.setApellido(apellido.getText());
                        user.setEdad(Integer.parseInt(edad.getText()));
                        user.setUsuario(usuario.getText());
                        user.setContrasenia(contrasenia.getText());

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<org.bson.Document> collection = database.getCollection("Administrador");
                            org.bson.Document documents = new Document("Nombre:", user.getNombre())
                                    .append("Apellido", user.getApellido())
                                    .append("Edad", user.getEdad())
                                    .append("Usuario", user.getUsuario())
                                    .append("Contrasenia", user.getContrasenia())
                                    .append("Cedula", user.getCedula());
                            collection.insertOne(documents);
                            System.out.println("Documento insertado con éxito");

                        }
                        break;

                    case 2:
                        Registro_Usuarios user2 = new Registro_Usuarios();
                        user2.setCedula(cedula.getText());
                        user2.setNombre(nombre.getText());
                        user2.setApellido(apellido.getText());
                        user2.setEdad(Integer.parseInt(edad.getText()));
                        user2.setUsuario(usuario.getText());
                        user2.setContrasenia(contrasenia.getText());

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<org.bson.Document> collection = database.getCollection("Profesor");
                            org.bson.Document documents = new Document("Nombre:", user2.getNombre())
                                    .append("Apellido", user2.getApellido())
                                    .append("Edad", user2.getEdad())
                                    .append("Usuario", user2.getUsuario())
                                    .append("Contrasenia", user2.getContrasenia())
                                    .append("Cedula", user2.getCedula());
                            collection.insertOne(documents);
                            System.out.println("Documento insertado con éxito");

                        }
                        break;

                    case 3:
                        Registro_Usuarios user3 = new Registro_Usuarios();
                        user3.setCedula(cedula.getText());
                        user3.setNombre(nombre.getText());
                        user3.setApellido(apellido.getText());
                        user3.setEdad(Integer.parseInt(edad.getText()));
                        user3.setUsuario(usuario.getText());
                        user3.setContrasenia(contrasenia.getText());

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<org.bson.Document> collection = database.getCollection("Estudiante");
                            org.bson.Document documents = new Document("Nombre:", user3.getNombre())
                                    .append("Apellido", user3.getApellido())
                                    .append("Edad", user3.getEdad())
                                    .append("Usuario", user3.getUsuario())
                                    .append("Contrasenia", user3.getContrasenia())
                                    .append("Cedula", user3.getCedula());
                            collection.insertOne(documents);
                            System.out.println("Documento insertado con éxito");

                        }
                        break;
                }

                ((JFrame) SwingUtilities.getWindowAncestor(registro)).dispose();
            }

        });
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Usuarios().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(volver)).dispose();
            }
        });
    }
}
