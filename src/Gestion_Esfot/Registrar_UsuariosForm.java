package Gestion_Esfot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public Registrar_UsuariosForm() {

        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (cedula.getText().isEmpty() || nombre.getText().isEmpty() || apellido.getText().isEmpty() || edad.getText().isEmpty() || user.getText().isEmpty() || contrasenia.getText().isEmpty() || rol.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Llenar los campos");
                    return;
                }

                if (cedula.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cedula valida");
                    return;
                }

                switch (rol.getSelectedIndex()) {

                    case 1:
                        Registro_Usuarios usuario = new Registro_Usuarios();
                        usuario.setCedula(cedula.getText());
                        usuario.setNombre(nombre.getText());
                        usuario.setApellido(apellido.getText());
                        usuario.setEdad(Integer.parseInt(edad.getText()));
                        usuario.setUsuario(user.getText());
                        usuario.setContrasenia(contrasenia.getText());

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")){
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Profesor");
                            org.bson.Document documents = new Document("Nombre", usuario.getNombre())
                                    .append("Apellido", usuario.getApellido())
                                    .append("Edad", usuario.getEdad())
                                    .append("Usuario", usuario.getUsuario())
                                    .append("Contrasenia", usuario.getContrasenia())
                                    .append("Cedula", usuario.getCedula());
                            collection.insertOne(documents);
                            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error al registrar el usuario");
                            ex.printStackTrace();
                        }
                        break;

                    case 2:
                        Registro_Usuarios usuario2 = new Registro_Usuarios();
                        usuario2.setCedula(cedula.getText());
                        usuario2.setNombre(nombre.getText());
                        usuario2.setApellido(apellido.getText());
                        usuario2.setEdad(Integer.parseInt(edad.getText()));
                        usuario2.setUsuario(user.getText());
                        usuario2.setContrasenia(contrasenia.getText());

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")){
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Estudiante");
                            org.bson.Document documents = new Document("Nombre", usuario2.getNombre())
                                    .append("Apellido", usuario2.getApellido())
                                    .append("Edad", usuario2.getEdad())
                                    .append("Usuario", usuario2.getUsuario())
                                    .append("Contrasenia", usuario2.getContrasenia())
                                    .append("Cedula", usuario2.getCedula());
                            collection.insertOne(documents);
                            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error al registrar el usuario");
                            ex.printStackTrace();
                        }
                        break;
                }

                ((JFrame) SwingUtilities.getWindowAncestor(registrar)).dispose();
            }
        });
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ((JFrame) SwingUtilities.getWindowAncestor(volver)).dispose();

            }
        });
    }
}
