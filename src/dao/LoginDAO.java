/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Usuario;
import java.sql.Connection;
import util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author admin
 */
public class LoginDAO {
    private Connection con;
    
    public LoginDAO() {
        try {
            this.con = Conexao.conectar();
        } catch(Exception e) {  
            System.out.println(e.getMessage());
        }
    }
     
    public Usuario Autentica(String login, String senha) {
        String sql_query = "SELECT id, nome, login FROM usuarios WHERE login=? and senha=?";
        
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            
            pst.setString(1, login);
            pst.setString(2, senha);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("Login"));
                
                return usuario;
            }
         } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
}
