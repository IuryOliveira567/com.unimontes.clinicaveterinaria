/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.ClienteDAO;
import model.Cliente;
import java.util.List;
/**
 *
 * @author admin
 */
public class ClienteController {
    private ClienteDAO clienteDAO;
    
    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }
    
    public boolean cadastraCliente(Cliente cliente) {
        return this.clienteDAO.salvar(cliente);
    }
    
    public boolean atualizaCliente(Cliente cliente) {
        return this.clienteDAO.atualizar(cliente);
    }
    
    public List<Cliente> listaClientes() {
        return this.clienteDAO.listar();
    }
    
    public boolean apagaCliente(Cliente cliente) {
        return this.clienteDAO.apagar(cliente);
    }
}
