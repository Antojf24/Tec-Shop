package es.tecshop.daofactory;

import es.tecshop.beans.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author janto
 */
public class UsersDAO implements IUsersDAO {

    /**
     * Comprueba que haya algún idUsuario que cumpla las condiciones.
     * @param columnName
     * @param data
     * @return true o false.
     */
    @Override
    public boolean alreadyInBD(String columnName, String data) {
        boolean emailExist = false;
        List<User> usuarios = new ArrayList<>();
        String consulta = "SELECT idUsuario FROM Usuarios WHERE " + columnName + "=?";
        ResultSet resultado = null;

        try {
            PreparedStatement preparada = null;
            preparada = ConnectionFactory.getConnection().prepareStatement(consulta);
            preparada.setString(1, data);
            usuarios = new ArrayList<>();
            resultado = preparada.executeQuery();
            while (resultado.next()) {
                User user = new User();
                user.setIdUsuario(resultado.getShort("idUsuario"));
                usuarios.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return emailExist;
    }

    /**
     * Método que registra un usuario.
     * @param user El usuario a registrar.
     */
    @Override
    public void registerUser(User user) {
        List<User> users = new ArrayList<>();
        String consultation = "INSERT INTO `Usuarios` (`Email`, `Password`, `Nombre`, `Apellidos`, `NIF`, `Telefono`, `Direccion`, `CodigoPostal`, `Localidad`, `Provincia`,`ultimoAcceso`,`Avatar`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement prepared = null;
            prepared = ConnectionFactory.getConnection().prepareStatement(consultation);
            prepared.setString(1, user.getEmail());
            prepared.setString(2, user.getPassword());
            prepared.setString(3, user.getNombre());
            prepared.setString(4, user.getApellidos());
            prepared.setString(5, user.getNif());
            prepared.setString(6, user.getTelefono());
            prepared.setString(7, user.getDireccion());
            prepared.setString(8, user.getCodigoPostal());
            prepared.setString(9, user.getLocalidad());
            prepared.setString(10, user.getProvincia());
            prepared.setDate(11, null);
            prepared.setString(12, user.getAvatar());
            int changedRow = prepared.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    /**
     * Obtiene los datos de un usuario, dados por parámetro su email y su contraseña.
     * @param email
     * @param password
     * @return user.
     */
    @Override
    public User getUser(String email, String password) {
        String consultation = "SELECT* FROM Usuarios WHERE Email=? AND Password=md5(?)";
        ResultSet result = null;
        User user = new User();
        try {
            PreparedStatement prepared = null;
            prepared = ConnectionFactory.getConnection().prepareStatement(consultation);
            prepared.setString(1, email);
            prepared.setString(2, password);
            result = prepared.executeQuery();
            while (result.next()) {
                user.setIdUsuario(result.getShort("idUsuario"));
                user.setEmail(result.getString("Email"));
                user.setNombre(result.getString("Nombre"));
                user.setApellidos(result.getString("Apellidos"));
                user.setNif(result.getString("NIF"));
                user.setTelefono(result.getString("Telefono"));
                user.setDireccion(result.getString("Direccion"));
                user.setCodigoPostal(result.getString("CodigoPostal"));
                user.setLocalidad(result.getString("Localidad"));
                user.setProvincia(result.getString("Provincia"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return user;
    }

    /**
     * Obtiene el usuario que tenga asociado el id pasado.
     * @param idUser
     * @return usuario.
     */
    public User getUserById(Short idUser) {
        String consultation = "SELECT * FROM Usuarios WHERE idUsuario=?";
        ResultSet result = null;
        User user = new User();
        try {
            PreparedStatement prepared = null;
            prepared = ConnectionFactory.getConnection().prepareStatement(consultation);
            prepared.setShort(1, idUser);
            result = prepared.executeQuery();
            while (result.next()) {
                user.setIdUsuario(result.getShort("idUsuario"));
                user.setEmail(result.getString("Email"));
                user.setNombre(result.getString("Nombre"));
                user.setApellidos(result.getString("Apellidos"));
                user.setNif(result.getString("NIF"));
                user.setTelefono(result.getString("Telefono"));
                user.setDireccion(result.getString("Direccion"));
                user.setCodigoPostal(result.getString("CodigoPostal"));
                user.setLocalidad(result.getString("Localidad"));
                user.setProvincia(result.getString("Provincia"));
                user.setAvatar(result.getString("Avatar"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
        return user;
    }

    /**
     * Método que actualiza los datos de un usuario.
     * @param user
     */
    @Override
    public void updateUser(User user) {
        String consultation = "";
        try {
            PreparedStatement prepared = null;
            if (user.getAvatar() == null) {
                consultation = "UPDATE Usuarios SET Nombre =?, Apellidos=?, telefono = ?,  direccion = ?,  localidad = ?,  codigoPostal = ?,  provincia =? WHERE idUsuario = ?";
                prepared = ConnectionFactory.getConnection().prepareStatement(consultation);
                prepared.setString(1, user.getNombre());
                prepared.setString(2, user.getApellidos());
                prepared.setString(3, user.getTelefono());
                prepared.setString(4, user.getDireccion());
                prepared.setString(5, user.getLocalidad());
                prepared.setString(6, user.getCodigoPostal());
                prepared.setString(7, user.getProvincia());
                prepared.setShort(8, user.getIdUsuario());
            } else {
                consultation = "UPDATE Usuarios SET Nombre =?, Apellidos=?, telefono = ?,  direccion = ?,  localidad = ?,  codigoPostal = ?,  provincia =?,  avatar=?  WHERE idUsuario = ?";
                prepared = ConnectionFactory.getConnection().prepareStatement(consultation);
                prepared.setString(1, user.getNombre());
                prepared.setString(2, user.getApellidos());
                prepared.setString(3, user.getTelefono());
                prepared.setString(4, user.getDireccion());
                prepared.setString(5, user.getLocalidad());
                prepared.setString(6, user.getCodigoPostal());
                prepared.setString(7, user.getProvincia());
                prepared.setString(8, user.getAvatar());
                prepared.setShort(9, user.getIdUsuario());
            }
            int changedRow = prepared.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    /**
     * Método que actuliza el último acceso del usuario cuando inicia sesión.
     * @param access
     * @param idUser
     */
    @Override
    public void lastAccess(Timestamp access, short idUser) {
        String consultation = "";

        try {
            PreparedStatement prepared = null;
            consultation = "UPDATE Usuarios SET UltimoAcceso =? WHERE idUsuario = ?";
            prepared = ConnectionFactory.getConnection().prepareStatement(consultation);
            prepared.setString(1, access.toString());
            prepared.setShort(2, idUser);
            int changedRow = prepared.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    /**
     *
     */
    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }
}
