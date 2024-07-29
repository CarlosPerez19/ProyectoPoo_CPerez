package Gestion_Esfot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para gestionar aulas
 */
public class Aulas {
    private JButton registrar;
    private JButton eliminar;
    private JButton buscar;
    public JPanel mainPanel;
    private JButton actualizar;
    private JButton volver;
    private JLabel image;
    private JLabel admin;

    /**
     * Constructor de la clase de aulas
     */

    public Aulas() {

        // Imagenes que apareceran en el frame
        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        ImageIcon icon2 = new ImageIcon("src/img/administrador.png");
        icon2 = new ImageIcon(icon2.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
        admin.setIcon(icon2);

        // Boton para llamar al frame de registro de aulas

        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Registrar Aula");
                frame.setContentPane(new Registro_Aulas_Admin().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Cierre de ventana
                ((JFrame) SwingUtilities.getWindowAncestor(registrar)).dispose();
            }
        });

        // Boton para llamar el frame de eliminar
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Eliminar Aula");
                frame.setContentPane(new Eliminar_Aula().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Cierre de ventana
                ((JFrame) SwingUtilities.getWindowAncestor(eliminar)).dispose();
            }
        });

        // Boton para abrir el frame de busqueda de aulas
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Buscar Aula");
                frame.setContentPane(new Buscar_Aula().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Cierre de la ventana
                ((JFrame) SwingUtilities.getWindowAncestor(buscar)).dispose();
            }
        });

        // Boton para abrir el frame de actualizar
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Actualizar Aula");
                frame.setContentPane(new Actualizar_Aulas().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Cierre de la ventan
                ((JFrame) SwingUtilities.getWindowAncestor(actualizar)).dispose();
            }
        });

        // Volver al frame anterior
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Volver");
                frame.setContentPane(new Administrador().mainPanel);
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
