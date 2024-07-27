package Gestion_Esfot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuarios {
    private JButton registrar;
    private JButton buscar;
    public JPanel mainPanel;
    private JButton eliminar;
    private JButton actualizar;
    private JButton volver;
    private JLabel image;
    private JLabel admin;

    public Usuarios() {

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
                frame.setTitle("Registrar Usuario");
                frame.setContentPane(new Registro().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(registrar)).dispose();

            }
        });
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Buscar Usuario");
                frame.setContentPane(new Buscar_Usuarios().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(buscar)).dispose();
            }
        });
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Eliminar Usuario");
                frame.setContentPane(new Eliminar_Usuarios().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(900, 800);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(eliminar)).dispose();
            }
        });
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Actualizar_Usuarios().mainPanel);
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
                frame.setTitle("Volver");
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
