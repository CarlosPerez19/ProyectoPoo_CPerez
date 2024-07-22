package Gestion_Esfot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro_Laboratorios_Admin {
    private JTextField numero_lab;
    private JTextField nombre_lab;
    private JTextField capacidad_lab;
    private JTextField pc_lab;
    private JButton registrar;
    public JPanel mainPanel;


    public Registro_Laboratorios_Admin() {
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (numero_lab.getText().isEmpty() || nombre_lab.getText().isEmpty() || capacidad_lab.getText().isEmpty() || pc_lab.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                    return;
                }

                Registro_Laboratorios laboratorio = new Registro_Laboratorios();
                laboratorio.setNumero_laboratorio(Integer.parseInt(numero_lab.getText()));
                laboratorio.setNombre_laboratorio(nombre_lab.getText());
                laboratorio.setCapacidad_laboratorio(Integer.parseInt(capacidad_lab.getText()));
                laboratorio.setNumero_computadores(Integer.parseInt(numero_lab.getText()));

                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Laboratorios");
                    org.bson.Document documents = new Document("Numero Lab",laboratorio.getNumero_laboratorio())
                            .append("Nombre Lab", laboratorio.getNombre_laboratorio())
                            .append("Capacidad", laboratorio.getCapacidad_laboratorio())
                            .append("Computadores", laboratorio.getNumero_computadores());
                    collection.insertOne(documents);
                    System.out.println("Documento insertado con éxito");

                }
            }
        });
    }
}
