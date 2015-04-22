package PkgEmployesClg;

import javax.swing.*;

/**
 * Created by shaun on 2015-04-21.
 */
public class ConsulterLivresPrete {
    private JTable Table_LivreEmprunte;
    public JPanel panel1;
    ConnectionOracle connection;
    public ConsulterLivresPrete(ConnectionOracle conn)
    {
        connection = conn;
    }
}
