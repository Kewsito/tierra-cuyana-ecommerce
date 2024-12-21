/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.tierra.cuyana;

/**
 *
 * @author kewsito
 */
public class Productos{
    private int id;
    private String nombre;
    private double precio;
    private String descripcion;
    private int stock;

    public Productos(String nombre, String descripcion, double precio , int stock){
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    //Get
    public int getId(){
        return this.id;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public double getPrecio(){
        return this.precio;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getStock(){
        return this.stock;
    }
    
    //Set
    public void setId(int newV){
        this.id = newV;
    }
    public void setDescripcion(String Newv){
        this.descripcion = Newv;
    }
    
    public void setPrecio(double Newv){
        this.precio = Newv;
    }
    
    public void setNombre(String Newv){
        this.nombre = Newv;
    }
    public void setStock(int Newv){
        this.stock = Newv;
    }
    //toString
    @Override
    public String toString(){
        return "ID: "+this.id +" Nombre: "+this.nombre+" Descripcion: "+this.descripcion + " Precio: " +this.precio + " Stock: "+this.stock;
    }
}
