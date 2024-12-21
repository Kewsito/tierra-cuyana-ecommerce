
package ecommerce.tierra.cuyana;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InterfazGrafica {
    private Controlador controlador;

    public InterfazGrafica(Controlador controlador) {
        this.controlador = controlador;

        JFrame frame = new JFrame("Tienda en Línea");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //PANEL PRINCIPAL
        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new BoxLayout(MainPanel,BoxLayout.Y_AXIS));
        
        //SECCION VER PRODUCTOS
        JPanel verProductosSeccion = new JPanel();
        verProductosSeccion.setLayout(new GridLayout(3,2)); //3 FILAS 2 COLUMNAS
        
        JLabel nombreLabel = new JLabel("Nombre del Producto:");
        JTextField nombreField = new JTextField(20);
        JLabel precioLabel = new JLabel("Precio del Producto:");
        JTextField precioField = new JTextField(20);

        verProductosSeccion.add(nombreLabel);
        verProductosSeccion.add(nombreField);
        verProductosSeccion.add(precioLabel);
        verProductosSeccion.add(precioField);
        
        //BOTON DE VER PRODUCTOS
        JButton verProductosButton = new JButton("Ver Productos");
        MainPanel.add(verProductosButton);
        frame.add(MainPanel);

        verProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Llamar al controlador para que obtenga los productos
                    controlador.verProductos();
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazGrafica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //BOTON DE AGREGAR PRODUCTO
        JButton agregarProductoButton = new JButton("Agregar Producto");
        MainPanel.add(agregarProductoButton);
        frame.add(MainPanel);
        
        agregarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controlador.agregarProducto();
            }
        });
        
        
        

        frame.setVisible(true);
    }

   
}
