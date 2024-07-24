package Gestion_Esfot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reservas_Aulas {
    private JTextField codigo_aula;
    private JTextField dia;
    private JButton reservar;
    private JTextField hora_inicio;
    private JTextField hora_fin;
    private JTextField cedula;
    public JPanel mainPanel;

    public Reservas_Aulas() {
        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (codigo_aula.getText().isEmpty() || cedula.getText().isEmpty() || dia.getText().isEmpty() || hora_inicio.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Llene todos los campos");
                    return;
                }

                if (cedula.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cedula valida");
                    return;
                }

                Reservas reserva = new Reservas();
                reserva.setCodigo(codigo_aula.getText());
                reserva.setHora_inicio(Integer.parseInt(hora_inicio.getText()));
                reserva.setHora_fin(Integer.parseInt(hora_fin.getText()));
                reserva.setDia(Integer.parseInt(dia.getText()));
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
