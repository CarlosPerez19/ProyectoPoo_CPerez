package Gestion_Esfot;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buscar_Laboratorios {
    private JTextField codigo_lab;
    private JButton buscar;
    public JPanel mainPanel;
    private JButton volver;

    public Buscar_Laboratorios() {
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (codigo_lab.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese un numero de Laboratorio");
                    return;
                }

                boolean found = false;

                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Laboratorios");
                    FindIterable<Document> documentos = collection.find();

                    String lab_buscar = codigo_lab.getText();

                    for (Document documento : documentos) {
                        if (lab_buscar.equals(documento.getString("Codigo Lab"))) {
                            found = true;
                            JOptionPane.showMessageDialog(null, "Laboratorio existente");
                            JOptionPane.showMessageDialog(null, "Numero Lab: " + documento.getInteger("Numero Lab") + "\n" + "Nombre Lab: " + documento.getString("Nombre Lab")
                                    + "\n" + "Capacidad: " + documento.getInteger("Capacidad") + "\n" + "Computadores: " + documento.getInteger("Computadores"));
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Laboratorio no registrado");
                    }
                }
            }
        });
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Laboratorios().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
