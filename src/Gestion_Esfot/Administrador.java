package Gestion_Esfot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administrador {
    private JButton usuarios;
    private JButton laboratorios;
    private JButton aulas;
    public JPanel mainPanel;


    public Administrador() {
        usuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Administrador");
                frame.setContentPane(new Usuarios().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }
}
