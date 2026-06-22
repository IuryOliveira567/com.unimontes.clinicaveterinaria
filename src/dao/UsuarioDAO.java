/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Usuario;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author admin
 */
public class UsuarioDAO {
    private Connection con;
    
    public UsuarioDAO() {        
        try {
            this.con = Conexao.conectar();
        } catch(Exception e) {  
            System.out.println(e.getMessage());
        }
    }
    
    public boolean salvar(Usuario usuario) {
        String sql_query = "INSERT INTO usuarios(nome, login, senha) VALUES(?, ?, ?)";
 
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getLogin());
            pst.setString(3, usuario.getSenha());
            
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean apagar(Usuario usuario) {
        String sql_query = "DELETE FROM usuarios WHERE id=?";
  
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            String id = String.valueOf(usuario.getId());
            pst.setString(1, id);
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
     
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql_query = "SELECT * FROM usuarios";
        
        try(Connection con = Conexao.conectar();
            PreparedStatement pst = con.prepareStatement(sql_query);
            ResultSet rs = pst.executeQuery()) {

            while(rs.next()) {

                Usuario u = new Usuario();
               
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                
                usuarios.add(u);
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return usuarios;
    }
    
    public boolean atualizar(Usuario usuario) {
        String sql_query = "UPDATE usuarios set nome=?, login=?, senha=? where id=?";
        
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getLogin());
            pst.setString(3, usuario.getSenha());
            
            String id = String.valueOf(usuario.getId());
            pst.setString(4, id);
            
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
