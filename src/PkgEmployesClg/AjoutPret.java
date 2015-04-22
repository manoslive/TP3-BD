package PkgEmployesClg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by shaun on 2015-04-21.
 */
public class AjoutPret {
    private JTextField TB_NumExemplaire;
    private JTextField TB_NumAdherent;
    private JTextField TB_DatePret;
    private JTextField TB_DateRetour;
    private JButton BTN_Ajouter;
    public JPanel panel1;
    Connection connection;
    ResultSet rset;
    public AjoutPret(Connection conn)
    {
        connection = conn;
        BTN_Ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CallableStatement stm = connection.prepareCall("{call BIBLIOTHEQUE.AJOUTPRET(?,?,?,?)}");
                    //stm.registerOutParameter(1, OracleTypes.CURSOR);
                    stm.setLong(1, Long.getLong(TB_NumExemplaire.getText()));
                    stm.setLong(2, Long.getLong(TB_NumExemplaire.getText()));
                    stm.setLong(3, Long.getLong(TB_NumExemplaire.getText()));
                    stm.setLong(4, Long.getLong(TB_NumExemplaire.getText()));
                    stm.execute(); //execution de la fonction
                    // Caster le paramètre de retour en ResultSet
                    rset = (ResultSet) stm.getObject(1);

                    ResultSetMetaData metaData = rset.getMetaData();

                    while (rset.next()) {}
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
}
