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
    private String data;
    private String hora;
    private String animal;
    private String veterinario;
    private String descricao;
    
    public Consulta(int id, String data, String hora, String animal, String veterinario, String descricao) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.animal = animal;
        this.veterinario = veterinario;
        this.descricao = descricao;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String getHora() {
        return this.hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public String animal() {
        return this.animal;
    }
    
    public void setAnimal(String animal) {
        this.animal = animal;
    }
    
    public String getVeterinario() {
        return this.veterinario;
    }
    
    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
