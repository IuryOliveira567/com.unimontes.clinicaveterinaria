/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Consulta;
import dao.ConsultaDAO;
import java.util.List;
/**
 *
 * @author admin
 */
public class ConsultaController {
    private ConsultaDAO consultaDAO;
    
    public ConsultaController() {
        this.consultaDAO = new ConsultaDAO();
    }
  
    public boolean cadastraConsulta(Consulta consulta) {
        return this.consultaDAO.salvar(consulta);
    }
    
    public boolean atualizaConsulta(Consulta consulta) {
        return this.consultaDAO.atualizar(consulta);
    }
    
    public List<Consulta> listaConsultas() {
        return this.consultaDAO.listar();
    }
    
    public boolean apagaConsulta(Consulta consulta) {
        return this.consultaDAO.apagar(consulta);
    }
}
