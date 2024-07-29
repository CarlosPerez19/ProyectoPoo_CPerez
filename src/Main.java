/**
 * @Author Carlos Perez
 * Main es el punto de entrada a la aplicacion para realizar el login
 */

import Gestion_Esfot.Login;
import Gestion_Esfot.Registro;

import javax.swing.*;


    // Se realiza la llamada al frame de Login

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setContentPane(new Login().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(900, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}