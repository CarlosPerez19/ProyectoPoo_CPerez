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

/***
 * Clase para el registro de aulas por parte del administrador
 */

public class Registro_Aulas_Admin {
    private JTextField codigo_aula;
    private JTextField num_aula;
    private JTextField capacidad_aula;
    private JButton registrar;
    public JPanel mainPanel;
    private JTextField bancas_aula;
    private JButton volver;
    private JLabel image;

    /**
     * Contructor para la clase de registro de aulas
     */

    public Registro_Aulas_Admin() {

        // Imagen que aparecera dentro del frame
        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Bonton para realizar el registro de un aula

        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Control para los campos vacios

                if (codigo_aula.getText().isEmpty() || num_aula.getText().isEmpty() || capacidad_aula.getText().isEmpty() || bancas_aula.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Llene todos los campos");
                    return;
                }

                // Creacion y seteo del objeto con sus respectivas variables

                Registro_Aulas aula = new Registro_Aulas();
                aula.setCodigo_aula(codigo_aula.getText());
                aula.setNum_aula(Integer.parseInt(num_aula.getText()));
                aula.setCapacidad(Integer.parseInt(capacidad_aula.getText()));
                aula.setNumero_bancas(Integer.parseInt(bancas_aula.getText()));

                // Conexion con la base de datos y su respectiva coleccion

                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Aulas");

                    // Creacion del documento a insertar en la base de datos
                    org.bson.Document documents = new Document("Codigo Aula",aula.getCodigo_aula())
                            .append("Numero Aula", aula.getNum_aula())
                            .append("Capacidad", aula.getCapacidad())
                            .append("Bancas", aula.getNumero_bancas());
                    collection.insertOne(documents);
                    JOptionPane.showMessageDialog(null, "Registro agregado correctamente");
                    System.out.println("Documento insertado con éxito");

                }catch (MongoWriteException ex) {

                    // Validacion en caso de aula ya existente
                    if (ex.getError().getCategory().equals(com.mongodb.ErrorCategory.DUPLICATE_KEY)) {
                        JOptionPane.showMessageDialog(null, "Aula ya registrada");
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
                frame.setTitle("Volver");
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
