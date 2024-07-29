package Gestion_Esfot;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que maneja la gestion para la reserva de laboratorios
 */
public class Reserva_Laboratorios {
    private JTextField codigo_lab;
    private JTextField hora_inicio;
    private JTextField hora_fin;
    private JTextField cedula;
    private JButton reservar;
    public JPanel mainPanel;
    private JTextField num_dia;
    private JButton volver;
    private JLabel image;
    private JLabel labos;

    /**
     * Constructor para la Reserva de laboratorios
     */
    public Reserva_Laboratorios() {

        // Imagenes que pareceran dentro del frame

        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        ImageIcon icon2 = new ImageIcon("src/img/laboratorios.jpg");
        icon2 = new ImageIcon(icon2.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
        labos.setIcon(icon2);

        // Manejo del boton para realizar reservas

        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Validacion  de campos vacios

                if (codigo_lab.getText().isEmpty() || hora_inicio.getText().isEmpty() || hora_fin.getText().isEmpty() || cedula.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Llenar todos los campos");
                    return;
                }

                // Validacion del campo de cedula

                if (cedula.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Cedula no valida");
                    return;
                }

                // Creacion y seteo del objeto con sus respectivas variables

                Reservas reserva = new Reservas();
                reserva.setCodigo(codigo_lab.getText());
                reserva.setHora_inicio(Integer.parseInt(hora_inicio.getText()));
                reserva.setHora_fin(Integer.parseInt(hora_fin.getText()));
                reserva.setDia(Integer.parseInt(num_dia.getText()));
                reserva.setCedula(cedula.getText());

                // Conexion a la base de datos y su respectiva colleccion

                try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                    MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                    MongoCollection<Document> collection = database.getCollection("Reservas");

                    // Construir la consulta para verificar si ya existe una reserva en el mismo horario

                    Bson query = Filters.and(
                            Filters.eq("Codigo", reserva.getCodigo()),
                            Filters.eq("Dia", reserva.getDia()),
                            Filters.or(
                                    Filters.and(
                                            Filters.gte("Inicio", reserva.getHora_inicio()),
                                            Filters.lte("Inicio", reserva.getHora_fin())
                                    ),
                                    Filters.and(
                                            Filters.gte("Fin", reserva.getHora_inicio()),
                                            Filters.lte("Fin", reserva.getHora_fin())
                                    ),
                                    Filters.and(
                                            Filters.lte("Inicio", reserva.getHora_inicio()),
                                            Filters.gte("Fin", reserva.getHora_fin())
                                    )
                            )
                    );

                    long count = collection.countDocuments(query);

                    // Consulta para verificar si ya hay una reserva existente en el mismo horario

                    if (count > 0) {
                        JOptionPane.showMessageDialog(null, "Ya existe una reserva para este horario");
                    } else {

                        Document documents = new Document("Cedula", reserva.getCedula())
                                .append("Codigo", reserva.getCodigo())
                                .append("Dia", reserva.getDia())
                                .append("Inicio", reserva.getHora_inicio())
                                .append("Fin", reserva.getHora_fin());
                        collection.insertOne(documents);
                        JOptionPane.showMessageDialog(null, "Registro agregado correctamente");
                        System.out.println("Documento insertado con éxito");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al insertar Documento");
                    ex.printStackTrace();
                }

                // Cierre del frame actual
                ((JFrame) SwingUtilities.getWindowAncestor(reservar)).dispose();
            }
        });

        // Manejo del boton volver, permite volver al frame anterior

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Profesor().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Cierre de la ventana actual
                ((JFrame) SwingUtilities.getWindowAncestor(volver)).dispose();
            }
        });
    }
}
