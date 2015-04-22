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
public class ConsulterLivresParGenre {
    private JTextField TB_Genre;
    private JButton BTN_Rechercher;
    public JPanel panel1;
    private JTable TABLE_List;
    Connection connection;
    ResultSet rset;
    public ConsulterLivresParGenre(Connection conn)
    {
        connection = conn;

        BTN_Rechercher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CallableStatement stm = connection.prepareCall("{ ? = call BIBLIOTHEQUE.AFFICHERLISTELIVRES(?)}");
                    stm.registerOutParameter(1, OracleTypes.CURSOR);
                    stm.setString(2, TB_Genre.getText());
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
                    TABLE_List.setModel(model);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
}
