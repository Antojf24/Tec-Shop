package es.tecshop.controllers;

import es.tecshop.beans.Product;
import es.tecshop.beans.User;
import es.tecshop.daofactory.DAOFactory;
import es.tecshop.daofactory.IProductsDAO;
import es.tecshop.daofactory.UsersDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author janto
 */
@WebServlet(name = "FirstLoad", urlPatterns = {"/FirstLoad"})
public class FirstLoad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOFactory daof = new DAOFactory();
        IProductsDAO pDao = daof.getProductsDAO();
        
        List<Product> products = new ArrayList<>();
        products = pDao.getProducts();
        request.setAttribute("products", products);
        
//        Si el usuario esta registrado se recoge su id y con el se saca su nombre de la base de datos.
//        Dicho nombre aparece en el navegador de la página y se usa como boton para las opciones de cerrar sesión y modificar tus datos.
        if(request.getSession().getAttribute("idUser")!=null){
            short idUser = Short.parseShort(String.valueOf(request.getSession().getAttribute("idUser")));
            UsersDAO userDao = new UsersDAO();
            User user = userDao.getUserById(idUser);
            request.setAttribute("name",user.getNombre());
        }
        
        request.getRequestDispatcher("JSP/principal.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
