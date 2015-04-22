package PkgEmployesClg;

import javax.swing.*;
import java.sql.Connection;

/**
 * Created by shaun on 2015-04-21.
 */
public class ConsulterLivresParGenre {
    private JTextField textField1;
    private JList List_LivreParGenre;
    private JButton BTN_Rechercher;
    public JPanel panel1;
    private JButton BTN_Suivant;
    private JButton BTN_Precedent;
    Connection connection;
    public ConsulterLivresParGenre(Connection conn)
    {
        connection = conn;
    }
}
