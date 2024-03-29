package es.tecshop.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Filtra las paginas para que los carácteres especiales se muestren correctamente
 * @author janto
 */
@WebFilter(filterName = "UTF8", urlPatterns = {"/*"})
public class AUTF8 implements Filter {

    /**
     *
     * @param fConfig Parámetro inicial
     * @throws ServletException Excepción
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    /**
     *
     * @param request Petición
     * @param response Respuesta
     * @param chain Cambio
     * @throws IOException Excepción de entrada/salida
     * @throws ServletException Excepción
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF8");
        chain.doFilter(request, response);
    }

    /**
     *
     */
    @Override
    public void destroy() {
    }
}