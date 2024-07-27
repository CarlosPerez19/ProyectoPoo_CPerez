package Gestion_Esfot;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eliminar_Usuarios {
    private JTextField cedula;
    private JButton eliminar;
    private JComboBox rol;
    public JPanel mainPanel;
    private JButton volver;
    private JLabel image;

    public Eliminar_Usuarios() {

        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (cedula.getText().isEmpty() || rol.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Llenar todos los campos");
                    return;
                }

                if (cedula.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Ingrese una Cedula valida");
                    return;
                }

                switch (rol.getSelectedIndex()) {
                    case 1:

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Administrador");
                            String cedula_eliminar = cedula.getText();
                            Document filtro = new Document("Cedula", cedula_eliminar );
                            DeleteResult resultado = collection.deleteOne(filtro);
                            JOptionPane.showMessageDialog(null, "Usuario Eliminado con Exito");
                            System.out.println("Documentos borrados: " + resultado.getDeletedCount());

                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
                        }

                        break;

                    case 2:

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Profesor");
                            String cedula_eliminar = cedula.getText();
                            Document filtro = new Document("Cedula", cedula_eliminar );
                            DeleteResult resultado = collection.deleteOne(filtro);
                            JOptionPane.showMessageDialog(null, "Usuario Eliminado con Exito");
                            System.out.println("Documentos borrados: " + resultado.getDeletedCount());

                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
                        }

                        break;

                    case 3:
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Estudiante");
                            String cedula_eliminar = cedula.getText();
                            Document filtro = new Document("Cedula", cedula_eliminar );
                            DeleteResult resultado = collection.deleteOne(filtro);
                            JOptionPane.showMessageDialog(null, "Usuario Eliminado con Exito");
                            System.out.println("Documentos borrados: " + resultado.getDeletedCount());

                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
                        }

                        break;
                }

                ((JFrame) SwingUtilities.getWindowAncestor(eliminar)).dispose();
            }
        });
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

                ((JFrame) SwingUtilities.getWindowAncestor(volver)).dispose();
            }
        });
    }
}
