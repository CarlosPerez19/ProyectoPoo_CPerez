package Gestion_Esfot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profesor {
    private JComboBox seleccion_reserva;
    private JButton reservar;
    public JPanel mainPanel;

    public Profesor() {
        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (seleccion_reserva.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione una reserva");
                    return;
                }

                switch (seleccion_reserva.getSelectedIndex()) {

                    case 1:
                        JFrame frame = new JFrame();
                        frame.setContentPane(new Reserva_Laboratorios().mainPanel);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);

                        break;

                    case 2:
                        JFrame frame2 = new JFrame();
                        frame2.setContentPane(new Reservas_Aulas().mainPanel);
                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame2.pack();
                        frame2.setLocationRelativeTo(null);
                        frame2.setVisible(true);

                        break;
                }
            }
        });
    }
}
