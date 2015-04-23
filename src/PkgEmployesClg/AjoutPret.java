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
    private JButton BTN_Ajouter;
    public JPanel panel1;
    Connection connection;
    ResultSet rset=null;

    public AjoutPret(Connection conn) {
        connection = conn;
        BTN_Ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // On cast les dates dans le bon format
                    //Date datePret = Date.valueOf(TB_DatePret.getText());
                    //Date dateRetour = Date.valueOf(TB_DateRetour.getText());
                    ;
                    if(!EstPrete()) {
                        CallableStatement stm = connection.prepareCall("{call BIBLIOTHEQUE.AJOUTEREMPRUNT(?,?)}");
                        stm.setLong(1, Long.parseLong(TB_NumExemplaire.getText()));
                        stm.setLong(2, Long.parseLong(TB_NumAdherent.getText()));
                        stm.execute();//execution de la fonction
                    }
                    else
                       JOptionPane.showMessageDialog(null,"L'exemplaire est déjà prêté!","Erreur",1);

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
    public boolean EstPrete() {
        boolean estPrete = false;
        String sql = "select * from emprunts where numexemplaire='" + TB_NumExemplaire.getText() + "' and date_retour > sysdate";
        try {
            Statement stm = connection.prepareStatement(sql);
            rset = stm.executeQuery(sql);//execution de la fonction
            if(rset != null)
                estPrete = true;

        } catch (SQLException se) {

        }
        return estPrete;
    }
}


