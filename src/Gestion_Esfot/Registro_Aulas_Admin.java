package Gestion_Esfot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro_Aulas_Admin {
    private JTextField codigo_aula;
    private JTextField num_aula;
    private JTextField capacidad_aula;
    private JButton registrar;
    public JPanel mainPanel;
    private JTextField bancas_aula;
    private JButton volver;

    public Registro_Aulas_Admin() {
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (codigo_aula.getText().isEmpty() || num_aula.getText().isEmpty() || capacidad_aula.getText().isEmpty() || bancas_aula.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Llene todos los campos");
                    return;
                }

                Registro_Aulas aula = new Registro_Aulas();
                aula.setCodigo_aula(codigo_aula.getText());
                aula.setNum_aula(Integer.parseInt(num_aula.getText()));
                aula.setCapacidad(Integer.parseInt(capacidad_aula.getText()));
                aula.setNumero_bancas(Integer.parseInt(bancas_aula.getText()));

                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Aulas");
                    org.bson.Document documents = new Document("Codigo Aula",aula.getCodigo_aula())
                            .append("Numero Aula", aula.getNum_aula())
                            .append("Capacidad", aula.getCapacidad())
                            .append("Bancas", aula.getNumero_bancas());
                    collection.insertOne(documents);
                    JOptionPane.showMessageDialog(null, "Registro agregado correctamente");
                    System.out.println("Documento insertado con éxito");

                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error en la conexion");
                    ex.printStackTrace();
                }

                ((JFrame) SwingUtilities.getWindowAncestor(registrar)).dispose();

            }
        });
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Volver");
                frame.setContentPane(new Aulas().mainPanel);
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
