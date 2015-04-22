package PkgEmployesClg;

import javax.swing.*;
import java.sql.Connection;

/**
 * Created by shaun on 2015-04-21.
 */
public class ListeLivresPlusEmprunte {
    private JTable Table_Livres;
    public JPanel panel1;
    Connection connection;
    public ListeLivresPlusEmprunte(Connection conn)
    {
        connection = conn;
    }
}
