package Gestion_Esfot;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para la busqueda de usuarios
 */

public class Buscar_Usuarios {
    private JTextField cedula;
    private JButton buscar;
    public JPanel mainPanel;
    private JComboBox rol;
    private JButton volver;
    private JLabel image;

    /**
     * Constructor de la busqueda de usuarios
     */

    public Buscar_Usuarios() {

        // Imagen del frame
        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Boton para la busqueda del registro

        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Control de los campos vacios
                if (cedula.getText().isEmpty() || rol.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Llenar todos los campos");
                    return;
                }

                // Control de la logintud de la cedula
                if (cedula.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Ingrese una Cedula valida");
                    return;
                }

                // Ingreso a las coleccion por seleccion del administrador
                switch (rol.getSelectedIndex()) {
                    case 1:

                        boolean found = false;

                        // Conexion con la base de datos e ingreso a la coleccion de administradores
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Administrador");
                            FindIterable<Document> documentos = collection.find();

                            // Variable de busqueda
                            String cedula_buscar = cedula.getText();

                            // Ingreso y busqueda en la coleccion
                            for (Document documento : documentos) {
                                if (cedula_buscar.equals(documento.getString("Cedula"))) {
                                    found = true;
                                    JOptionPane.showMessageDialog(null, "Cedula existente");
                                    JOptionPane.showMessageDialog(null, "Nombre: " + documento.getString("Nombre:") + "\n" + "Apellido: " + documento.getString("Apellido")
                                            + "\n" + "Edad: " + documento.getInteger("Edad") + "\n" + "Usuario: " + documento.getString("Usuario"));
                                    break;
                                }
                            }

                            // Control en caso de usuario no registrado
                            if(!found){
                                JOptionPane.showMessageDialog(null, "Cedula no registrada");
                            }
                        }

                        break;

                    case 2:

                        boolean found2 = false;

                        // Conexion con la base de datos e ingreso a la coleccion de profesores
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Profesor");
                            FindIterable<Document> documentos = collection.find();

                            // Variable de busqueda
                            String cedula_buscar = cedula.getText();

                            // Ingreso y busqueda en la coleccion
                            for (Document documento : documentos) {
                                if (cedula_buscar.equals(documento.getString("Cedula"))) {
                                    found2 = true;
                                    JOptionPane.showMessageDialog(null, "Cedula existente");
                                    JOptionPane.showMessageDialog(null, "Nombre: " + documento.getString("Nombre:") + "\n" + "Apellido: " + documento.getString("Apellido")
                                            + "\n" + "Edad: " + documento.getInteger("Edad") + "\n" + "Usuario: " + documento.getString("Usuario"));
                                    break;
                                }
                            }

                            // Control en caso de usuario no registrado
                            if(!found2){
                                JOptionPane.showMessageDialog(null, "Cedula no registrada");
                            }
                        }

                        break;

                    case 3:

                        boolean found3 = false;

                        // Conexion con la base de datos e ingreso a la coleccion de administrador
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Administrador");
                            FindIterable<Document> documentos = collection.find();

                            // Variable de busqueda
                            String cedula_buscar = cedula.getText();

                            // Ingreso y busqueda en la coleccion
                            for (Document documento : documentos) {
                                if (cedula_buscar.equals(documento.getString("Cedula"))) {
                                    found3 = true;
                                    JOptionPane.showMessageDialog(null, "Cedula existente");
                                    JOptionPane.showMessageDialog(null, "Nombre: " + documento.getString("Nombre:") + "\n" + "Apellido: " + documento.getString("Apellido")
                                            + "\n" + "Edad: " + documento.getInteger("Edad") + "\n" + "Usuario: " + documento.getString("Usuario"));
                                    break;
                                }
                            }

                            // Control en caso de usuario no registrado
                            if(!found3){
                                JOptionPane.showMessageDialog(null, "Cedula no registrada");
                            }
                        }

                        break;
                }

            }
        });

        // Boton para volver al frame anterior

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Usuarios().mainPanel);
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
