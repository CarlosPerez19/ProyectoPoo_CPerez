package Gestion_Esfot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actualizar_Usuarios {
    private JTextField cedula;
    private JButton actualizar;
    public JPanel mainPanel;
    private JComboBox rol;
    private JComboBox actulizar_element;
    private JTextField actualizacion;
    private JButton volver;

    public Actualizar_Usuarios() {
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (cedula.getText().isEmpty() || rol.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Llenar todos los campos");
                    return;
                }

                if (cedula.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cedula valida");
                    return;
                }

                switch (rol.getSelectedIndex()) {

                    case 1:
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Administrador");
                            String cedula_actualizar = cedula.getText();

                            switch (actulizar_element.getSelectedIndex()) {
                                case 1:
                                    Document filtro = new Document("Cedula", cedula_actualizar);
                                    Document actualizar = new Document("$set", new Document("Nombre:", actualizacion.getText()));
                                    UpdateResult resultado = collection.updateOne(filtro, actualizar);
                                    System.out.println("Documentos modificados: " + resultado.getModifiedCount());

                                    break;

                                case 2:
                                    Document filtro2 = new Document("Cedula", cedula_actualizar);
                                    Document actualizar2 = new Document("$set", new Document("Apellido", actualizacion.getText()));
                                    UpdateResult resultado2 = collection.updateOne(filtro2, actualizar2);
                                    System.out.println("Documentos modificados: " + resultado2.getModifiedCount());

                                    break;

                                case 3:
                                    Document filtro3 = new Document("Cedula", cedula_actualizar);
                                    Document actualizar3 = new Document("$set", new Document("Edad", actualizacion.getText()));
                                    UpdateResult resultado3 = collection.updateOne(filtro3, actualizar3);
                                    System.out.println("Documentos modificados: " + resultado3.getModifiedCount());

                                    break;

                                case 4:
                                    Document filtro4 = new Document("Cedula", cedula_actualizar);
                                    Document actualizar4 = new Document("$set", new Document("Usuario", actualizacion.getText()));
                                    UpdateResult resultado4 = collection.updateOne(filtro4, actualizar4);
                                    System.out.println("Documentos modificados: " + resultado4.getModifiedCount());

                                    break;

                                case 5:
                                    Document filtro5 = new Document("Cedula", cedula_actualizar);
                                    Document actualizar5 = new Document("$set", new Document("Contrasenia", actualizacion.getText()));
                                    UpdateResult resultado5 = collection.updateOne(filtro5, actualizar5);
                                    System.out.println("Documentos modificados: " + resultado5.getModifiedCount());

                                    break;
                            }

                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario");
                        }

                        break;

                    case 2:
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Profesor");
                            String cedula_actualizar = cedula.getText();

                            switch (actulizar_element.getSelectedIndex()) {
                                case 1:
                                    Document filtro = new Document("Cedula", cedula_actualizar);
                                    Document actualizar = new Document("$set", new Document("Nombre:", actualizacion.getText()));
                                    UpdateResult resultado = collection.updateOne(filtro, actualizar);
                                    System.out.println("Documentos modificados: " + resultado.getModifiedCount());

                                    break;

                                case 2:
                                    Document filtro2 = new Document("Cedula", cedula_actualizar);
                                    Document actualizar2 = new Document("$set", new Document("Apellido", actualizacion.getText()));
                                    UpdateResult resultado2 = collection.updateOne(filtro2, actualizar2);
                                    System.out.println("Documentos modificados: " + resultado2.getModifiedCount());

                                    break;

                                case 3:
                                    Document filtro3 = new Document("Cedula", cedula_actualizar);
                                    Document actualizar3 = new Document("$set", new Document("Edad", actualizacion.getText()));
                                    UpdateResult resultado3 = collection.updateOne(filtro3, actualizar3);
                                    System.out.println("Documentos modificados: " + resultado3.getModifiedCount());

                                    break;

                                case 4:
                                    Document filtro4 = new Document("Cedula", cedula_actualizar);
                                    Document actualizar4 = new Document("$set", new Document("Usuario", actualizacion.getText()));
                                    UpdateResult resultado4 = collection.updateOne(filtro4, actualizar4);
                                    System.out.println("Documentos modificados: " + resultado4.getModifiedCount());

                                    break;

                                case 5:
                                    Document filtro5 = new Document("Cedula", cedula_actualizar);
                                    Document actualizar5 = new Document("$set", new Document("Contrasenia", actualizacion.getText()));
                                    UpdateResult resultado5 = collection.updateOne(filtro5, actualizar5);
                                    System.out.println("Documentos modificados: " + resultado5.getModifiedCount());

                                    break;
                            }

                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario");
                        }

                        break;

                    case 3:
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Estudiante");
                            String cedula_actualizar = cedula.getText();

                            switch (actulizar_element.getSelectedIndex()) {
                                case 1:
                                    Document filtro = new Document("Cedula", cedula_actualizar);
                                    Document actualizar = new Document("$set", new Document("Nombre:", actualizacion.getText()));
                                    UpdateResult resultado = collection.updateOne(filtro, actualizar);
                                    System.out.println("Documentos modificados: " + resultado.getModifiedCount());

                                    break;

                                case 2:
                                    Document filtro2 = new Document("Cedula", cedula_actualizar);
                                    Document actualizar2 = new Document("$set", new Document("Apellido", actualizacion.getText()));
                                    UpdateResult resultado2 = collection.updateOne(filtro2, actualizar2);
                                    System.out.println("Documentos modificados: " + resultado2.getModifiedCount());

                                    break;

                                case 3:
                                    Document filtro3 = new Document("Cedula", cedula_actualizar);
                                    Document actualizar3 = new Document("$set", new Document("Edad", actualizacion.getText()));
                                    UpdateResult resultado3 = collection.updateOne(filtro3, actualizar3);
                                    System.out.println("Documentos modificados: " + resultado3.getModifiedCount());

                                    break;

                                case 4:
                                    Document filtro4 = new Document("Cedula", cedula_actualizar);
                                    Document actualizar4 = new Document("$set", new Document("Usuario", actualizacion.getText()));
                                    UpdateResult resultado4 = collection.updateOne(filtro4, actualizar4);
                                    System.out.println("Documentos modificados: " + resultado4.getModifiedCount());

                                    break;

                                case 5:
                                    Document filtro5 = new Document("Cedula", cedula_actualizar);
                                    Document actualizar5 = new Document("$set", new Document("Contrasenia", actualizacion.getText()));
                                    UpdateResult resultado5 = collection.updateOne(filtro5, actualizar5);
                                    System.out.println("Documentos modificados: " + resultado5.getModifiedCount());

                                    break;
                            }

                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Error al actualizar el usuario");
                        }

                        break;
                }
                ((JFrame) SwingUtilities.getWindowAncestor(actualizar)).dispose();

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
