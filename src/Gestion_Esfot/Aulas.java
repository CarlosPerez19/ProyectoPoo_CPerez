package Gestion_Esfot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aulas {
    private JButton registrar;
    private JButton eliminar;
    private JButton buscar;
    public JPanel mainPanel;
    private JButton actualizarButton;

    public Aulas() {
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Registrar Aula");
                frame.setContentPane(new Registro_Aulas_Admin().mainPanel);
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
                frame.setTitle("Eliminar Aula");
                frame.setContentPane(new Eliminar_Aula().mainPanel);
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
                frame.setTitle("Buscar Aula");
                frame.setContentPane(new Buscar_Aula().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });


        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setTitle("Actualizar Aula");
                frame.setContentPane(new Actualizar_Aulas().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
