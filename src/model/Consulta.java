/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Consulta {
    private int id;
    private String data_consulta;
    private String hora_consulta;
    private String descricao;
    private int animal_id;
    private int veterinario_id;
    private int id_cliente;
    private String veterinario;
    private String animal;
    private String cliente;
    
    public Consulta() {}
    
    public Consulta(String data_consulta, String hora_consulta, String descricao, int animal_id, int veterinario_id, int id_cliente) {
        this.data_consulta = data_consulta;
        this.hora_consulta = hora_consulta;
        this.descricao = descricao;
        this.animal_id = animal_id;
        this.veterinario_id = veterinario_id;
        this.id_cliente = id_cliente;
    }
    
    public Consulta(int id, String data_consulta, String hora_consulta, String descricao, int animal_id, int veterinario_id, int id_cliente) {
        this.id = id;
        this.data_consulta = data_consulta;
        this.hora_consulta = hora_consulta;
        this.descricao = descricao;
        this.animal_id = animal_id;
        this.veterinario_id = veterinario_id;
        this.id_cliente = id_cliente;
    }
    
    public Consulta(int id, String data_consulta, String hora_consulta, String descricao, int animal_id, int veterinario_id, int id_cliente, String veterinario) {
        this.id = id;
        this.data_consulta = data_consulta;
        this.hora_consulta = hora_consulta;
        this.descricao = descricao;
        this.animal_id = animal_id;
        this.veterinario_id = veterinario_id;
        this.id_cliente = id_cliente;
        this.veterinario = veterinario;
    }
    
    public Consulta(int id, String data_consulta, String hora_consulta, String descricao, int animal_id, int veterinario_id, int id_cliente, String veterinario, String animal, String cliente) {
        this.id = id;
        this.data_consulta = data_consulta;
        this.hora_consulta = hora_consulta;
        this.descricao = descricao;
        this.animal_id = animal_id;
        this.veterinario_id = veterinario_id;
        this.id_cliente = id_cliente;
        this.veterinario = veterinario;
        this.animal = animal;
        this.cliente = cliente;
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDataConsulta() {
        return this.data_consulta;
    }
    
    public void setDataConsulta(String data_consulta) {
        this.data_consulta = data_consulta;
    }
    
    public String getHoraConsulta() {
        return this.hora_consulta;
    }
    
    public void setHoraConsulta(String hora_consulta) {
        this.hora_consulta = hora_consulta;
    }
    
    public int getAnimalId() {
        return this.animal_id;
    }
    
    public void setAnimalId(int animal_id) {
        this.animal_id = animal_id;
    }
    
    public int getVeterinarioId() {
        return this.veterinario_id;
    }
    
    public void setVeterinarioId(int veterinario_id) {
        this.veterinario_id = veterinario_id;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getClienteId() {
        return this.id_cliente;
    }
    
    public void setClienteId(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public String getVeterinario() {
        return this.veterinario;
    }
    
    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }
    
    public String getAnimal() {
        return this.animal;
    }
    
    public void setAnimal(String animal) {
        this.animal = animal;
    }
    
    public String getCliente() {
        return this.cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}