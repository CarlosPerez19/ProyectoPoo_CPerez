package Gestion_Esfot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase para la funcionalidad del profesor
 */
public class Profesor {
    private JComboBox seleccion_reserva;
    private JButton reservar;
    public JPanel mainPanel;
    private JLabel profesor;
    private JLabel image;
    private JButton cerrarSesion;

    /**
     * Contructor para la case profesor
     */
    public Profesor() {

        // Imagenes que apareceran en el frame

        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        ImageIcon icon2 = new ImageIcon("src/img/profesor.png");
        icon2 = new ImageIcon(icon2.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
        profesor.setIcon(icon2);

        // Boton para realizar una reserva

        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Control para la seleccion del usuario
                if (seleccion_reserva.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione una reserva");
                    return;
                }

                // Llamado al frame con la respectiva seleccion del usuario
                switch (seleccion_reserva.getSelectedIndex()) {

                    case 1:

                        // Apertura del frame de reserva de laboratorios

                        JFrame frame = new JFrame();
                        frame.setContentPane(new Reserva_Laboratorios().mainPanel);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setSize(900, 800);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);

                        break;

                    case 2:

                        // Apertura del frame para reserva de aulas

                        JFrame frame2 = new JFrame();
                        frame2.setContentPane(new Reservas_Aulas().mainPanel);
                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame2.pack();
                        frame2.setSize(900, 800);
                        frame2.setLocationRelativeTo(null);
                        frame2.setVisible(true);

                        break;
                }

                // Cierre del frame actual
                ((JFrame) SwingUtilities.getWindowAncestor(reservar)).dispose();
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
