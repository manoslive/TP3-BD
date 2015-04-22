package PkgEmployesClg;

import oracle.jdbc.OracleTypes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

/**
 * Created by shaun on 2015-04-21.
 */
public class ListeLivresPlusEmprunte {
    private JTable Table_Livres;
    public JPanel panel1;
    Connection connection;
    ResultSet rset;
    public ListeLivresPlusEmprunte(Connection conn)
    {
        connection = conn;

        try {
            CallableStatement stm = connection.prepareCall("{ ? = call BIBLIOTHEQUE.AFFICHERLESLIVRESPOPULAIRES()}");
            stm.registerOutParameter(1, OracleTypes.CURSOR);
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

            DefaultTableModel model = new DefaultTableModel(data,columnNames);
            Table_Livres.setModel(model);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
