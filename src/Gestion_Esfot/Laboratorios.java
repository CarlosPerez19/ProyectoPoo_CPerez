package Gestion_Esfot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Laboratorios {
    private JButton registrar;
    private JButton buscarButton;
    private JButton eliminarButton;
    public JPanel mainPanel;
    private JButton actualizar;
    private JButton volver;
    private JLabel image;
    private JLabel admin;

    public Laboratorios() {

        ImageIcon icon = new ImageIcon("src/img/logo_esfot_buho.png");
        icon = new ImageIcon(icon.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH));
        image.setIcon(icon);

        ImageIcon icon2 = new ImageIcon("src/img/administrador.png");
        icon2 = new ImageIcon(icon2.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
        admin.setIcon(icon2);

        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Registro_Laboratorios_Admin().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(registrar)).dispose();

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Eliminar_Laboratorios().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(eliminarButton)).dispose();
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Buscar_Laboratorios().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(buscarButton)).dispose();
            }
        });
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Actualizar_Laboratorios().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(actualizar)).dispose();
            }
        });
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Administrador().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(volver)).dispose();
            }
        });
    }
}
