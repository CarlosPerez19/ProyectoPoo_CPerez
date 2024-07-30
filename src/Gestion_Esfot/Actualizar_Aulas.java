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

/**
 * Clase para actualizar registros de aulas
 */

public class Actualizar_Aulas {
    public JPanel mainPanel;
    private JTextField codigo_aula;
    private JComboBox element_act;
    private JTextField actualizacion;
    private JButton actualizar;
    private JButton volver;
    private JLabel image;

    /**
     * Constructor para la clase de actualizar aulas
     */

    public Actualizar_Aulas() {

        // Imagen del frame

        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Boton para actualizar registros
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Conexion con la base de datos e ingreso a la coleccion de aulas
                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Aulas");

                    // Variable de busqueda
                    String aula_actualizar = codigo_aula.getText();

                    // Actualizacion por seleccion del usuario
                    switch (element_act.getSelectedIndex()) {
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

        // Boton para volver al frame anterior

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Aulas().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Cierre del frame
                ((JFrame) SwingUtilities.getWindowAncestor(volver)).dispose();
            }
        });
    }
}
