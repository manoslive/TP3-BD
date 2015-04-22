package PkgEmployesClg;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main{
    public static ConnectionOracle connection;
    public static void main(String[] args) {
        connection = new ConnectionOracle();
        connection.setConnection("beloinem","ORACLE1");
        connection.connecter();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Menu");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new Menu(connection.getConnection()).panel1);
                frame.pack();
                frame.setVisible(true);
                frame.setSize(700,300);
                frame.addWindowListener( new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        connection.deconnecter();
                    }
                });
            }
        });
    }
}