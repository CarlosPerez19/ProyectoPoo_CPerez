package Gestion_Esfot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reserva_Laboratorios {
    private JTextField codigo_lab;
    private JTextField hora_inicio;
    private JTextField hora_fin;
    private JTextField cedula;
    private JButton reservar;
    public JPanel mainPanel;
    private JTextField num_dia;

    public Reserva_Laboratorios() {
        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (codigo_lab.getText().isEmpty() || hora_inicio.getText().isEmpty() || hora_fin.getText().isEmpty() || cedula.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Llenar todos los campos");
                    return;
                }

                if (cedula.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Cedula no valida");
                    return;
                }

                Reservas reserva = new Reservas();
                reserva.setCodigo(codigo_lab.getText());
                reserva.setHora_inicio(Integer.parseInt(hora_inicio.getText()));
                reserva.setHora_fin(Integer.parseInt(hora_fin.getText()));
                reserva.setDia(Integer.parseInt(num_dia.getText()));
                reserva.setCedula(cedula.getText());

                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Reservas");
                    org.bson.Document documents = new Document("Cedula", reserva.getCedula())
                            .append("Codigo", reserva.getCodigo())
                            .append("Dia", reserva.getDia())
                            .append("Inicio", reserva.getHora_inicio())
                            .append("Fin", reserva.getHora_fin());
                    collection.insertOne(documents);
                    JOptionPane.showMessageDialog(null, "Registro agregado correctamente");
                    System.out.println("Documento insertado con éxito");

                }
            }
        });
    }
}
