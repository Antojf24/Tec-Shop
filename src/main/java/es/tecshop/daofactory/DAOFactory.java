package es.tecshop.daofactory;

/**
 * @author janto
 */
public class DAOFactory {
    
    public IProductsDAO getProductsDAO(){
        return new ProductsDAO();
    }

    public IUsersDAO getUsersDAO(){
        return new UsersDAO();
    }
}
