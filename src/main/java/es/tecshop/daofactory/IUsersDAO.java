package es.tecshop.daofactory;

import es.tecshop.beans.User;
import java.sql.Timestamp;

/**
 * @author janto
 */
public interface IUsersDAO {

    public boolean alreadyInBD(String columnName, String data);

    public User getUser(String email, String password);

    public User getUserById(Short idUser);

    public void updateUser(User user);

    public void registerUser(User user);
    
    public void lastAccess(Timestamp access, short idUser);

    public void closeConnection();
}
