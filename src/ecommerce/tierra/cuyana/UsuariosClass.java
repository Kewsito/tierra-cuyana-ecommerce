/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.tierra.cuyana;

/**
 *
 * @author kewsito
 */
public class UsuariosClass {
    private String correo;
    private String username;
    private String password;
    
    public UsuariosClass(String correo, String username, String password){
        this.correo = correo;
        this.password = password;
        this.username = username;
    }
    
    
    // Getter para 'correo'
    public String getCorreo() {
        return correo;
    }

    // Setter para 'correo'
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Getter para 'username'
    public String getUsername() {
        return username;
    }

    // Setter para 'username'
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter para 'password'
    public String getPassword() {
        return password;
    }

    // Setter para 'password'
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void mostrarUsuario(){
        System.out.println("User: "+username+" password: "+password+" correo: "+correo);
    }
}
