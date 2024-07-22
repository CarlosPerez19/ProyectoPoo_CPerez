package Gestion_Esfot;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buscar_Aula {
    private JTextField codigo_aula;
    private JButton buscar;
    public JPanel mainPanel;

    public Buscar_Aula() {
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (codigo_aula.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese un codigo de Aula");
                    return;
                }

                boolean found = false;

                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Aulas");
                    FindIterable<Document> documentos = collection.find();

                    String aula_buscar = codigo_aula.getText();

                    for (Document documento : documentos) {
                        if (aula_buscar.equals(documento.getString("Codigo Aula"))) {
                            found = true;
                            JOptionPane.showMessageDialog(null, "Aula existente");
                            JOptionPane.showMessageDialog(null, "Numero Aula: " + documento.getInteger("Numero Aula")
                                    + "\n" + "Capacidad: " + documento.getInteger("Capacidad") + "\n" + "Bancas: " + documento.getInteger("Bancas"));
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Aula no registrada");
                    }
                }
            }
        });
    }
}
