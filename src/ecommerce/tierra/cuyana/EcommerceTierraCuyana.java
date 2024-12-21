
package ecommerce.tierra.cuyana;

import java.sql.SQLException;

public class EcommerceTierraCuyana {
    public static void main(String[] args) throws SQLException {
        //conexion BD
        ConexionBD con = new ConexionBD();
        
         // Crear la vista (interfaz gráfica)
         
         // Se pasa un controlador nulo temporal
        InterfazGrafica vista = new InterfazGrafica(null); 
        
        // Crear el controlador
        Controlador controlador = new Controlador(vista, con);
        
        // Pasar el controlador a la vista
        vista = new InterfazGrafica(controlador);
    }
    
}
