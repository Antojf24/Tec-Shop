package es.tecshop.beans;

import java.io.Serializable;

/**
 * @author janto
 */
public class Product implements Serializable{
    
    private short idProducto;
    private short idCategoria;
    private String nombre;
    private String descripcion;
    private double precio;
    private String marca;
    private String imagen;

    /**
     *
     * @return
     */
    public short getIdProducto() {
        return idProducto;
    }

    /**
     *
     * @param idProducto
     */
    public void setIdProducto(short idProducto) {
        this.idProducto = idProducto;
    }

    /**
     *
     * @return
     */
    public short getIdCategoria() {
        return idCategoria;
    }

    /**
     *
     * @param idCategoria
     */
    public void setIdCategoria(short idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     * @return
     */
    public String getImagen() {
        return imagen;
    }

    /**
     *
     * @param imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
