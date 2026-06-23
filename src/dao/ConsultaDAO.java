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
}
