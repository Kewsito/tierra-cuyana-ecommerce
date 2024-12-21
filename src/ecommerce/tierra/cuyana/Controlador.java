/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.tierra.cuyana;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kewsito
 */
public class Controlador {
    private InterfazGrafica vista;
    private ConexionBD base;
    
    public Controlador(InterfazGrafica vista, ConexionBD base){
        this.base = base;
        this.vista = vista;
    }

    void verProductos() throws SQLException {
        //consulta a la base de datos
        List<Productos> productos = base.mostrarProductos();
        
        //Mostrar los productos en la vista (puedes pasar los productos como argumento)
        JOptionPane.showMessageDialog(null,"Productos: "+ productos.toString());
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    void agregarProducto() {
        
        JOptionPane.showMessageDialog(null,"Agregar producto funcion");
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
