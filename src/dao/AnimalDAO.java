/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import util.Conexao;
import java.sql.Connection;
import model.Animal;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author admin
 */
public class AnimalDAO {
    private Connection con;
   
   
    public AnimalDAO() {
       try {
           this.con = Conexao.conectar();
       } catch(Exception e) {
           System.out.println(e.getMessage());
       }
   }
   
    public boolean salvar(Animal animal) {
        String sql_query = "INSERT INTO animais(nome, sexo, idade, cliente_id, especie) VALUES(?, ?, ?, ?, ?)";
 
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            
            pst.setString(1, animal.getNome());
            pst.setString(2, animal.getSexo());
            
            String animal_idade = String.valueOf(animal.getIdade());
            String cliente_id = String.valueOf(animal.getClienteId());

            pst.setString(3, animal_idade);
            pst.setString(4, cliente_id);
            pst.setString(5, animal.getEspecie());
            
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
   
    public boolean apagar(Animal animal) {
        String sql_query = "DELETE FROM animais where id=?";
        
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            String id = String.valueOf(animal.getId());
            pst.setString(1, id);
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
   
    public List<Animal> listar() {
        List<Animal> animais = new ArrayList<>();
        String sql_query = "SELECT * FROM animais";
        
        try(Connection con = Conexao.conectar();
            PreparedStatement pst = con.prepareStatement(sql_query);
            ResultSet rs = pst.executeQuery()) {

            while(rs.next()) {

                Animal c = new Animal();
               
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setSexo(rs.getString("sexo"));
                c.setIdade(rs.getInt("idade"));
                c.setClienteId(rs.getInt("cliente_id"));
                c.setEspecie(rs.getString("especie"));                
                
                animais.add(c);
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return animais;
    }
   
    public boolean atualizar(Animal animal) {
        String sql_query = "UPDATE animais set nome=?, sexo=?, idade=?, cliente_id=?, especie=? where id=?";
        
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            
            pst.setString(1, animal.getNome());
            pst.setString(2, animal.getSexo());
            pst.setInt(3, animal.getIdade());
            pst.setInt(4, animal.getClienteId());
            pst.setString(5, animal.getEspecie());
            String id = String.valueOf(animal.getId());
            pst.setString(6, id);
            
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
   
    public List<Animal> animaisPorCliente(String nome) {
        String sql_query = "SELECT a.id, a.nome, a.sexo, a.idade, a.cliente_id, a.especie, c.nome AS cliente from animais a INNER JOIN clientes c ON c.id = a.cliente_id WHERE c.nome=?";
        
        List<Animal> animais = new ArrayList<>();

        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {

                Animal c = new Animal();
               
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setSexo(rs.getString("sexo"));
                c.setIdade(rs.getInt("idade"));
                c.setClienteId(rs.getInt("cliente_id"));
                c.setEspecie(rs.getString("especie"));
                c.setCliente(rs.getString("cliente"));
       
                animais.add(c);
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return animais;
    }
}
