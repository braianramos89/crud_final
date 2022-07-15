package model;

public class Biblioteca {
    private int idproducto;
    private String producto;
    private String marca;
    private int vidaUtil;
    private double precio;
    private int copias;

    public Biblioteca(int idproducto, String producto, String marca, int vidaUtil, double precio, int copias) {
        this.idproducto = idproducto;
        this.producto = producto;
        this.marca = marca;
        this.vidaUtil = vidaUtil;
        this.precio = precio;
        this.copias = copias;
    }

    public Biblioteca(String producto, String marca, int vidaUtil, double precio, int copias) {
        this.producto = producto;
        this.marca = marca;
        this.vidaUtil = vidaUtil;
        this.precio = precio;
        this.copias = copias;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    @Override
    public String toString() {
        return "Libro{" + "producto=" + producto + ",  marca=" + marca + ", vidaUtil=" + vidaUtil + ", precio=" + precio + ", copias=" + copias + '}';
    }
}
