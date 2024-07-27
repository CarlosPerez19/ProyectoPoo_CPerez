package Gestion_Esfot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eliminar_Laboratorios {
    private JTextField codigo_lab;
    private JButton eliminar;
    public JPanel mainPanel;
    private JButton volver;

    public Eliminar_Laboratorios() {
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (codigo_lab.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese el codigo de Laboratorio");
                    return;
                }

                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Laboratorios");
                    String lab_eliminar = codigo_lab.getText();
                    Document filtro = new Document("Codigo Lab", lab_eliminar );
                    DeleteResult resultado = collection.deleteOne(filtro);
                    JOptionPane.showMessageDialog(null, "Laboratorio Eliminado con Exito");
                    System.out.println("Documentos borrados: " + resultado.getDeletedCount());

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al eliminar el Laboratorio");
                }

                ((JFrame) SwingUtilities.getWindowAncestor(eliminar)).dispose();
            }
        });
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Laboratorios().mainPanel);
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
