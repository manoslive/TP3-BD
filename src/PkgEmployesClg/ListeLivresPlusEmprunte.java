package PkgEmployesClg;

import javax.swing.*;

/**
 * Created by shaun on 2015-04-21.
 */
public class ListeLivresPlusEmprunte {
    private JTable Table_Livres;
    public JPanel panel1;
    ConnectionOracle connection;
    public ListeLivresPlusEmprunte(ConnectionOracle conn)
    {
        connection = conn;
    }
}
