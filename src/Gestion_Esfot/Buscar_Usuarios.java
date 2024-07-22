package Gestion_Esfot;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buscar_Usuarios {
    private JTextField cedula;
    private JButton buscar;
    public JPanel mainPanel;
    private JComboBox rol;

    public Buscar_Usuarios() {
        buscar.addActionListener(new ActionListener() {
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

                        boolean found = false;

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Administrador");
                            FindIterable<Document> documentos = collection.find();

                            String cedula_buscar = cedula.getText();

                            for (Document documento : documentos) {
                                if (cedula_buscar.equals(documento.getString("Cedula"))) {
                                    found = true;
                                    JOptionPane.showMessageDialog(null, "Cedula existente");
                                    JOptionPane.showMessageDialog(null, "Nombre: " + documento.getString("Nombre:") + "\n" + "Apellido: " + documento.getString("Apellido")
                                            + "\n" + "Edad: " + documento.getInteger("Edad") + "\n" + "Usuario: " + documento.getString("Usuario"));
                                    break;
                                }
                            }

                            if(!found){
                                JOptionPane.showMessageDialog(null, "Cedula no registrada");
                            }
                        }

                        break;

                    case 2:
                        boolean found2 = false;

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Profesor");
                            FindIterable<Document> documentos = collection.find();

                            String cedula_buscar = cedula.getText();

                            for (Document documento : documentos) {
                                if (cedula_buscar.equals(documento.getString("Cedula"))) {
                                    found2 = true;
                                    JOptionPane.showMessageDialog(null, "Cedula existente");
                                    JOptionPane.showMessageDialog(null, "Nombre: " + documento.getString("Nombre:") + "\n" + "Apellido: " + documento.getString("Apellido")
                                            + "\n" + "Edad: " + documento.getInteger("Edad") + "\n" + "Usuario: " + documento.getString("Usuario"));
                                    break;
                                }
                            }

                            if(!found2){
                                JOptionPane.showMessageDialog(null, "Cedula no registrada");
                            }
                        }

                        break;

                    case 3:
                        boolean found3 = false;

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Administrador");
                            FindIterable<Document> documentos = collection.find();

                            String cedula_buscar = cedula.getText();

                            for (Document documento : documentos) {
                                if (cedula_buscar.equals(documento.getString("Cedula"))) {
                                    found3 = true;
                                    JOptionPane.showMessageDialog(null, "Cedula existente");
                                    JOptionPane.showMessageDialog(null, "Nombre: " + documento.getString("Nombre:") + "\n" + "Apellido: " + documento.getString("Apellido")
                                            + "\n" + "Edad: " + documento.getInteger("Edad") + "\n" + "Usuario: " + documento.getString("Usuario"));
                                    break;
                                }
                            }

                            if(!found3){
                                JOptionPane.showMessageDialog(null, "Cedula no registrada");
                            }
                        }

                        break;
                }
            }
        });
    }
}