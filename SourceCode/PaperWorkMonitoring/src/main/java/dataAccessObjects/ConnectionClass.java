package dataAccessObjects;

import javax.swing.*;
import java.sql.*;

public class ConnectionClass {

    public static Connection connection;

    public  static Connection getConnection(){


        String dbName="freedbtech_dacar";
        String userName="freedbtech_rooter";
        String password="root123";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection= DriverManager.getConnection("jdbc:mysql://freedb.tech:3306/"+dbName,userName,password);
            JOptionPane.showMessageDialog(null,"ConnectionEstablised");

        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }

}
