/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ericc
 */
public class GestionConnection {

    private static String url = "jdbc:mysql://localhost/expense_gr";
    private static String login = "root";
    private static String mdp = "";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static Connection laConnection = null;

    public GestionConnection() {
        try {
            /*Pour se connecter à une base de données, il faut charger le driver
qui fait le lien entre le programme et la base de données
             */
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problème de driver" + ex.getMessage());
        }

        try {
            laConnection = DriverManager.getConnection(url, login, mdp);
        } catch (SQLException ex) {
            System.out.println("Problème de BDD" + ex.getMessage());
        }

    }
    
    public static Connection getLaConnection() {
        if(laConnection==null) {
            new GestionConnection();
        }
        return laConnection;
    }
    
    public static void liberer() throws SQLException {
        laConnection.close();
        laConnection=null;
    }
}
