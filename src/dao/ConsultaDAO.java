/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Consulta;
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
public class ConsultaDAO {    
    private Connection con;
    
    public ConsultaDAO() {
        try {
            this.con = Conexao.conectar();
        } catch(Exception e) {  
            System.out.println(e.getMessage());
        }
    }
  
    public boolean apagar(Consulta consulta) {
        String sql_query = "DELETE FROM consultas WHERE id=?";
  
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            String id = String.valueOf(consulta.getId());
            pst.setString(1, id);
            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean salvar(Consulta consulta) {
        String sql_query = "INSERT INTO consultas(data_consulta, hora_consulta, descricao, animal_id, veterinario_id, cliente_id) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            
            pst.setString(1, consulta.getDataConsulta());
            pst.setString(2, consulta.getHoraConsulta());
            pst.setString(3, consulta.getDescricao());
            pst.setInt(4, consulta.getAnimalId());
            pst.setInt(5, consulta.getVeterinarioId());
            pst.setInt(6, consulta.getClienteId());

            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<Consulta> listar() {
        List<Consulta> consultas = new ArrayList<>();
        String sql_query = "SELECT * FROM consultas";
        
        try(Connection con = Conexao.conectar();
            PreparedStatement pst = con.prepareStatement(sql_query);
            ResultSet rs = pst.executeQuery()) {

            while(rs.next()) {

                Consulta c = new Consulta();
               
                c.setId(rs.getInt("id"));
                c.setDataConsulta(rs.getString("data_consulta"));
                c.setHoraConsulta(rs.getString("hora_consulta"));
                c.setDescricao(rs.getString("descricao"));
                c.setAnimalId(rs.getInt("animal_id"));
                c.setVeterinarioId(rs.getInt("veterinario_id"));
                c.setClienteId(rs.getInt("cliente_id"));

                consultas.add(c);
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return consultas;
    }
    
    public boolean atualizar(Consulta consulta) {
        String sql_query = "UPDATE consultas set data_consulta=?, hora_consulta=?, descricao=?, animal_id=?, veterinario_id=?, cliente_id=? where id=?";
        
        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            
            pst.setString(1, consulta.getDataConsulta());
            pst.setString(2, consulta.getHoraConsulta());
            pst.setString(3, consulta.getDescricao());
            pst.setInt(4, consulta.getAnimalId());
            pst.setInt(5, consulta.getVeterinarioId());
            pst.setInt(6, consulta.getClienteId());
            pst.setInt(7, consulta.getId());

            pst.executeUpdate();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<Consulta> ConsultasPorVeterinario(String veterinario) {
        String sql_query = "SELECT co.id, co.data_consulta, co.hora_consulta, co.descricao, co.animal_id, co.cliente_id, co.veterinario_id, v.nome AS veterinario FROM consultas co INNER JOIN veterinarios v ON v.id = co.veterinario_id WHERE v.nome=?";
        
        List<Consulta> consultas = new ArrayList<>();

        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            pst.setString(1, veterinario);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {

                Consulta c = new Consulta();
               
                c.setId(rs.getInt("id"));
                c.setDataConsulta(rs.getString("data_consulta"));
                c.setHoraConsulta(rs.getString("hora_consulta"));
                c.setDescricao(rs.getString("descricao"));
                c.setAnimalId(rs.getInt("animal_id"));
                c.setClienteId(rs.getInt("cliente_id"));                
                c.setVeterinarioId(rs.getInt("veterinario_id"));
                c.setVeterinario(rs.getString("veterinario"));
                
                consultas.add(c);
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return consultas;
    }
    
    public List<Consulta> ConsultasPorPeriodo(String data_inicial, String data_final) {
            
        String sql_query = "SELECT co.id, co.data_consulta, co.hora_consulta, co.descricao, co.animal_id, co.veterinario_id, co.cliente_id, a.nome AS animal, c.nome AS cliente, v.nome AS veterinario FROM consultas co INNER JOIN animais a ON a.id=co.animal_id INNER JOIN clientes c ON c.id=co.cliente_id INNER JOIN veterinarios v ON v.id=co.veterinario_id WHERE co.data_consulta BETWEEN ? AND ?";
        
        List<Consulta> consultas = new ArrayList<>();

        try {
            PreparedStatement pst = this.con.prepareStatement(sql_query);
            pst.setString(1, data_inicial);
            pst.setString(2, data_final);
                        
            ResultSet rs = pst.executeQuery();

            while(rs.next()) {

                Consulta c = new Consulta();
               
                c.setId(rs.getInt("id"));
                c.setDataConsulta(rs.getString("data_consulta"));
                c.setHoraConsulta(rs.getString("hora_consulta"));
                c.setDescricao(rs.getString("descricao"));
                c.setAnimal(rs.getString("animal"));
                c.setVeterinario(rs.getString("veterinario"));
                c.setCliente(rs.getString("cliente"));
                consultas.add(c);
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return consultas;
    }
}
