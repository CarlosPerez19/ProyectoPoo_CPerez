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

public class Actualizar_Aulas {
    private JTextField codigo_aula;
    private JComboBox actualizar_element;
    private JTextField actualizacion;
    private JButton actualizar;
    public JPanel mainPanel;

    public Actualizar_Aulas() {
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Aulas");
                    String aula_actualizar = codigo_aula.getText();

                    switch (actualizar_element.getSelectedIndex()) {
                        case 1:
                            Document filtro = new Document("Codigo Aula", aula_actualizar);
                            Document actualizar = new Document("$set", new Document("Numero Aula", actualizacion.getText()));
                            UpdateResult resultado = collection.updateOne(filtro, actualizar);
                            System.out.println("Documentos modificados: " + resultado.getModifiedCount());

                            break;

                        case 2:
                            Document filtro2 = new Document("Codigo Aula", aula_actualizar);
                            Document actualizar2 = new Document("$set", new Document("Capacidad", actualizacion.getText()));
                            UpdateResult resultado2 = collection.updateOne(filtro2, actualizar2);
                            System.out.println("Documentos modificados: " + resultado2.getModifiedCount());

                            break;

                        case 3:
                            Document filtro3 = new Document("Codigo Aula", aula_actualizar);
                            Document actualizar3 = new Document("$set", new Document("Bancas", actualizacion.getText()));
                            UpdateResult resultado3 = collection.updateOne(filtro3, actualizar3);
                            System.out.println("Documentos modificados: " + resultado3.getModifiedCount());

                            break;


                    }

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al actualizar el laboratorio");
                }
            }
        });
    }
}
