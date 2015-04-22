package PkgEmployesClg;

import oracle.jdbc.OracleTypes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by shaun on 2015-04-21.
 */
public class ModAdherent {
    private JTextField TB_NumAderent;
    private JTextField TB_Nom;
    private JTextField TB_Prenom;
    private JTextField TB_Adresse;
    private JTextField TB_NumTel;
    private JButton BTN_Ajouter;
    private JButton BTN_Modifier;
    private JButton BTN_Supprimer;
    public JPanel panel1;
    private JButton BTN_Precedent;
    private JButton BTN_Suivant;
    private JFrame frame;
    Connection maConnection;
    Connection connection;
    ResultSet rest;
    public ModAdherent(Connection conn)
    {
        connection = conn;
        //maConnection = conn.getConnection();
        try{
            CallableStatement stm =connection.prepareCall("{ ? = call Adherents.AFFICHERTOUSLESADHERENTS()}");
            stm.registerOutParameter(1, OracleTypes.CURSOR);
            stm.execute(); //execution de la fonction
            // Caster le paramètre de retour en ResultSet
            rest = (ResultSet) stm.getObject(1);
            AfficherAdherent();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

        BTN_Precedent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(rest.previous())
                        AfficherAdherent();// affichage des résultat
                }
                catch (SQLException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        });
        BTN_Suivant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(rest.next())
                        AfficherAdherent();// affichage des résultat
                }
                catch (SQLException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        });
        BTN_Ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    CallableStatement stm =connection.prepareCall("{call Adherents.AJOUTERADHERENT(?,?,?,?)}");
                    stm.setString(1, TB_Nom.getText());
                    stm.setString(2, TB_Prenom.getText());
                    stm.setString(3, TB_Adresse.getText());
                    stm.setString(4, TB_NumTel.getText());
                    stm.execute(); //execution de la fonction
                }
                catch(SQLException ex){
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
    public void AfficherAdherent()
    {
        try{
            TB_NumAderent.setText(Long.toString(rest.getLong(1)));
            TB_Nom.setText(rest.getString(2));
            TB_Prenom.setText(rest.getString(3));
            TB_Adresse.setText(rest.getString(4));
            TB_NumTel.setText(rest.getString(5));
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
