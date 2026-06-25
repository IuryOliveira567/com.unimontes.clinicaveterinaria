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
        List<Animal> result = this.animalController.obterAnimaisPorNome(nome);
        System.out.println(result);
        return result;
    }
    
    public List<Consulta> GeraConsultasPorVeterinario(Veterinario veterinario) {
        List<Consulta> consultasPorVeterinario = new ArrayList<>();
        List<Consulta> consultas = this.consultaController.listaConsultas();
        
        for(Consulta consulta: consultas) {
            if(consulta.getVeterinarioId() == veterinario.getId()) {
                consultasPorVeterinario.add(consulta);
            }
        }
        
        return consultasPorVeterinario;
    }
    
    public List<Consulta> GeraConsultasPorPeriodo(String data_inicial, String data_final) {
        List<Consulta> consultas = consultaController.listaConsultas();
        List<Consulta> consultas_por_data = new ArrayList<>();
        
        LocalDate dataInicial = LocalDate.parse(data_inicial);
        LocalDate dataFinal = LocalDate.parse(data_final);
        
        for(Consulta consulta: consultas) {
            LocalDate dataConsulta = LocalDate.parse(consulta.getDataConsulta());
            if(!dataConsulta.isBefore(dataInicial) && !dataConsulta.isAfter(dataFinal)) {
                consultas_por_data.add(consulta);
            }
        }
        
        return consultas_por_data;
    }
}
