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

    public Usuarios() {
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Registrar Usuario");
                frame.setContentPane(new Registro().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

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
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
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
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Actualizar_Usuarios().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
