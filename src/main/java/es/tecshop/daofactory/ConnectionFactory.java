package es.tecshop.daofactory;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author janto
 */
public class ConnectionFactory {

    private static Connection conexion = null;
    private static final String DATASOURCE_NAME = "java:comp/env/jdbc/TecShop";

    /*
    * Conecta con la base de datos.
    */
    public static Connection getConnection() {

        try {
            Context contextoInicial = new InitialContext();
            DataSource ds = (DataSource) contextoInicial.lookup(DATASOURCE_NAME);
            conexion = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

    /*
    * Cierra la conexión con la base de datos.
    */
    public static void closeConnection() {
        try {
            conexion.close();
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
