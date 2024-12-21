package ecommerce.tierra.cuyana;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConexionBD {
    private String url = "jdbc:mysql://localhost:3306/ecommerce"; // URL de tu base de datos
    private String user = "root"; // Usuario de la base de datos
    private String password = "12345678"; // Contraseña de la base de datos

    public void insertarProducto(Productos producto) {
    String sql = "INSERT INTO productos (nombre, descripcion, precio, stock) VALUES (?, ?, ?, ?)";
    try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, producto.getNombre());
        stmt.setString(2, producto.getDescripcion());
        stmt.setDouble(3, producto.getPrecio());
        stmt.setInt(4, producto.getStock());

        int filasInsertadas = stmt.executeUpdate();
        System.out.println("Producto insertado con éxito, filas afectadas: " + filasInsertadas);
    } catch (SQLException e) {
        System.out.println("Error al insertar producto: " + e.getMessage());
    }
}   
    public List<Productos> mostrarProductos() throws SQLException{
        List<Productos> listaDeProductos = new ArrayList();
        String sql = "SELECT * FROM productos";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    double precio = rs.getDouble("precio");
                    int stock = rs.getInt("stock");
                    
                    //Creo el objeto
                    Productos producto = new Productos(nombre,descripcion,precio,stock);
                    
                    //Seteo el id que genero la bd
                    producto.setId(id);
                    
                    //Lo agrego a la lista de productos
                    listaDeProductos.add(producto);   
                }
        } catch (SQLException e){
            System.out.println("Error al obtener productos: " + e.getMessage());
        } 
        return listaDeProductos;
        

    }   
    public void actualizarProducto(Productos producto) throws SQLException{
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, stock = ? WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(url,user,password)){
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, producto.getNombre());
            stmt.setString(2,producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getStock());
            
            //Uso el id para identificar el producto
            stmt.setInt(5, producto.getId());
            
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas > 0 ){
                 System.out.println("Producto actualizado con éxito.");
            } else {
                System.out.println("No se encontró el producto con el ID: " + producto.getId());
            }
        } catch (SQLException e){
            System.out.println("Error al actualizar el producto: " + e.getMessage());
        } 
    }
    public void eliminarProducto(int productoId) {
        String sql = "DELETE FROM productos WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Establecer el valor del ID para la consulta SQL
            stmt.setInt(1, productoId);
            
            // Ejecutar la consulta de eliminación
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Producto eliminado con éxito.");
            } else {
                System.out.println("No se encontró el producto con el ID: " + productoId);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }
    
    public void testConexion(){ 
        try {
            // Establece la conexión con la base de datos
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("¡Conexión exitosa!");

            // Cierra la conexión después de usarla
            conn.close();
        } catch (SQLException e) {
            // Manejo de errores en caso de falla de conexión
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}   
