/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.AnimalDAO;
import model.Animal;
import java.util.List;

/**
 *
 * @author admin
 */
public class AnimalController {
    private AnimalDAO animalDAO;
    
    public AnimalController() {
        this.animalDAO = new AnimalDAO();
    }
    
    public boolean cadastraAnimal(Animal animal) {
        return this.animalDAO.salvar(animal);
    }
    
    public boolean atualizaAnimal(Animal animal) {
        return this.animalDAO.atualizar(animal);
    }
    
    public List<Animal> listaAnimais() {
        return this.animalDAO.listar();
    }
    
    public boolean apagaAnimal(Animal animais) {
        return this.animalDAO.apagar(animais);
    }
}
