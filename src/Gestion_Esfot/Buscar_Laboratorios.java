package Gestion_Esfot;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para buscar laboratorios registrados
 */

public class Buscar_Laboratorios {
    private JTextField codigo_lab;
    private JButton buscar;
    public JPanel mainPanel;
    private JButton volver;
    private JLabel image;

    /**
     * Constructor para buscar laboratorios
     */
    public Buscar_Laboratorios() {

        // Imagen que se presentara en el frame
        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Boton para buscar registro
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Control de campo vacio
                if (codigo_lab.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ingrese un numero de Laboratorio");
                    return;
                }

                boolean found = false;

                // Conexion con la base de datos e ingreso a la coleccion de laboratorios
                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Laboratorios");
                    FindIterable<Document> documentos = collection.find();

                    // Variables de busqueda
                    String lab_buscar = codigo_lab.getText();

                    // Busqueda del registro
                    for (Document documento : documentos) {
                        if (lab_buscar.equals(documento.getString("Codigo Lab"))) {
                            found = true;
                            JOptionPane.showMessageDialog(null, "Laboratorio existente");
                            JOptionPane.showMessageDialog(null, "Numero Lab: " + documento.getInteger("Numero Lab") + "\n" + "Nombre Lab: " + documento.getString("Nombre Lab")
                                    + "\n" + "Capacidad: " + documento.getInteger("Capacidad") + "\n" + "Computadores: " + documento.getInteger("Computadores"));
                            break;
                        }
                    }

                    // Control en caso de laboratorio registrado
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Laboratorio no registrado");
                    }

                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error de conexion");
                    ex.printStackTrace();
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
