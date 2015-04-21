package PkgEmployesClg;

import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Menu");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new Menu().panel1);
                frame.pack();
                frame.setVisible(true);
                frame.setSize(700,300);

            }
        });
    }
}