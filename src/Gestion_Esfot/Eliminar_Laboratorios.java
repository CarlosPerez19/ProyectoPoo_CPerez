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

/**
 * Creacion de la clase para elminar laboratorios registrados
 */
public class Eliminar_Laboratorios {
    private JTextField codigo_lab;
    private JButton eliminar;
    public JPanel mainPanel;
    private JButton volver;
    private JLabel image;

    /**
     * Contructor de la clase de eliminar laboratorios
     */
    public Eliminar_Laboratorios() {

        // Imagen que aparecera en el frame
        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Boton para eliminar un registro
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Control para el campo vacio
                if (codigo_lab.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese el codigo de Laboratorio");
                    return;
                }

                // Conexion con la base datos e ingreso a la coleccion de laboratorios
                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Laboratorios");

                    // Variable para la busqueda del registro
                    String lab_eliminar = codigo_lab.getText();

                    // Filtro para buscar el registro
                    Document filtro = new Document("Codigo Lab", lab_eliminar );
                    DeleteResult resultado = collection.deleteOne(filtro);
                    JOptionPane.showMessageDialog(null, "Laboratorio Eliminado con Exito");
                    System.out.println("Documentos borrados: " + resultado.getDeletedCount());

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al eliminar el Laboratorio");
                }

            }
        });

        // Boton para volver al frame anterior
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

                // Cierre del frame
                ((JFrame) SwingUtilities.getWindowAncestor(volver)).dispose();
            }
        });
    }
}
