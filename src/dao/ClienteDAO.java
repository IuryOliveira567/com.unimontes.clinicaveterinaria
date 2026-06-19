/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Cliente;
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
public class ClienteDAO {
    private Connection con;
    
    public ClienteDAO() {        
        try {
            this.con = Conexao.conectar();
        } catch(Exception e) {  
            System.out.println(e.getMessage());
        }
    }
    
    public boolean salvar(Cliente cliente) {
        String sql_query = "INSERT INTO clientes(nome, cpf, telefone, email) VALUES(?, ?, ?, ?)";
 
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getEmail());
            
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean apagarCliente(Cliente cliente) {
        String sql_query = "DELETE FROM clientes where nome=?";
        
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            String id = String.valueOf(cliente.getNome());
            pst.setString(1, id);
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql_query = "SELECT * FROM clientes";
        
        try(Connection con = Conexao.conectar();
            PreparedStatement pst = con.prepareStatement(sql_query);
            ResultSet rs = pst.executeQuery()) {

            while(rs.next()) {

                Cliente c = new Cliente();
               
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                
                clientes.add(c);
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return clientes;
    }
    
    public boolean atualizaCliente(Cliente cliente) {
        String sql_query = "UPDATE clientes set nome=?, cpf=?, telefone=?, email=? where id=?";
        
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getEmail());
            
            String id = String.valueOf(cliente.getId());
            pst.setString(5, id);
            
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}