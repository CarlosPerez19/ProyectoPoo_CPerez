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

public class Eliminar_Aula {
    private JTextField codigo_aula;
    private JButton eliminar;
    public JPanel mainPanel;
    private JButton volver;

    public Eliminar_Aula() {
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (codigo_aula.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese el codigo de Aula");
                    return;
                }

                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Aulas");
                    String aula_eliminar = codigo_aula.getText();
                    Document filtro = new Document("Codigo Aula", aula_eliminar );
                    DeleteResult resultado = collection.deleteOne(filtro);
                    JOptionPane.showMessageDialog(null, "Aula Eliminada con Exito");
                    System.out.println("Documentos borrados: " + resultado.getDeletedCount());

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al eliminar el Aula");
                }

                ((JFrame) SwingUtilities.getWindowAncestor(eliminar)).dispose();
            }
        });
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Aulas().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(volver)).dispose();
            }
        });
    }
}
