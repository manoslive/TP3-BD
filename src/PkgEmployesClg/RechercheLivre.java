package PkgEmployesClg;

import javax.swing.*;
import java.sql.Connection;

/**
 * Created by shaun on 2015-04-21.
 */
public class RechercheLivre {
    private JTextField TB_Titre;
    private JTextField TB_Auteur;
    private JButton BTN_Recherche;
    private JTable Table_Resultat;
    public JPanel panel1;
    Connection connection;
    public RechercheLivre(Connection conn)
    {
        connection = conn;
    }
}
