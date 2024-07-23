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

public class Actualizar_Laboratorios {
    private JTextField codigo_lab;
    private JComboBox actualizar_element;
    private JButton actualizar;
    private JTextField actualizacion;
    public JPanel mainPanel;

    public Actualizar_Laboratorios() {
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Laboratorios");
                    String lab_actualizar = codigo_lab.getText();

                    switch (actualizar_element.getSelectedIndex()) {
                        case 1:
                            Document filtro = new Document("Codigo Lab", lab_actualizar);
                            Document actualizar = new Document("$set", new Document("Numero Lab", actualizacion.getText()));
                            UpdateResult resultado = collection.updateOne(filtro, actualizar);
                            System.out.println("Documentos modificados: " + resultado.getModifiedCount());

                            break;

                        case 2:
                            Document filtro2 = new Document("Codigo Lab", lab_actualizar);
                            Document actualizar2 = new Document("$set", new Document("Nombre Lab", actualizacion.getText()));
                            UpdateResult resultado2 = collection.updateOne(filtro2, actualizar2);
                            System.out.println("Documentos modificados: " + resultado2.getModifiedCount());

                            break;

                        case 3:
                            Document filtro3 = new Document("Codigo Lab", lab_actualizar);
                            Document actualizar3 = new Document("$set", new Document("Capacidad", actualizacion.getText()));
                            UpdateResult resultado3 = collection.updateOne(filtro3, actualizar3);
                            System.out.println("Documentos modificados: " + resultado3.getModifiedCount());

                            break;

                        case 4:
                            Document filtro4 = new Document("Codigo Lab", lab_actualizar);
                            Document actualizar4 = new Document("$set", new Document("Computadores", actualizacion.getText()));
                            UpdateResult resultado4 = collection.updateOne(filtro4, actualizar4);
                            System.out.println("Documentos modificados: " + resultado4.getModifiedCount());

                            break;

                    }

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al actualizar el laboratorio");
                }
            }
        });
    }
}
