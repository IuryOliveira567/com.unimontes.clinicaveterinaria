/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Veterinario;
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
public class VeterinarioDAO {
    private Connection con;
    
    public VeterinarioDAO() {
        try {
            this.con = Conexao.conectar();
        } catch(Exception e) {  
            System.out.println(e.getMessage());
        }
    }
       
    public boolean salvar(Veterinario veterinario) {
        String sql_query = "INSERT INTO veterinarios(nome, crmv, telefone) VALUES(?, ?, ?)";
 
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            
            pst.setString(1, veterinario.getNome());
            pst.setString(2, veterinario.getCrmv());
            pst.setString(3, veterinario.getTelefone());
            
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean apagar(Veterinario veterinario) {
        String sql_query = "DELETE FROM veterinarios WHERE id=?";
  
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            String id = String.valueOf(veterinario.getId());
            pst.setString(1, id);
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
     
    public List<Veterinario> listar() {
        List<Veterinario> veterinarios = new ArrayList<>();
        String sql_query = "SELECT * FROM veterinarios";
        
        try(Connection con = Conexao.conectar();
            PreparedStatement pst = con.prepareStatement(sql_query);
            ResultSet rs = pst.executeQuery()) {

            while(rs.next()) {

                Veterinario v = new Veterinario();
               
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setCrmv(rs.getString("crmv"));
                v.setTelefone(rs.getString("telefone"));
                
                veterinarios.add(v);
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return veterinarios;
    }
    
    public boolean atualizar(Veterinario veterinario) {
        String sql_query = "UPDATE veterinarios set nome=?, crmv=?, telefone=? where id=?";
        
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            
            pst.setString(1, veterinario.getNome());
            pst.setString(2, veterinario.getCrmv());
            pst.setString(3, veterinario.getTelefone());
            
            String id = String.valueOf(veterinario.getId());
            pst.setString(4, id);
            
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
