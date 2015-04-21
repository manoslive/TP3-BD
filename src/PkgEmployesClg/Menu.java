package PkgEmployesClg;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

    public Menu() {
        BTN_ActionAdherent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ActionAdherent();
            }
        });
    }
    public static void main()
    {

    }
}
