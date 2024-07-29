package Gestion_Esfot;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para buscar aulas registradas
 */
public class Buscar_Aula {
    private JTextField codigo_aula;
    private JButton buscar;
    public JPanel mainPanel;
    private JButton volver;
    private JLabel image;

    /**
     * Constructor para la busqueda de aulas
     */

    public Buscar_Aula() {

        // Imagen que aparecera en el frame
        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Boton para la busqueda de registros
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Control de campo vacio
                if (codigo_aula.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese un codigo de Aula");
                    return;
                }

                boolean found = false;

                // Conexion con la base datos e ingreso a la coleccion de aulas
                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Aulas");
                    FindIterable<Document> documentos = collection.find();

                    // Variable de busqueda
                    String aula_buscar = codigo_aula.getText();

                    // Busqueda del registro
                    for (Document documento : documentos) {
                        if (aula_buscar.equals(documento.getString("Codigo Aula"))) {
                            found = true;
                            JOptionPane.showMessageDialog(null, "Aula existente");
                            JOptionPane.showMessageDialog(null, "Numero Aula: " + documento.getInteger("Numero Aula")
                                    + "\n" + "Capacidad: " + documento.getInteger("Capacidad") + "\n" + "Bancas: " + documento.getInteger("Bancas"));
                            break;
                        }
                    }

                    // Control en caso de aula no registrada
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Aula no registrada");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error de conexion");
                    ex.printStackTrace();
                }

                // Cierre del frame
                ((JFrame) SwingUtilities.getWindowAncestor(buscar)).dispose();
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
