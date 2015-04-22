package PkgEmployesClg;

import oracle.jdbc.OracleTypes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

/**
 * Created by shaun on 2015-04-21.
 */
public class RechercheLivre {
    private JTextField TB_Titre;
    private JTextField TB_Auteur;
    private JButton BTN_RechercheTitre;
    private JTable Table_Resultat;
    public JPanel panel1;
    private JButton BTN_RechercheAuteur;
    Connection connection;
    ResultSet rset;
    public RechercheLivre(Connection conn) {
        connection = conn;
        BTN_RechercheTitre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CallableStatement stm = connection.prepareCall("{ ? = call BIBLIOTHEQUE.AFFICHERLIVRESPARTITRE(?)}");
                    stm.registerOutParameter(1, OracleTypes.CURSOR);
                    stm.setString(2, TB_Titre.getText());
                    stm.execute(); //execution de la fonction
                    // Caster le paramètre de retour en ResultSet
                    rset = (ResultSet) stm.getObject(1);
                    ResultSetMetaData metaData = rset.getMetaData();

                    // names of columns
                    Vector<String> columnNames = new Vector<String>();
                    int columnCount = metaData.getColumnCount();
                    for (int column = 1; column <= columnCount; column++) {
                        columnNames.add(metaData.getColumnName(column));
                    }
                    // data of the table
                    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
                    while (rset.next()) {
                        Vector<Object> vector = new Vector<Object>();
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            //if(rset.getObject(columnIndex))
                            vector.add(rset.getObject(columnIndex));
                        }
                        data.add(vector);
                    }

                    DefaultTableModel model = new DefaultTableModel(data, columnNames);
                    Table_Resultat.setModel(model);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        BTN_RechercheAuteur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CallableStatement stm = connection.prepareCall("{ ? = call BIBLIOTHEQUE.AFFICHERLIVRESPARAUTEUR(?)}");
                    stm.registerOutParameter(1, OracleTypes.CURSOR);
                    stm.setString(2, TB_Auteur.getText());
                    stm.execute(); //execution de la fonction
                    // Caster le paramètre de retour en ResultSet
                    rset = (ResultSet) stm.getObject(1);
                    ResultSetMetaData metaData = rset.getMetaData();

                    // names of columns
                    Vector<String> columnNames = new Vector<String>();
                    int columnCount = metaData.getColumnCount();
                    for (int column = 1; column <= columnCount; column++) {
                        columnNames.add(metaData.getColumnName(column));
                    }
                    // data of the table
                    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
                    while (rset.next()) {
                        Vector<Object> vector = new Vector<Object>();
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            //if(rset.getObject(columnIndex))
                            vector.add(rset.getObject(columnIndex));
                        }
                        data.add(vector);
                    }

                    DefaultTableModel model = new DefaultTableModel(data, columnNames);
                    Table_Resultat.setModel(model);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
}


