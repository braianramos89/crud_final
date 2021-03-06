package web;

import data.LibrosDAO;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.*;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        String accion = req.getParameter("accion");
        
        if(accion!=null){
            switch(accion){
                case "eliminar":
                    eliminarLibro(req,res);
                    break;
                case "editar":
                    editarLibro(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        }else{
            accionDefault(req, res);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse res)throws ServletException, IOException{
        String queryParam = req.getParameter("accion");
        if(queryParam!=null){
            switch(queryParam){
                case "insertar":
                    insertarLibro(req,res);
                    break;
                case "modificar":
                    modificarLibro(req,res);
                    break;
                default:
                    accionDefault(req,res);
                    break;
            }
        }
    }
    
    private void accionDefault(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        List <Biblioteca> libros = new LibrosDAO().findAll();
        libros.forEach(System.out::println);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("producto", libros);
        sesion.setAttribute("cantidadLibros",calcularCopias(libros));
        sesion.setAttribute("precioTotal", calcularPrecio(libros));
        req.getRequestDispatcher("libros.jsp").forward(req, res);
        res.sendRedirect("libros.jsp");
    }
    
    private void insertarLibro(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        String producto = req.getParameter("producto");
        String marca = req.getParameter("marca");
        int vidaUtil = Integer.parseInt(req.getParameter("vidaUtil"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int copias = Integer.parseInt(req.getParameter("copias"));
        
        Biblioteca libro = new Biblioteca(producto, marca, vidaUtil, precio, copias);
        
        int registrosMod = new LibrosDAO().insert(libro);
        
        System.out.println("insertados = " + registrosMod);
        
        accionDefault(req, res);
    }
    
    private void eliminarLibro(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        int idproducto = Integer.parseInt(req.getParameter("idproducto"));
        
        int regMod = new LibrosDAO().deleteLibro(idproducto);
        
        System.out.println("SE ELIMINARON: "+ regMod +" REGISTROS");
        
        accionDefault(req, res);
    }
    
    private void editarLibro(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        int idproducto = Integer.parseInt(req.getParameter("idproducto"));
        Biblioteca libro = new LibrosDAO().findById(idproducto);
        req.setAttribute("producto", libro);
        String jspEditar = "/WEB-INF/paginas/operaciones/editar.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, res);
    }
    
    private void modificarLibro(HttpServletRequest req , HttpServletResponse res)throws ServletException, IOException{
        String producto = req.getParameter("producto");
        String marca = req.getParameter("marca");
        int vidaUtil = Integer.parseInt(req.getParameter("vidaUtil"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int copias = Integer.parseInt(req.getParameter("copias"));
        
        int idproducto = Integer.parseInt(req.getParameter("idproducto"));
        
        Biblioteca lib = new Biblioteca(idproducto,producto,marca,vidaUtil,precio,copias);
        
        int regMod = new LibrosDAO().update(lib);
        
        System.out.println("SE ACTUALIZARON: "+ regMod +" REGISTROS");
        
        accionDefault(req, res);
    }
    
    private int calcularCopias(List<Biblioteca> lib){
        int cant=0;
        for (int i = 0; i < lib.size(); i++) {
            cant += lib.get(i).getCopias();
        }
        return cant;
    }
    
    private double calcularPrecio(List<Biblioteca> lib){
        double precio = 0;
        for (int i = 0; i < lib.size(); i++) {
            precio += (lib.get(i).getPrecio() * lib.get(i).getCopias());
        }
        return precio;
    }
}
