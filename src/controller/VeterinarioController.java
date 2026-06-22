/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.VeterinarioDAO;
import model.Veterinario;
import java.util.List;
/**
 *
 * @author admin
 */
public class VeterinarioController {
    private VeterinarioDAO veterinarioDAO;
    
    public VeterinarioController() {
        this.veterinarioDAO = new VeterinarioDAO();
    }
    
    public boolean cadastraVeterinario(Veterinario veterinario) {
        return this.veterinarioDAO.salvar(veterinario);
    }
    
    public boolean atualizaVeterinario(Veterinario veterinario) {
        return this.veterinarioDAO.atualizar(veterinario);
    }
    
    public List<Veterinario> listaVeterinarios() {
        return this.veterinarioDAO.listar();
    }
    
    public boolean apagaVeterinario(Veterinario veterinario) {
        return this.veterinarioDAO.apagar(veterinario);
    }
}
