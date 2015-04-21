package PkgEmployesClg;
import java.awt.EventQueue;
import javax.swing.*;

/**
 * Created by shaun on 2015-04-21.
 */
public class ActionAdherent {
    private JTextField TB_NumAderent;
    private JTextField TB_Nom;
    private JTextField TB_Prenom;
    private JTextField TB_Adresse;
    private JTextField TB_NumTel;
    private JButton BTN_Ajouter;
    private JButton BTN_Modifier;
    private JButton BTN_Supprimer;
    private JFrame frame;
    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
    public static void main(String[] args){
                    ActionAdherent window = new ActionAdherent();
                    window.frame.setVisible(true);
    }
    public ActionAdherent() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 657, 469);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
    }
}
