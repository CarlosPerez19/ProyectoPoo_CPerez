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
 * Clase para elminar aulas registradas
 */
public class Eliminar_Aula {
    private JTextField codigo_aula;
    private JButton eliminar;
    public JPanel mainPanel;
    private JButton volver;
    private JLabel image;

    /**
     * Constructor para la clase eliminar aula
     */
    public Eliminar_Aula() {

        // Imagen del frame
        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Boton para eliminar el registro
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Control del campo vacio
                if (codigo_aula.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese el codigo de Aula");
                    return;
                }

                // Conexion con la base de datos e ingreso a la coleccion de aulas
                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {

                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Aulas");

                    // Variable de ingreso
                    String aula_eliminar = codigo_aula.getText();

                    // Filtro de busqueda
                    Document filtro = new Document("Codigo Aula", aula_eliminar );
                    DeleteResult resultado = collection.deleteOne(filtro);
                    JOptionPane.showMessageDialog(null, "Aula Eliminada con Exito");
                    System.out.println("Documentos borrados: " + resultado.getDeletedCount());

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al eliminar el Aula");
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
