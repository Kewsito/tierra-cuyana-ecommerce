/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.tierra.cuyana;
/**
 *
 * @author kewsito
 */
import java.util.ArrayList;

public class carritoClass {
    private ArrayList<Productos> productos;
    
    public carritoClass(){
        this.productos = new ArrayList<>();
    }
    
    
    //Funciones del carrito
    public void mostrarCarrito(){
        if (productos.isEmpty()){
            System.out.println("No tienes nada en tu carro");
        } else{
            System.out.println("Estos articulos tienes actualmente en tu carro");
            for (Productos producto: productos){
                System.out.println(producto);
            }
        }
    }
    
    public void agregarProductos(Productos unProducto){
        this.productos.add(unProducto);
        System.out.println("Agregaste este producto:"+unProducto);
        this.mostrarCarrito();
    }
    
    public void sacarUltimoProducto(){
        if (productos.isEmpty()){
            System.out.println("No tienes nada que sacar");
        } else{
            System.out.println("CARRITO ACTUAL");
            this.mostrarCarrito();
            System.out.println("SACANDO PRODUCTO..");
            productos.removeLast();
            System.out.println("PRODUCTO SACADO.");
            System.out.println("CARRITO ACTUAL");
            this.mostrarCarrito();
        }
    }
    
    public void total(){
        if (productos.isEmpty()){
            System.out.println("El carro esta vacio");
        }else{
            System.out.println("El total es:"+this.CalcularTotal());
        }
    }
    
    public double CalcularTotal(){
        double suma = productos.stream().mapToDouble(Productos::getPrecio).sum();
        return suma;
    }
}
