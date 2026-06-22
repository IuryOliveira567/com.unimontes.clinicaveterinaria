/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.UsuarioDAO;
import model.Usuario;
import java.util.List;
/**
 *
 * @author admin
 */
public class UsuarioController {
    private UsuarioDAO usuarioDAO;
    
    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public boolean cadastraUsuario(Usuario usuario) {
        return this.usuarioDAO.salvar(usuario);
    }
    
    public boolean atualizaUsuario(Usuario usuario) {
        return this.usuarioDAO.atualizar(usuario);
    }
    
    public List<Usuario> listaUsuarios() {
        return this.usuarioDAO.listar();
    }
    
    public boolean apagaUsuario(Usuario usuario) {
        return this.usuarioDAO.apagar(usuario);
    }
}
