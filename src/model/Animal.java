/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Animal {
    private int id;
    private String nome;
    private String especie;
    private String sexo;
    private int idade;
    private int cliente_id;
    
    public Animal(int id, String nome, String especie, String raca, String sexo,
            int idade, double peso, String dataNascimento, String cor, int cliente_id) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.sexo = sexo;
        this.idade = idade;
        this.cliente_id = cliente_id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEspecie() {
        return this.especie;
    }
    
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public int getIdade() {
        return this.idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    public int getClienteId() {
        return this.cliente_id;
    }
    
    public void setClienteId(int cliente_id) {
        this.cliente_id = cliente_id;
    }   
}
