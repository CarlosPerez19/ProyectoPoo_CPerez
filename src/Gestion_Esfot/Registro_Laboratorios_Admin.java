package Gestion_Esfot;

import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para el Registro de Laboratorios por parte del administrador
 */
public class Registro_Laboratorios_Admin {
    private JTextField numero_lab;
    private JTextField nombre_lab;
    private JTextField capacidad_lab;
    private JTextField pc_lab;
    private JButton registrar;
    public JPanel mainPanel;
    private JTextField codigo_lab;
    private JButton volver;
    private JLabel image;

    /**
     * Constructor de la clase registro de laboratorios
     */

    public Registro_Laboratorios_Admin() {

        // Imagenes que se mostraran en el frame

        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Boton para registrar un nuevo laboratorio

        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Control de los campos vacios

                if (numero_lab.getText().isEmpty() || nombre_lab.getText().isEmpty() || capacidad_lab.getText().isEmpty() || pc_lab.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                    return;
                }

                // Creacion y seteo de un objeto con sus respectivas variables

                Registro_Laboratorios laboratorio = new Registro_Laboratorios();
                laboratorio.setCodigo_lab(codigo_lab.getText());
                laboratorio.setNumero_laboratorio(Integer.parseInt(numero_lab.getText()));
                laboratorio.setNombre_laboratorio(nombre_lab.getText());
                laboratorio.setCapacidad_laboratorio(Integer.parseInt(capacidad_lab.getText()));
                laboratorio.setNumero_computadores(Integer.parseInt(numero_lab.getText()));

                // Conexion con la  base de datos en sus respectiva coleccion

                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Laboratorios");

                    // Creacion del documento para insertar en la coleccion

                    org.bson.Document documents = new Document("Numero Lab",laboratorio.getNumero_laboratorio())
                            .append("Nombre Lab", laboratorio.getNombre_laboratorio())
                            .append("Capacidad", laboratorio.getCapacidad_laboratorio())
                            .append("Computadores", laboratorio.getNumero_computadores())
                            .append("Codigo Lab", laboratorio.getCodigo_lab());
                    collection.insertOne(documents);
                    System.out.println("Documento insertado con éxito");

                } catch (MongoWriteException ex) {

                    // Validacion en caso de laboratorio ya existente
                    if (ex.getError().getCategory().equals(com.mongodb.ErrorCategory.DUPLICATE_KEY)) {
                        JOptionPane.showMessageDialog(null, "Laboratorio ya registrado");
                    } else {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al insertar documento");
                    }
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
