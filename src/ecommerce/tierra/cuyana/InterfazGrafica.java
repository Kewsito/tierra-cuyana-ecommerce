
package ecommerce.tierra.cuyana;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InterfazGrafica {
    private Controlador controlador;
    
    public InterfazGrafica(Controlador controlador) {
        this.controlador = controlador;

        JFrame frame = new JFrame("Tienda en Línea");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Crear un JTabbedPane para las pestañas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Crear el panel para la pestaña de productos
        JPanel productosPanel = new JPanel();
        productosPanel.setLayout(new BorderLayout());

        // Crear un panel para los botones dentro de la pestaña de productos
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Botón de ver productos
        JButton verProductosButton = new JButton("Ver Productos");
        buttonPanel.add(verProductosButton);

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

        // Botón de agregar producto
        JButton agregarProductoButton = new JButton("Agregar Producto");
        buttonPanel.add(agregarProductoButton);

        agregarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.agregarProducto();
            }
        });

        // Agregar el panel de botones al panel de productos
        productosPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar el panel de productos al tabbedPane
        tabbedPane.addTab("Productos", productosPanel);

        // Agregar el tabbedPane al mainPanel
        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    
}
