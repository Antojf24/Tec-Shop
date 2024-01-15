package es.tecshop.daofactory;

import es.tecshop.beans.Product;
import java.util.List;

/**
 * @author janto
 */
public interface IProductsDAO {
    
    public List<Product> getProducts();
    
    public List<Product> getAllProducts();
    
    public void closeConnection();
}
