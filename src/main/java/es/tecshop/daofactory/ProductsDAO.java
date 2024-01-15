package es.tecshop.daofactory;

import es.tecshop.beans.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author janto
 */
public class ProductsDAO implements IProductsDAO {
    
    /**
     * Método que obtiene 6 productos de forma aleatoria.
     * @return Lista de productos.
     */
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String consultation = "SELECT Nombre,Imagen,Precio FROM productos ORDER BY RAND() LIMIT 6";
        try {
            Statement sentence = ConnectionFactory.getConnection().createStatement();
            ResultSet result = sentence.executeQuery(consultation);
            products = new ArrayList<>();
            while (result.next()) {
                Product product = new Product();
                product.setNombre(result.getString("Nombre"));
                product.setImagen(result.getString("Imagen"));
                product.setPrecio(result.getDouble("Precio"));
                products.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return products;
    }
    
    /**
     * Método que obtiene todos los productos.
     * @return Lista de productos.
     */
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String consultation = "SELECT Nombre,Imagen,Precio FROM productos";
        try {
            Statement sentence = ConnectionFactory.getConnection().createStatement();
            ResultSet result = sentence.executeQuery(consultation);
            products = new ArrayList<>();
            while (result.next()) {
                Product product = new Product();
                product.setNombre(result.getString("Nombre"));
                product.setImagen(result.getString("Imagen"));
                product.setPrecio(result.getDouble("Precio"));
                products.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return products;
    }
    
    /**
     *
     */
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }
}
