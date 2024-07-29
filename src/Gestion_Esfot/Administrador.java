package Gestion_Esfot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para la gestion de elementos por parte del administrador
 */
public class Administrador {
    private JButton usuarios;
    private JButton laboratorios;
    private JButton aulas;
    public JPanel mainPanel;
    private JLabel image;
    private JLabel admin;
    private JButton cerrarSesion;

    /**
     * Constructor para la clase de administrador
     */

    public Administrador() {

        // Imagenes que apareceran en el frame
        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        ImageIcon icon2 = new ImageIcon("src/img/administrador.png");
        icon2 = new ImageIcon(icon2.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
        admin.setIcon(icon2);

        // Frame para gestionar usuarios
        usuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Administrador");
                frame.setContentPane(new Usuarios().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Cierre de la ventana
                ((JFrame) SwingUtilities.getWindowAncestor(usuarios)).dispose();

            }
        });

        // Frame para gestionar laboratorios
        laboratorios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Laboratorios");
                frame.setContentPane(new Laboratorios().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Cierre del frame
                ((JFrame) SwingUtilities.getWindowAncestor(laboratorios)).dispose();
            }
        });

        // Frame para gestionar aulas
        aulas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Aulas");
                frame.setContentPane(new Aulas().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Cierre del frame
                ((JFrame) SwingUtilities.getWindowAncestor(aulas)).dispose();
            }
        });

        // Boton para cerrar sesion, abre el menu principal de logeo
        cerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Login().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Cierre del frame
                ((JFrame) SwingUtilities.getWindowAncestor(cerrarSesion)).dispose();
            }
        });
    }
}
