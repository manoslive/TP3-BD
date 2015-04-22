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
    private JFormattedTextField TB_DatePret;
    private JFormattedTextField TB_DateRetour;
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
                    // On cast les dates dans le bon format
                    Date datePret = Date.valueOf(TB_DatePret.getText());
                    Date dateRetour = Date.valueOf(TB_DateRetour.getText());

                    CallableStatement stm = connection.prepareCall("{call BIBLIOTHEQUE.AJOUTEREMPRUNT(?,?,?,?)}");
                    stm.setLong(1, Long.parseLong(TB_NumExemplaire.getText()));
                    stm.setLong(2, Long.parseLong(TB_NumAdherent.getText()));
                    stm.setDate(3, datePret);
                    stm.setDate(4, dateRetour);

                    stm.execute(); //execution de la fonction

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
}
