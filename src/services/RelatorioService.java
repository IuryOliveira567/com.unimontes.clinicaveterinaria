/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import model.Cliente;
import model.Animal;
import model.Consulta;
import model.Veterinario;
import controller.AnimalController;
import controller.VeterinarioController;
import controller.ConsultaController;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
/**
 *
 * @author admin
 */
public class RelatorioService {
    private AnimalController animalController;
    private VeterinarioController veterinarioController;
    private ConsultaController consultaController;
    
    public RelatorioService() {
        this.animalController = new AnimalController();
        this.consultaController = new ConsultaController();
    }

    public List<Animal> GeraAnimaisPorCliente(String nome) {
        return this.animalController.obterAnimaisPorNome(nome);
    }
    
    public List<Consulta> GeraConsultasPorVeterinario(String veterinario) {
        return this.consultaController.obterConsultasPorVeterinario(veterinario);
    }
    
    public List<Consulta> GeraConsultasPorPeriodo(String data_inicial, String data_final) {
        return this.consultaController.obterConsultasPorPeriodo(data_inicial, data_final);
    }
}
