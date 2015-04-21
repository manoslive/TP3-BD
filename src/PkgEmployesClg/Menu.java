package PkgEmployesClg;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;


/**
 * Created by shaun on 2015-04-20.
 */
public class Menu {
    private JButton BTN_ActionAdherent;
    private JButton BTN_ConsulterLivres;
    private JButton AjouterPret;
    private JButton ConsulterLivresPrets;
    private JButton BTN_RechercheLivre;
    private JButton BTN_LivrePlusEmpruntes;
    private JButton button1;
    public JPanel panel1;

    public Menu() {

        BTN_ActionAdherent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        AjouterPret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JFrame frame = new JFrame("ActionAdherent");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.add(new AjoutPret().panel1);
                        frame.pack();
                        frame.setVisible(true);
                        frame.setSize(700,300);

                    }
                });
            }
        });
    }

    public static void main(String[] args) {

    }
}