package es.tecshop.controllers;

import es.tecshop.beans.Product;
import es.tecshop.daofactory.DAOFactory;
import es.tecshop.daofactory.IProductsDAO;
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
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

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
        request.getRequestDispatcher("").forward(request, response);
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
        String url = "";

        String option = request.getParameter("option");

        switch (option) {
            case "Tienda":
                url = "JSP/shop.jsp";
                DAOFactory daof = new DAOFactory();
                IProductsDAO pDao = daof.getProductsDAO();
                
                List<Product> products = new ArrayList<>();
                products = pDao.getAllProducts();
                request.setAttribute("products", products);
                break;
            case "Area Personal":
                url = "JSP/personal.jsp";
                break;
            case "Iniciar Sesion":
                url = "JSP/signUp.jsp";
                break;
            case "Registrarse":
                url = "JSP/logIn.jsp";
                break;
        }

        request.getRequestDispatcher(url).forward(request, response);
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
