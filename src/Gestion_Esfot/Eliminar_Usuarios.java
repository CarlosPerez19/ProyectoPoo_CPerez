package Gestion_Esfot;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creacion de clase para eliminar un usuario regisrado
 */
public class Eliminar_Usuarios {
    private JTextField cedula;
    private JButton eliminar;
    private JComboBox rol;
    public JPanel mainPanel;
    private JButton volver;
    private JLabel image;

    /**
     * Constructor para la clase de eliminar usuarios
     */
    public Eliminar_Usuarios() {

        // Imagen que parecera en el frame
        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        // Boton para eliminar un registro
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Control de campos vacios
                if (cedula.getText().isEmpty() || rol.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Llenar todos los campos");
                    return;
                }

                // Control de cedula valida
                if (cedula.getText().length() != 10) {
                    JOptionPane.showMessageDialog(null, "Ingrese una Cedula valida");
                    return;
                }

                // Seleccion del usuario a eliminar
                switch (rol.getSelectedIndex()) {
                    case 1:

                        // Conexion con la base de datos e ingreso a la coleccion de administrador
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Administrador");

                            // Variable con la cedula a buscar para eliminar el registro
                            String cedula_eliminar = cedula.getText();

                            // Filtro para buscar la cedula dentro de los registros
                            Document filtro = new Document("Cedula", cedula_eliminar );
                            DeleteResult resultado = collection.deleteOne(filtro);
                            JOptionPane.showMessageDialog(null, "Usuario Eliminado con Exito");
                            System.out.println("Documentos borrados: " + resultado.getDeletedCount());

                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
                        }

                        break;

                    case 2:

                        // Conexion con la base de datos e ingreso a la coleccion de profesores

                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Profesor");

                            // Variable para la busqueda del usuario a eliminar
                            String cedula_eliminar = cedula.getText();

                            // Filtro para buscar el resgistro
                            Document filtro = new Document("Cedula", cedula_eliminar );
                            DeleteResult resultado = collection.deleteOne(filtro);
                            JOptionPane.showMessageDialog(null, "Usuario Eliminado con Exito");
                            System.out.println("Documentos borrados: " + resultado.getDeletedCount());

                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
                        }

                        break;

                    case 3:

                        // Conexion con la base de datos e ingreso a la coleccion de estudiantes
                        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://carlos:1234@proyectopoo.powzq9l.mongodb.net/ProyectoPoo")) {
                            MongoDatabase database = mongoClient.getDatabase("ProyectoPoo");
                            MongoCollection<Document> collection = database.getCollection("Estudiante");

                            // Variable para buscar la cedula
                            String cedula_eliminar = cedula.getText();

                            // Filtro para buscar el registro
                            Document filtro = new Document("Cedula", cedula_eliminar );
                            DeleteResult resultado = collection.deleteOne(filtro);
                            JOptionPane.showMessageDialog(null, "Usuario Eliminado con Exito");
                            System.out.println("Documentos borrados: " + resultado.getDeletedCount());

                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
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

                // Cierre del frame actual
                ((JFrame) SwingUtilities.getWindowAncestor(volver)).dispose();
            }
        });
    }
}
