package PkgEmployesClg;

import javax.swing.*;
import java.sql.Connection;

/**
 * Created by shaun on 2015-04-21.
 */
public class ConsulterLivresPrete {
    private JTable Table_LivreEmprunte;
    public JPanel panel1;
    Connection connection;
    public ConsulterLivresPrete(Connection conn)
    {
        connection = conn;
    }
}
